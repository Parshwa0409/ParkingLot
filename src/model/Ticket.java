package model;

import abstracts.IParkingSpot;
import abstracts.IVehicle;

public class Ticket {
    private final IVehicle vehicle;
    private final IParkingSpot spotAssigned;
    private final long entryTime;
    private long exitTime;
    private double hoursParked;
    private double cost;

    public Ticket(IVehicle vehicle, IParkingSpot spotAssigned) {
        this.vehicle = vehicle;
        this.spotAssigned = spotAssigned;
        this.entryTime = System.currentTimeMillis();
    }

    void calculateHoursParked() {
        this.hoursParked = Math.ceil((double) (this.exitTime - this.entryTime) / (1000 * 60 * 60));
    }

    public IVehicle getVehicle() {
        return vehicle;
    }

    public IParkingSpot getSpotAssigned() {
        return spotAssigned;
    }

    public double getHoursParked() {
        return this.hoursParked;
    }

    public double getCost() {
        return this.cost;
    }

    void setCost(double cost) {
        this.cost = cost;
    }

    void setExitTime() {
        this.exitTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return String.format("Ticket{vehicle=%s, spot=%s, entryTime=%d, cost=%.2f}",
            vehicle.getLicensePlate(), spotAssigned.getSpotType(), entryTime, cost);
    }
}
