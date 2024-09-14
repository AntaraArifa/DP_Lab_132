public class Carpool implements RideType {
    public double calculateFare(double distance) {
        return distance * 2;
    }

    public String getTypeName() {
        return "Carpool";
    }
}
