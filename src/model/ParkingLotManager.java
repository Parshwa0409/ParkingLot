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
        if (parkingLot == null) {
            throw new IllegalArgumentException("ParkingLot cannot be null");
        }
        this.parkingLot = parkingLot;
    }

    public boolean parkingSlotsAvailable(VehicleType vehicleType) {
        if (vehicleType == null) {
            return false;
        }
        return parkingLot.getParkingSpots()
                .stream()
                .anyMatch(spot ->
                    spot.isAvailable() &&
                    spot.getSpotType() == ParkingSpotTypeFactory.getSpotType(vehicleType)
                );
    }

    public Ticket parkVehicle(IVehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }

        if (!parkingSlotsAvailable(vehicle.getVehicleType())) {
            throw new RuntimeException("No parking spots available for vehicle type: " + vehicle.getVehicleType());
        }

        IParkingSpot spot = findAvailableSpot(
                ParkingSpotTypeFactory.getSpotType(vehicle.getVehicleType())
        );

        Ticket ticket = TicketFactory.issueTicket(vehicle, spot);
        parkingLot.useSpot(spot, vehicle, ticket);
        return ticket;
    }

    public double unparkVehicle(String licensePlate) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            throw new IllegalArgumentException("License plate cannot be null or empty");
        }

        Ticket issuedTicket = findTicketByLicensePlate(licensePlate);
        IParkingSpot spot = issuedTicket.getSpotAssigned();
        IVehicle vehicle = issuedTicket.getVehicle();

        issuedTicket.setExitTime();
        issuedTicket.calculateHoursParked();

        double cost = CostCalculationFactory.getCostCalculation(issuedTicket).parkingCost();
        issuedTicket.setCost(cost);

        parkingLot.unUseSpot(spot, vehicle);
        return cost;
    }

    private Ticket findTicketByLicensePlate(String licensePlate) {
        return parkingLot.getIssuedTickets()
                .stream()
                .filter(t -> Objects.equals(t.getVehicle().getLicensePlate(), licensePlate))
                .findFirst()
                .orElseThrow(() ->
                    new RuntimeException("No ticket found for vehicle with license plate: " + licensePlate)
                );
    }

    private IParkingSpot findAvailableSpot(ParkingSpotType spotType) {
        return parkingLot.getParkingSpots()
                .stream()
                .filter(spot ->
                    spot.isAvailable() && spot.getSpotType() == spotType
                )
                .findFirst()
                .orElseThrow(() ->
                    new RuntimeException("No available parking spots for type: " + spotType)
                );
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
}
