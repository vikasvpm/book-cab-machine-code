package model;

public class User {
    private String userName;
    private Location location;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User(String userName, Location location) {
        this.userName = userName;
        this.location = location;
    }
}
