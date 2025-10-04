package model;

import abstracts.IParkingSpot;
import abstracts.IVehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingLot {
    private final List<IParkingSpot> parkingSpots;
    private final List<Ticket> issuedTickets;
    private final List<IVehicle> parkedVehicles;

    public ParkingLot(List<IParkingSpot> initialSpots) {
        this.parkingSpots = new ArrayList<>(initialSpots);
        this.issuedTickets = new ArrayList<>();
        this.parkedVehicles = new ArrayList<>();
    }

    // Default constructor for testing
    ParkingLot() {
        this(new ArrayList<>());
    }

    public List<IParkingSpot> getParkingSpots() {
        return Collections.unmodifiableList(parkingSpots);
    }

    public List<Ticket> getIssuedTickets() {
        return Collections.unmodifiableList(issuedTickets);
    }

    public List<IVehicle> getParkedVehicles() {
        return Collections.unmodifiableList(parkedVehicles);
    }

    // Package-private for use by ParkingLotManager only
    void addParkingSpot(IParkingSpot spot) {
        parkingSpots.add(spot);
    }

    void useSpot(IParkingSpot spot, IVehicle vehicle, Ticket ticket) {
        spot.parkVehicle(vehicle);
        parkedVehicles.add(vehicle);
        issuedTickets.add(ticket);
    }

    void unUseSpot(IParkingSpot spot, IVehicle vehicle) {
        spot.removeVehicle();
        parkedVehicles.remove(vehicle);
    }
}
