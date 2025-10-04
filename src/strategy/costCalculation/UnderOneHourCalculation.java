package strategy.costCalculation;

import abstracts.CostCalculation;
import model.Ticket;

public class UnderOneHourCalculation implements CostCalculation {
    private final Ticket ticket;

    public UnderOneHourCalculation(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public double parkingCost(){
        return ticket.spotAssigned.getSpotType().getParkingCost() * 1.5;
    }
}
