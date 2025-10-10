package strategy.costCalculation;

import abstracts.CostCalculation;
import config.ParkingCostConfig;
import model.Ticket;

public class OverOneDayCalculation implements CostCalculation {
    private final Ticket ticket;

    public OverOneDayCalculation(Ticket ticket) {
        this.ticket = ticket;
    }

    public double parkingCost() {
        double baseRate = ticket.getSpotAssigned().getSpotType().getParkingCost();
        double timeMultiplier = ParkingCostConfig.getHourlyRate("OVER_ONE_DAY");
        return baseRate * timeMultiplier;
    }
}
