# ✅ PHASE 1: Minimal Viable System for a Parking Lot

## 🎯 GOAL
Build a basic parking lot system that can:
* Track parking space availability
* Allow vehicles to enter and exit
* Charge based on time

### 1. FUNCTIONAL REQUIREMENTS (FR)
These are the core features your system must support in the minimal version:

| ID   | Requirement                | Description                                                      |
|------|----------------------------|------------------------------------------------------------------|
| FR1  | Vehicle Entry              | A vehicle can enter if space is available; otherwise, it is denied. |
| FR2  | Vehicle Exit               | A vehicle can exit, and parking time is calculated.              |
| FR3  | Parking Spot Assignment    | Assign an available spot to a vehicle on entry.                  |
| FR4  | Parking Charge Calculation | System calculates charge based on time spent.                    |
| FR5  | Basic Reporting            | System shows current occupancy and available spots.              |

### 2. NON-FUNCTIONAL REQUIREMENTS (NFR)
These define how well the system performs:

| ID    | Requirement    | Description                                                                 |
|-------|----------------|-----------------------------------------------------------------------------|
| NFR1  | Performance    | Vehicle entry/exit operations should be processed within 2 seconds.          |
| NFR2  | Availability   | The system should be available during parking lot operational hours (e.g., 6 AM - 10 PM). |
| NFR3  | Simplicity     | The system should be easy to extend (modular design) and understand.         |
| NFR4  | Data Persistence | System should persist basic data like entry time and vehicle ID.           |
| NFR5  | Security       | Basic checks to avoid fraudulent exit without payment.                       |

### 3. ENTITIES (Basic Object Model)
These are the core objects your system will work with:

| Entity       | Attributes                                                        |
|--------------|-------------------------------------------------------------------|
| Vehicle      | Vehicle ID (e.g., license plate), Entry Time                      |
| Parking Spot | Spot ID, Type (compact/regular), Status (free/occupied)           |
| Parking Lot  | List of Parking Spots, Total Capacity                             |
| Ticket       | Ticket ID, Entry Time, Exit Time, Parking Spot, Amount Charged     |

### 4. BASIC FLOW (Example)
1. Vehicle arrives at entry.
2. System checks for available spot.
3. If available, assign a spot and record entry time (generate ticket).
4. Vehicle exits.
5. System calculates time parked and amount to pay.
6. Vehicle pays and exits.
7. Spot is marked as free.

---

## 🚧 Assumptions (for Minimal System)
* No distinction between vehicle types (bike, car, truck).
* No online booking or payment system.
* No admin panel or roles.
* No UI — can be CLI or just backend logic.
* Charges are flat per hour.
* No real-time sensors — everything is manually triggered.