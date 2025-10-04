package model;

import abstracts.IParkingSpot;
import abstracts.IVehicle;

public class Ticket {
    public IVehicle vehicle;
    public IParkingSpot spotAssigned;
    long entryTime = 0;
    long exitTime = 0;
    double hoursParked = 0;
    double cost = 0.0;

    public Ticket(IVehicle vehicle, IParkingSpot spotAssigned) {
        this.vehicle = vehicle;
        this.spotAssigned = spotAssigned;
    }

    public void calculateHoursParked() {
        this.hoursParked = Math.ceil((double) (this.exitTime - this.entryTime) / (1000 * 60 * 60));
    }

    public IVehicle getVehicle() {
        return vehicle;
    }

    public IParkingSpot getSpotAssigned() {
        return spotAssigned;
    }

    public void setVehicle(IVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getHoursParked(){
        return this.hoursParked;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public void setEntryTime(){
        this.entryTime = System.currentTimeMillis();
    }

    public void setExitTime(){
        this.exitTime = System.currentTimeMillis();
    }

    public void setExitTime(long exitTime){
        this.exitTime = exitTime;
    }
}
