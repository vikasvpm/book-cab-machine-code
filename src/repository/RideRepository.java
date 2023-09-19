package repository;

import model.Driver;
import model.Ride;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
    private Map<String, List<Ride>> userRideMap;  // Auto
    private List<Ride> rideList;
    private Map<String, List<Ride>> driverRideMap;

    private Map<String, Driver> driverMap;

    public RideRepository() {
        this.userRideMap = new HashMap<>();
        this.rideList = new ArrayList<>();
        this.driverRideMap = new HashMap<>();
        this.driverMap = new HashMap<>();
    }

    public Map<String, List<Ride>> getDriverRideMap() {
        return driverRideMap;
    }

    public void setDriverRideMap(Map<String, List<Ride>> driverRideMap) {
        this.driverRideMap = driverRideMap;
    }

    public Map<String, Driver> getDriverMap() {
        return driverMap;
    }

    public void setDriverMap(Map<String, Driver> driverMap) {
        this.driverMap = driverMap;
    }


    public Map<String, List<Ride>> getUserRideMap() {
        return userRideMap;
    }

    public void setUserRideMap(Map<String, List<Ride>> userRideMap) {
        this.userRideMap = userRideMap;
    }

    public List<Ride> getRideList() {
        return rideList;
    }

    public void setRideList(List<Ride> rideList) {
        this.rideList = rideList;
    }
}
