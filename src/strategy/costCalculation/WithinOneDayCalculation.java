package strategy.costCalculation;

import abstracts.CostCalculation;
import config.ParkingCostConfig;
import model.Ticket;

public class WithinOneDayCalculation implements CostCalculation {
    private final Ticket ticket;

    public WithinOneDayCalculation(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public double parkingCost() {
        double baseRate = ticket.getSpotAssigned().getSpotType().getParkingCost();
        double timeMultiplier = ParkingCostConfig.getHourlyRate("WITHIN_DAY");
        return baseRate * timeMultiplier;
    }
}
