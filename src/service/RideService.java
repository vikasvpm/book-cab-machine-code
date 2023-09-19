package service;

import constant.Constants;
import model.Driver;
import model.Ride;
import model.User;
import repository.RideRepository;

import java.util.*;

public class RideService {
    private RideRepository repository;

    public RideService(RideRepository repository) {
        this.repository = repository;
    }

    public Boolean addRide(String driver,Integer driverRating, String user, Integer userRating) {
        Ride ride = new Ride(driver, driverRating, user, userRating);
        repository.getRideList().add(ride);
        repository.getUserRideMap().putIfAbsent(user, new ArrayList<>());
        repository.getUserRideMap().get(user).add(ride);
        repository.getDriverRideMap().putIfAbsent(driver, new ArrayList<>());
        repository.getDriverRideMap().get(driver).add(ride);
        return true;
    }

    public void printEligibleDrivers(User user, List<Driver> availableDriver) {
        Double userRating = calculateUserRating(user.getUserName(), repository.getUserRideMap());
        List<Driver> eligibleDrivers = getEligibleDrivers( userRating, availableDriver, repository.getDriverRideMap(), repository.getUserRideMap().get(user.getUserName()));
        Collections.sort(eligibleDrivers, (a, b) -> Double.compare(b.getAverageRating(), a.getAverageRating()));
        System.out.println("User Rating : " + userRating);
        System.out.println("Eligible Drivers sorted by ratings");
        for(Driver driver : eligibleDrivers) {
            System.out.println("Driver : " + driver.getDriverName() + ", Rating : " + driver.getAverageRating());
        }
        Collections.sort(eligibleDrivers, (a, b) -> Double.compare(calculateDistance(a, user), calculateDistance(b, user)));
        System.out.println("Eligible Drivers sorted by distance");
        for(Driver driver : eligibleDrivers) {
            System.out.println("Driver : " + driver.getDriverName() + ", Rating : " + driver.getAverageRating());
        }
    }

    private Double calculateDistance(Driver driver, User user) {
        double distance = Math.sqrt(Math.pow(driver.getLocation().getX() - user.getLocation().getX(), 2)
                - Math.pow(driver.getLocation().getY() - user.getLocation().getY(), 2));
        return distance;
    }

    private List<Driver> getEligibleDrivers(Double userRating, List<Driver> availableDriver, Map<String, List<Ride>> driverRideMap, List<Ride> userRideList) {
        List<Driver> driverList = new ArrayList<>();
        for(Driver driver : availableDriver) {
            Double driverRating = calculateDriverRating(driverRideMap.get(driver.getDriverName()));
            driver.setAverageRating(driverRating);
            if(driverRating >= userRating) {
                driverList.add(driver);
            }
        }
        if(driverList.isEmpty()) {
            HashSet<String> driverHashSet = new HashSet<>();

            for(Driver driver : availableDriver) {
                driverHashSet.add(driver.getDriverName());
                repository.getDriverMap().put(driver.getDriverName(), driver);
            }
            for(Ride ride : userRideList) {
                if(driverHashSet.contains(ride.getDriver()) && ride.getDriverRating() > Constants.MIN_ACCEPTABLE_RATING) {
                    Driver driver = repository.getDriverMap().get(ride.getDriver());
                    driverList.add(driver);
                }
            }
        }
        return driverList;
    }

    private Double calculateDriverRating(List<Ride> rideList) {
        Integer ratingSum = 0;
        for(Ride ride : rideList) {
            ratingSum += ride.getDriverRating();
        }
        Double average = ((double) ratingSum / rideList.size());
        return average;
    }

    private Double calculateUserRating(String userName, Map<String, List<Ride>> userRideMap) {
        List<Ride> rideList = userRideMap.get(userName);
        Integer ratingSum = 0;
        for(Ride ride : rideList) {
            ratingSum += ride.getUserRating();
        }
        Double average = ((double) ratingSum / rideList.size());
        return average;
    }
}

