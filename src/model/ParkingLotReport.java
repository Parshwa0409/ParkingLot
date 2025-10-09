package model;

public class ParkingLotReport {
    private final int currentVehicles;
    private final int totalTicketsIssued;
    private final double totalRevenue;
    private final long availableSpots;
    private final long occupiedSpots;

    public ParkingLotReport(int currentVehicles, int totalTicketsIssued,
                            double totalRevenue, long availableSpots, long occupiedSpots) {
        this.currentVehicles = currentVehicles;
        this.totalTicketsIssued = totalTicketsIssued;
        this.totalRevenue = totalRevenue;
        this.availableSpots = availableSpots;
        this.occupiedSpots = occupiedSpots;
    }

    public String getFormattedReport() {
        return String.format("""
            Parking Lot Status:
            ------------------
            Current Vehicles: %d
            Total Tickets Issued: %d
            Total Revenue: $%.2f
            Available Spots: %d
            Occupied Spots: %d
            Occupancy Rate: %.2f%%
            """,
            currentVehicles,
            totalTicketsIssued,
            totalRevenue,
            availableSpots,
            occupiedSpots,
            (occupiedSpots * 100.0) / (availableSpots + occupiedSpots)
        );
    }
}
