public class Rider extends User {
    public PaymentMethod preferredPaymentMethod;

    public Rider(int id, String name, PaymentMethod paymentMethod) {
        this.id = id;
        this.name = name;
        this.preferredPaymentMethod = paymentMethod;
    }

    public Trip requestRide(RideType rideType, String pickupLocation, String dropOffLocation, double distance, SendNotification notificationMethod) {
        Trip trip = new Trip(1, rideType, "Pending", distance);
        trip.setPickupLocation(pickupLocation);
        trip.setDropOffLocation(dropOffLocation);
        trip.setRider(this);
        RideService rideService = new RideService();
        rideService.requestRide(this, trip);
        return trip;
    }

    public void rateDriver(Driver driver, double rating) {
        driver.updateRating(rating);
    }

    public void makePayment(double amount) {
        this.preferredPaymentMethod.processPayment(amount);
    }
}
