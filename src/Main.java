import model.Driver;
import model.Location;
import model.User;
import repository.RideRepository;
import service.RideService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RideRepository rideRepository = new RideRepository();
        RideService rideService = new RideService(rideRepository);

        //History data
        rideService.addRide("d1", 4, "c1", 5);
        rideService.addRide("d1", 5, "c2", 5);
        rideService.addRide("d1", 1, "c3", 2);
        rideService.addRide("d2", 5, "c1", 1);
        rideService.addRide("d2", 5, "c2", 5);
        rideService.addRide("d2", 4, "c3", 5);
        rideService.addRide("d3", 3, "c1", 2);
        rideService.addRide("d3", 4, "c2", 5);
        rideService.addRide("d3", 3, "c3", 3);

        User user = new User("c2", new Location(1, 0));
        Driver d1 = new Driver("d1", new Location(1, 0));
        Driver d2 = new Driver("d2", new Location(2, 0));
        Driver d3 = new Driver("d3", new Location(3, 0));
        List<Driver> available = new ArrayList<>();
        available.add(d1);
        available.add(d2);
        available.add(d3);
        rideService.printEligibleDrivers(user, available);
    }
}