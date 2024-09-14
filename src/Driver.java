public class Driver {
    public int id;
    public String name;
    public String vehicleType;
    public String location;
    public double rating;
    public boolean availability;

    public Driver(int id, String name, String vehicleType) {
        this.id = id;
        this.name = name;
        this.vehicleType = vehicleType;
        this.location = null;
        this.rating = 0;
        this.availability = true;
    }

    public void acceptRide(Trip trip, SendNotification notificationMethod) {
        trip.assignDriver(this, notificationMethod);
        this.availability = false;
        NotificationService.sendNotification(notificationMethod, "Driver assigned: " + this.name);
    }

    public void rateRider(Rider rider, double rating) {
        rider.updateRating(rating);
    }

    public void updateLocation(String location) {
        this.location = location;
    }

    public void startTrip(Trip trip, SendNotification notificationMethod) {
        trip.startTrip(notificationMethod);
        NotificationService.sendNotification(notificationMethod, "Trip started by: " + this.name);
    }

    public void completeTrip(Trip trip, SendNotification notificationMethod) {
        trip.completeTrip(notificationMethod);
        this.availability = true;
        NotificationService.sendNotification(notificationMethod, "Trip completed by: " + this.name);
    }

    public void updateRating(double newRating) {
        this.rating = (this.rating + newRating) / 2;
    }
}
