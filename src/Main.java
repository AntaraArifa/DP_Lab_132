import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        createRider(scanner);
        scanner.close();
    }

    private static void createRider(Scanner scanner) {
        System.out.println("Enter Rider ID:");
        int riderId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Rider Name:");
        String riderName = scanner.nextLine();

        System.out.println("Enter Payment Method (1 for Credit Card, 2 for PayPal):");
        int paymentChoice = scanner.nextInt();
        PaymentMethod paymentMethod = (paymentChoice == 1) ? new CreditCard() : new PayPal();

        Rider rider = new Rider(riderId, riderName, paymentMethod);

        System.out.println("Enter Pickup Location:");
        String pickupLocation = scanner.nextLine();

        System.out.println("Enter Drop-Off Location:");
        String dropOffLocation = scanner.nextLine();

        System.out.println("Enter Distance (in kilometers):");
        double distance = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        RideType rideType = new Carpool(); // Replace with a method to choose ride type if needed
        SendNotification notificationService = new SMS(); // Use any notification method

        Trip trip = rider.requestRide(rideType, pickupLocation, dropOffLocation, distance, notificationService);
        System.out.println("Initial fare: " + trip.calculateFare());

        // Option to change ride type
        System.out.println("Would you like to change the ride type? (yes/no)");
        String changeRide = scanner.nextLine();
        if (changeRide.equalsIgnoreCase("yes")) {
            rideType = new LuxuryRide(); // Replace with a method to choose new ride type
            trip.rideType = rideType; // You might want to create a setter method
            System.out.println("Updated fare: " + trip.calculateFare());
        }

        System.out.println("Enter Driver ID to rate:");
        int driverId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter Driver Rating (1 to 5):");
        double driverRating = scanner.nextDouble();
        Driver driver = new Driver(driverId, "Sample Driver", "Car");
        rider.rateDriver(driver, driverRating);

        rider.makePayment(trip.calculateFare());
        System.out.println("Rider has made payment of: " + trip.calculateFare());
    }
}
