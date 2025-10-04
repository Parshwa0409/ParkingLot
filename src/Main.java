import ENUMS.VehicleType;
import abstracts.IParkingSpot;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Create parking lot
        ParkingLot parkingLot = new ParkingLot();
        List<IParkingSpot> parkingSpots = new ArrayList<>(
                List.of(
                        new ParkingSpot(ENUMS.ParkingSpotType.FourWheelerSpot),
                        new ParkingSpot(ENUMS.ParkingSpotType.FourWheelerSpot),
                        new ParkingSpot(ENUMS.ParkingSpotType.TwoWheelerSpot),
                        new ParkingSpot(ENUMS.ParkingSpotType.ThreeWheelerSpot),
                        new ParkingSpot(ENUMS.ParkingSpotType.TwoWheelerSpot),
                        new ParkingSpot(ENUMS.ParkingSpotType.FourWheelerSpot)
                )
        );
        parkingLot.setParkingSpots(parkingSpots);

        ParkingLotManager manager = new ParkingLotManager(parkingLot);

        try {
            // Create vehicles of different types
            Vehicle car1 = new Vehicle("KA-37 EP-6452", VehicleType.FourWheeler);
            Vehicle bike1 = new Vehicle("KA-37 EP-6453", VehicleType.TwoWheeler);
            Vehicle car2 = new Vehicle("KA-37 EP-6454", VehicleType.FourWheeler);

            // Park vehicles
            System.out.println("\nParking vehicles...");
            Ticket carTicket1 = manager.parkVehicle(car1);
            System.out.println("Car1 parked in spot: " + carTicket1.spotAssigned.getSpotType());
            System.out.println("Tickets for parked vehicle:" + carTicket1);

            Ticket bikeTicket = manager.parkVehicle(bike1);
            System.out.println("Bike parked in spot: " + bikeTicket.spotAssigned.getSpotType());
            System.out.println("Tickets for parked vehicle:" + bikeTicket);

            Ticket carTicket2 = manager.parkVehicle(car2);
            System.out.println("Car2 parked in spot: " + carTicket2.spotAssigned.getSpotType());
            System.out.println("Tickets for parked vehicle:" + carTicket2);

            // Show current status
            System.out.println("\nCurrent parking lot status:");
            ParkingLotStatus status = manager.getReport();
            System.out.println(status.getFormattedReport());

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
            status = manager.getReport();
            System.out.println(status.getFormattedReport());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
