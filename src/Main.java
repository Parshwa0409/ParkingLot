import ENUMS.VehicleType;
import abstracts.IParkingSpot;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create parking lot with initial spots
        List<IParkingSpot> parkingSpots = new ArrayList<>(
                List.of(
                        new ParkingSpot(VehicleType.FourWheeler),
                        new ParkingSpot(VehicleType.FourWheeler),
                        new ParkingSpot(VehicleType.TwoWheeler),
                        new ParkingSpot(VehicleType.TwoWheeler),
                        new ParkingSpot(VehicleType.ThreeWheeler),
                        new ParkingSpot(VehicleType.ThreeWheeler)
                )
        );
        ParkingLot parkingLot = new ParkingLot(parkingSpots);
        ParkingLotManager manager = new ParkingLotManager(parkingLot);

        try {
            // Create vehicles of different types
            Vehicle car1 = new Vehicle("KA-37 EP-6452", VehicleType.FourWheeler);
            Vehicle bike1 = new Vehicle("KA-37 EP-6453", VehicleType.TwoWheeler);
            Vehicle car2 = new Vehicle("KA-37 EP-6454", VehicleType.FourWheeler);

            // Park vehicles
            System.out.println("\nParking vehicles...");
            Ticket carTicket1 = manager.parkVehicle(car1);
            System.out.println("Car1 parked in spot: " + carTicket1.getSpotAssigned().getSpotType());

            Ticket bikeTicket = manager.parkVehicle(bike1);
            System.out.println("Bike parked in spot: " + bikeTicket.getSpotAssigned().getSpotType());

            Ticket carTicket2 = manager.parkVehicle(car2);
            System.out.println("Car2 parked in spot: " + carTicket2.getSpotAssigned().getSpotType());

            // Show current status
            System.out.println("\nCurrent parking lot status:");
            System.out.println(manager.getReport().getFormattedReport());

            // Test different parking durations
            System.out.println("\nTesting different parking durations...");

            double cost1 = manager.unparkVehicle(car1.getLicensePlate());
            System.out.println("Car1 cost: $" + cost1);

            double cost2 = manager.unparkVehicle(bike1.getLicensePlate());
            System.out.println("Bike cost: $" + cost2);

            double cost3 = manager.unparkVehicle(car2.getLicensePlate());
            System.out.println("Car2 cost: $" + cost3);

            // Final status
            System.out.println("\nFinal parking lot status:");
            System.out.println(manager.getReport().getFormattedReport());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
