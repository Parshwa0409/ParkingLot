package factories;

import abstracts.IParkingSpot;
import abstracts.IVehicle;
import model.Ticket;

public class TicketFactory {
    public static Ticket issueTicket(IVehicle vehicle, IParkingSpot spotAssigned){
        Ticket ticket = new Ticket(vehicle, spotAssigned);
        return ticket;
    }
}
