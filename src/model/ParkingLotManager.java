package model;

import abstracts.IVehicle;
import factories.CostCalculationFactory;
import factories.TicketFactory;

public class ParkingLotManager {
    private final ParkingLot parkingLot;
    private final SpotAssignmentStrategy spotStrategy;

    public ParkingLotManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.spotStrategy = new SpotAssignmentStrategy(parkingLot);
    }

    public Ticket parkVehicle(IVehicle vehicle) {
        if (!spotStrategy.isSpotAvailable(vehicle.getVehicleType())) {
            throw new RuntimeException("No parking spots available for vehicle type: " + vehicle.getVehicleType());
        }

        ParkingSpot spot = spotStrategy.findSpot(vehicle.getVehicleType());
        Ticket ticket = TicketFactory.issueTicket(vehicle, spot);
        parkingLot.useSpot(spot, vehicle, ticket);
        return ticket;
    }

    public double unparkVehicle(String licensePlate) {
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
        return parkingLot.getIssuedTickets().stream()
                .filter(ticket -> ticket.getVehicle().getLicensePlate().equals(licensePlate))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No ticket found for license plate: " + licensePlate));
    }
}
