package strategy.costCalculation;

import abstracts.CostCalculation;
import config.ParkingCostConfig;
import model.Ticket;

public class UnderOneHourCalculation implements CostCalculation {
    private final Ticket ticket;

    public UnderOneHourCalculation(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public double parkingCost() {
        double baseRate = ticket.getSpotAssigned().getSpotType().getParkingCost();
        double timeMultiplier = ParkingCostConfig.getHourlyRate("UNDER_ONE_HOUR");
        double vehicleMultiplier = ParkingCostConfig.getVehicleMultiplier(ticket.getVehicle().getVehicleType());
        return baseRate * timeMultiplier * vehicleMultiplier;
    }
}
