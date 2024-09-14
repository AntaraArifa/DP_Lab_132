public class Rider {
    public int id;
    public String name;
    public String location;
    public double rating;
    public String preferredPaymentMethod;

    public Rider(int id, String name) {
        this.id = id;
        this.name = name;
        this.location = null;
        this.rating = 0;
    }

    public void requestRide(Trip trip, RideService rideService) {
        rideService.requestRide(this, trip);
    }

    public void rateDriver(Driver driver, double rating) {
        driver.updateRating(rating);
    }

    public void makePayment(PaymentMethod paymentMethod, double amount) {
        paymentMethod.processPayment(amount);
    }

    public void updateRating(double newRating) {
        this.rating = (this.rating + newRating) / 2;
    }
}
