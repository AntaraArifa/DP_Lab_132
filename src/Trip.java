public class Trip {
    private int id;
    private String pickupLocation;
    private String dropOffLocation;
    private RideType rideType;
    private String status;
    private double fare;
    private double distance;
    private Rider rider;
    private Driver driver;

    public Trip(int id, RideType rideType, String status, double distance) {
        this.id = id;
        this.pickupLocation = null;
        this.dropOffLocation = null;
        this.rideType = rideType;
        this.status = status;
        this.distance = distance;
    }

    public void calculateFare(){

    }
    public void assignDriver(){

    }
    public void completeTrip(){

    }
}