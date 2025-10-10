package factories;

import abstracts.IVehicle;
import model.ParkingSpot;
import model.Ticket;


public class TicketFactory {
    public static Ticket issueTicket(IVehicle vehicle, ParkingSpot spotAssigned){
        return new Ticket(vehicle, spotAssigned);
    }
}
