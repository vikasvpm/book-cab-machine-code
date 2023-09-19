package model;

public class Ride {

    private String driver;
    private Integer driverRating;
    private String user;
    private Integer userRating;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Integer getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(Integer driverRating) {
        this.driverRating = driverRating;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getUserRating() {
        return userRating;
    }

    public void setUserRating(Integer userRating) {
        this.userRating = userRating;
    }

    public Ride(String driver, Integer driverRating, String user, Integer userRating) {
        this.driver = driver;
        this.driverRating = driverRating;
        this.user = user;
        this.userRating = userRating;
    }
}
