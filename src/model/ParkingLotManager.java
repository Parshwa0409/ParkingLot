package model;

import ENUMS.ParkingSpotType;
import ENUMS.VehicleType;
import abstracts.IParkingSpot;
import abstracts.IVehicle;
import factories.CostCalculationFactory;
import factories.ParkingSpotTypeFactory;
import factories.TicketFactory;

import java.util.Objects;

public class ParkingLotManager {
    private final ParkingLot parkingLot;

    public ParkingLotManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public boolean parkingSlotsAvailable(VehicleType vehicleType){
        return parkingLot.getParkingSpots()
                .stream()
                .anyMatch(
                        spot -> (
                                spot.isAvailable() && spot.getSpotType()==ParkingSpotTypeFactory.getSpotType(vehicleType)
                        )
                );
    }

    public Ticket parkVehicle(IVehicle vehicle){
        IParkingSpot spot = findAvailableSpot(
                ParkingSpotTypeFactory.getSpotType(vehicle.getVehicleType())
        );

        Ticket ticket = TicketFactory.issueTicket(vehicle, spot);
        parkingLot.useSpot(ticket);
        return ticket;
    }

    public double unparkVehicle(String licensePlate){
        Ticket issuedTicket = parkingLot.getIssuedTickets()
                .stream()
                .filter(t -> Objects.equals(t.vehicle.getLicensePlate(), licensePlate))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("No ticket found for vehicle with license plate: " + licensePlate)
                );

        IParkingSpot spot = issuedTicket.spotAssigned;

        issuedTicket.setExitTime();
        issuedTicket.calculateHoursParked();

        double cost = calculateCost(spot, issuedTicket);
        issuedTicket.setCost(cost);

        parkingLot.unUseSpot(issuedTicket);

        return issuedTicket.cost;
    }

    public ParkingLotStatus getReport() {
        return new ParkingLotStatus(
                parkingLot.getParkedVehicles().size(),
                parkingLot.getIssuedTickets().size(),
                parkingLot.getIssuedTickets().stream().mapToDouble(Ticket::getCost).sum(),
                parkingLot.getParkingSpots().stream().filter(IParkingSpot::isAvailable).count(),
                parkingLot.getParkingSpots().stream().filter(spot -> !spot.isAvailable()).count()
        );
    }

    private IParkingSpot findAvailableSpot(ParkingSpotType spotType) {
        return parkingLot.getParkingSpots()
                .stream()
                .filter(spot -> (spot.isAvailable() && spot.getSpotType()==spotType))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("No available parking spots")
                );
    }

    private double calculateCost(IParkingSpot spot, Ticket ticket){
        return CostCalculationFactory.getCostCalculation(ticket).parkingCost();
    }
}
