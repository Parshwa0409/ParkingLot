package model;

import abstracts.IVehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private  final List<ParkingFloor> parkingFloors;
    private final List<Ticket> issuedTickets;
    private final List<IVehicle> parkedVehicles;

    public ParkingLot(List<ParkingFloor> floors) {
        this.issuedTickets = new ArrayList<>();
        this.parkedVehicles = new ArrayList<>();
        this.parkingFloors = floors;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public List<Ticket> getIssuedTickets() {
        return issuedTickets;
    }

    void useSpot(ParkingSpot spot, IVehicle vehicle, Ticket ticket) {
        spot.parkVehicle(vehicle);
        parkedVehicles.add(vehicle);
        issuedTickets.add(ticket);
    }

    void unUseSpot(ParkingSpot spot, IVehicle vehicle) {
        spot.removeVehicle();
        parkedVehicles.remove(vehicle);
    }
}
