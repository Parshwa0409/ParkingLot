package strategy.costCalculation;

import abstracts.CostCalculation;
import model.Ticket;

public class WithinOneDayCalculation implements CostCalculation {
    private final Ticket ticket;

    public WithinOneDayCalculation(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public double parkingCost() {
        return this.ticket.getSpotAssigned().getSpotType().getParkingCost() * ticket.getHoursParked();
    }
}
