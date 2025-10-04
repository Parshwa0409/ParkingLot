# Parking Lot System

A modern, object-oriented implementation of a parking lot management system. The system handles vehicle parking, spot allocation, and cost calculation with different pricing strategies.

## System Overview

The parking lot system implements core parking management functionalities with a focus on extensibility and maintainability. It follows SOLID principles and employs various design patterns to ensure clean code architecture.

### Core Features

- Vehicle parking and unparking
- Dynamic spot allocation based on vehicle type
- Time-based parking cost calculation
- Different pricing strategies based on parking duration
- Real-time parking lot status reporting

## Architecture

### Design Patterns Used

1. **Strategy Pattern**
   - Used for implementing different cost calculation strategies
   - Strategies:
     - Under one hour (1.5x rate)
     - Regular hourly rate (n * rate)
     - Daily rate (20 * rate * n)
     - Four-hour discount

2. **Factory Pattern**
   - `ParkingSpotTypeFactory`: Maps vehicle types to appropriate spot types
   - `TicketFactory`: Handles ticket creation and initialization
   - `CostCalculationFactory`: Creates appropriate cost calculation strategy

3. **Manager Pattern**
   - `ParkingLotManager`: Central orchestrator for all parking operations
   - Handles validation, spot finding, and operation coordination

### Core Components

1. **ParkingLot**
   - Maintains the state of parking spots
   - Manages list of parked vehicles and issued tickets
   - Handles basic spot operations

2. **ParkingLotManager**
   - Orchestrates parking operations
   - Handles vehicle entry and exit
   - Manages ticket issuance and cost calculation
   - Provides status reporting

3. **Ticket**
   - Records parking session details
   - Tracks entry/exit times
   - Stores cost information

4. **Abstractions**
   - `IParkingSpot`: Interface for parking spot operations
   - `IVehicle`: Interface for vehicle operations
   - `CostCalculation`: Interface for cost calculation strategies

## Implementation Details

### Vehicle and Spot Types
```java
public enum VehicleType {
    TwoWheeler,
    ThreeWheeler,
    FourWheeler
}

public enum ParkingSpotType {
    TwoWheelerSpot,
    ThreeWheelerSpot,
    FourWheelerSpot
}
```

### Cost Calculation
Different strategies for cost calculation based on parking duration:
- Under 1 hour: 1.5x base rate
- Regular hours: n * base rate
- Daily rate: 20 * base rate * number of days
- Special 4-hour discount available

### Spot Allocation
- Spots are assigned based on vehicle type
- Each spot type has a specific base cost
- Automatic matching of vehicle type to appropriate spot type

## Usage Example

```java
// Create parking lot and manager
ParkingLot parkingLot = new ParkingLot(initialSpots);
ParkingLotManager manager = new ParkingLotManager(parkingLot);

// Park a vehicle
Vehicle car = new Vehicle("KA-01-HH-1234", VehicleType.FourWheeler);
Ticket ticket = manager.parkVehicle(car);

// Unpark and get cost
double cost = manager.unparkVehicle(car.getLicensePlate());

// Get parking lot status
ParkingLotStatus status = manager.getReport();
```

## Design Principles

1. **Single Responsibility Principle**
   - Each class has a single, well-defined purpose
   - Clear separation between data and operations

2. **Open/Closed Principle**
   - New vehicle types can be added without modifying existing code
   - Cost calculation strategies can be extended

3. **Interface Segregation**
   - Clean interfaces with specific purposes
   - No unnecessary method implementations

4. **Dependency Inversion**
   - High-level modules depend on abstractions
   - Factory patterns for object creation

## Error Handling

The system includes comprehensive error handling for:
- Full parking lot
- Invalid vehicle types
- Non-existent vehicles
- Invalid operations

## Future Extensions

The system is designed to be easily extended for:
1. Payment processing
2. Multiple parking lots
3. Reservation system
4. Advanced pricing strategies
5. Real-time monitoring

## Running the Project

1. Clone the repository
2. Compile the Java files
3. Run the Main class to see the system in action

The Main class demonstrates:
- Vehicle parking
- Different duration scenarios
- Cost calculation
- Status reporting
