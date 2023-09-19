package model;

public class Driver {
    private Integer driverID; // Sequential generation or Random UUID
    private String driverName;
    private Location location;
    private Double averageRating;

    public Location getLocation() {
        return location;
    }

    public Driver(String driverName, Location location) {
        this.driverName = driverName;
        this.location = location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
