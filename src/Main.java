import enums.VehicleType;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<ParkingSpot> parkingSpots(int floorNumber) {
        return new ArrayList<>(
                List.of(
                        new model.ParkingSpot(VehicleType.FourWheeler, floorNumber),
                        new model.ParkingSpot(VehicleType.FourWheeler, floorNumber),
                        new model.ParkingSpot(VehicleType.TwoWheeler, floorNumber),
                        new model.ParkingSpot(VehicleType.TwoWheeler, floorNumber),
                        new model.ParkingSpot(VehicleType.ThreeWheeler, floorNumber),
                        new model.ParkingSpot(VehicleType.ThreeWheeler, floorNumber)
                )
        );
    }

    public static void main(String[] args) {
        // Create parking lot with initial spots
        List<ParkingSpot> parkingSpotsFloor1 = parkingSpots(1);
        List<ParkingSpot> parkingSpotsFloor2 = parkingSpots(2);
        
        ParkingFloor floor1 = new ParkingFloor(1);
        floor1.setParkingSpots(parkingSpotsFloor1);

        ParkingFloor floor2 = new ParkingFloor(2);
        floor2.setParkingSpots(parkingSpotsFloor2);

        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(floor1);
        floors.add(floor2);

        ParkingLot parkingLot = new ParkingLot(floors);
        ParkingLotManager manager = new ParkingLotManager(parkingLot);

        try {
            // Create vehicles of different types
            Vehicle car1 = new Vehicle("KA-37 EP-6452", VehicleType.FourWheeler);
            Vehicle bike1 = new Vehicle("KA-37 EP-6453", VehicleType.TwoWheeler);
            Vehicle car2 = new Vehicle("KA-37 EP-6454", VehicleType.FourWheeler);
            Vehicle car3 = new Vehicle("KA-37 EP-6454", VehicleType.FourWheeler);

            // Park vehicles
            System.out.println("\nParking vehicles...");

            Ticket bikeTicket = manager.parkVehicle(bike1);
            System.out.println("Bike parked in spot: " + bikeTicket.getSpotAssigned() + "on floor: " + bikeTicket.getSpotAssigned().getFloorNumber());

            Ticket carTicket1 = manager.parkVehicle(car1);
            System.out.println("Car1 parked in spot: " + carTicket1.getSpotAssigned() + "on floor: " + carTicket1.getSpotAssigned().getFloorNumber());

            Ticket carTicket2 = manager.parkVehicle(car2);
            System.out.println("Car2 parked in spot: " + carTicket2.getSpotAssigned() + "on floor: " + carTicket2.getSpotAssigned().getFloorNumber());

            Ticket carTicket3 = manager.parkVehicle(car3);
            System.out.println("Car3 parked in spot: " + carTicket3.getSpotAssigned() + "on floor: " + carTicket3.getSpotAssigned().getFloorNumber());

            // Test different parking durations
            System.out.println("\nTesting different parking durations...");

            double cost1 = manager.unparkVehicle(car1.getLicensePlate());
            System.out.println("Car1 cost: $" + cost1);

            double cost2 = manager.unparkVehicle(bike1.getLicensePlate());
            System.out.println("Bike cost: $" + cost2);

            double cost3 = manager.unparkVehicle(car2.getLicensePlate());
            System.out.println("Car2 cost: $" + cost3);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
