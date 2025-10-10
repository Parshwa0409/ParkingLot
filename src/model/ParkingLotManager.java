package model;

import ENUMS.VehicleType;
import abstracts.IVehicle;
import factories.CostCalculationFactory;
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

    public Ticket parkVehicle(IVehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }

        if (!parkingSlotsAvailable(vehicle.getVehicleType())) {
            throw new RuntimeException("No parking spots available for vehicle type: " + vehicle.getVehicleType());
        }

        ParkingSpot spot = findAvailableSpot(vehicle.getVehicleType());

        Ticket ticket = TicketFactory.issueTicket(vehicle, spot);
        parkingLot.useSpot(spot, vehicle, ticket);
        return ticket;
    }

    public double unparkVehicle(String licensePlate) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            throw new IllegalArgumentException("License plate cannot be null or empty");
        }

        Ticket issuedTicket = findTicketByLicensePlate(licensePlate);
        ParkingSpot spot = issuedTicket.getSpotAssigned();
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

    private boolean parkingSlotsAvailable(VehicleType vehicleType) {
        if (vehicleType == null)
            return false;

        return parkingLot.getParkingFloors()
                .stream()
                .anyMatch(f -> f.hasAvailableSpot(vehicleType));
    }

    private ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        ParkingFloor firstAvailableFloor = parkingLot.getParkingFloors()
                .stream()
                .filter(f -> f.hasAvailableSpot(vehicleType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No available floors with spots for type: " + vehicleType));

        return firstAvailableFloor.getAvailableSpot(vehicleType);
    }
}
