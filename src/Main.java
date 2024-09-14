public class Main {
    public static void main(String[] args) {
        Rider rider = new Rider(1, "Annoor Affana");
        Driver driver = new Driver(1, "Farhan Abid", "Car");
        RideType rideType = new Carpool();

        Trip trip = new Trip(1, rideType, "Pending", 15.0);
        trip.setPickupLocation("Mohammadpur");
        trip.setDropOffLocation("Iqbalroad");
        trip.setRider(rider);

        RideService rideService = new RideService();
        rider.requestRide(trip, rideService);

        driver.acceptRide(trip, new SMS());
        driver.startTrip(trip, new SMS());
        driver.completeTrip(trip, new SMS());

        rider.rateDriver(driver, 4.5);
        driver.rateRider(rider, 5.0);

        Admin admin = new Admin(1, "Admin", "Administrator");
        admin.viewTripHistory(trip);
        admin.handleDispute(trip, "Dispute Example");
        admin.manageDriver(driver, false);
        admin.manageDriver(driver, true);
        admin.manageRider(rider, false);
        admin.manageRider(rider, true);
    }
}
