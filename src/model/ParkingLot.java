package model;

import abstracts.IParkingSpot;
import abstracts.IVehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<IParkingSpot> parkingSpots;
    private List<Ticket> issuedTickets;
    private List<IVehicle> parkedVehicles;

    public List<IParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public List<Ticket> getIssuedTickets() {
        return issuedTickets;
    }

    public List<IVehicle> getParkedVehicles() {
        return parkedVehicles;
    }

    public void setParkingSpots(List<IParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingLot() {
        this.parkingSpots = new ArrayList<>();
        this.issuedTickets = new ArrayList<>();
        this.parkedVehicles = new ArrayList<>();
    }

    public void useSpot(Ticket ticket){
        IVehicle vehicle = ticket.getVehicle();
        IParkingSpot spot = ticket.getSpotAssigned();
        spot.parkVehicle(vehicle);
        parkedVehicles.add(vehicle);
        issuedTickets.add(ticket);
    }

    public void unUseSpot(Ticket ticket){
        IVehicle vehicle = ticket.getVehicle();
        IParkingSpot spot = ticket.getSpotAssigned();
        spot.removeVehicle();
        parkedVehicles.remove(vehicle);
    }
}
