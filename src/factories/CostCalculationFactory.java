package factories;

import abstracts.CostCalculation;
import model.Ticket;
import strategy.costCalculation.OverOneDayCalculation;
import strategy.costCalculation.UnderOneHourCalculation;
import strategy.costCalculation.WithinOneDayCalculation;

public class CostCalculationFactory {
    public static CostCalculation getCostCalculation(Ticket ticket){
        double hoursParked = ticket.getHoursParked();
        if(hoursParked < 1.00){
            return new UnderOneHourCalculation(ticket);
        }else if(hoursParked < 24){
            return new WithinOneDayCalculation(ticket);
        }else {
            return new OverOneDayCalculation(ticket);
        }
    }
}
