public class Rider extends User {
    private PaymentMethod paymentMethod;

    public Rider(int id, String name, PaymentMethod paymentMethod) {
        this.id = id;
        this.name = name;
        this.paymentMethod = paymentMethod;
    }

    public void requestRide(Trip trip, RideService rideService) {
        rideService.requestRide(this, trip);
    }

    public void rateDriver(Driver driver, double rating) {
        driver.updateRating(rating);
    }

    public void makePayment(double amount) {
        paymentMethod.processPayment(amount);
    }

    public void changePaymentMethod(PaymentMethod newPaymentMethod) {
        this.paymentMethod = newPaymentMethod;
        System.out.println("Payment method changed successfully.");
    }
}
