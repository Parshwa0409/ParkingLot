Parking Lot

✅ PHASE 1: Minimal Viable System for a Parking Lot

🎯 GOAL
Build a basic parking lot system that can:
* Track parking space availability
* Allow vehicles to enter and exit
* Charge based on time

1. FUNCTIONAL REQUIREMENTS (FR)
   These are the core features your system must support in the minimal version:
   ID	Requirement	Description
   FR1	Vehicle Entry	A vehicle can enter if space is available; otherwise, it is denied.
   FR2	Vehicle Exit	A vehicle can exit, and parking time is calculated.
   FR3	Parking Spot Assignment	Assign an available spot to a vehicle on entry.
   FR4	Parking Charge Calculation	System calculates charge based on time spent.
   FR5	Basic Reporting	System shows current occupancy and available spots.
2. NON-FUNCTIONAL REQUIREMENTS (NFR)
   These define how well the system performs:
   ID	Requirement	Description
   NFR1	Performance	Vehicle entry/exit operations should be processed within 2 seconds.
   NFR2	Availability	The system should be available during parking lot operational hours (e.g., 6 AM - 10 PM).
   NFR3	Simplicity	The system should be easy to extend (modular design) and understand.
   NFR4	Data Persistence	System should persist basic data like entry time and vehicle ID.
   NFR5	Security	Basic checks to avoid fraudulent exit without payment.
3. ENTITIES (Basic Object Model)
   These are the core objects your system will work with:
   Entity	Attributes
   Vehicle	Vehicle ID (e.g., license plate), Entry Time
   Parking Spot	Spot ID, Type (compact/regular), Status (free/occupied)
   Parking Lot	List of Parking Spots, Total Capacity
   Ticket	Ticket ID, Entry Time, Exit Time, Parking Spot, Amount Charged
4. BASIC FLOW (Example)
1. Vehicle arrives at entry.
2. System checks for available spot.
3. If available, assign a spot and record entry time (generate ticket).
4. Vehicle exits.
5. System calculates time parked and amount to pay.
6. Vehicle pays and exits.
7. Spot is marked as free.

🚧 Assumptions (for Minimal System)
* No distinction between vehicle types (bike, car, truck).
* No online booking or payment system.
* No admin panel or roles.
* No UI — can be CLI or just backend logic.
* Charges are flat per hour.
* No real-time sensors — everything is manually triggered.


🔁 PHASE 2: Extended Parking Lot System (Incremental Features)
Now that Phase 1 covers a working MVP, Phase 2 should enhance usability, structure, and flexibility — without disrupting the foundation.

✅ GOALS OF PHASE 2
* Add vehicle types (e.g., car, bike, truck)
* Add parking spot types (compact, large, electric, etc.)
* Add differentiated pricing by vehicle or spot type
* Add basic user roles (e.g., admin vs. system operator)
* Add display boards showing real-time availability
  Everything builds on top of Phase 1.

🔧 PHASE 2 – Extended Functional Requirements
ID	Requirement	Description
FR6	Support Multiple Vehicle Types	Different types (car, bike, truck) should be supported.
FR7	Spot Type Matching	Vehicle should only park in compatible spot types.
FR8	Variable Pricing	Parking charges vary based on vehicle or spot type.
FR9	Admin Role	Admin can add/remove parking spots or view detailed reports.
FR10	Real-time Display	Show available spots by type at the entry point.
🔒 Extended Non-Functional Requirements
ID	Requirement	Description
NFR6	Extensibility	Design should support adding new vehicle/spot types easily.
NFR7	Maintainability	Core logic should remain reusable and separated (e.g., strategy pattern for pricing).
NFR8	Reliability	System should recover from simple failures (e.g., lost power, restart state from storage).
NFR9	Testability	Core modules should be testable with unit tests.
🧱 Design Extensions (No Breaking Changes)
Here’s how you can extend without refactoring Phase 1 completely:
🧩 Object Model Changes
Entity	New/Extended Attributes
Vehicle	type (car, bike, truck)
ParkingSpot	type (compact, large, electric), isOccupied
PricingStrategy	Class/Interface for pricing rules
DisplayBoard	Holds counts of available spots per type
Admin	New role that can configure the system
🧠 Design Pattern Suggestions
Use these to make your system modular:
* Strategy Pattern → For flexible pricing rules
* Factory Pattern → For vehicle and spot creation
* Observer Pattern → For real-time updates to display boards
* Interface Segregation → For roles (admin, operator)

🛠️ Code Changes Summary (High-Level)
Feature	Code Impact
Vehicle type	Add vehicleType to Vehicle class.
Spot compatibility	Add a canFitVehicle(vehicle) method in ParkingSpot.
Variable pricing	Introduce PricingStrategy interface.
Admin	Add AdminService to manage parking spots and get reports.
Display Board	Add a service that observes spot status and updates availability.
✅ Why This Doesn't Break Phase 1
* Your Phase 1 logic is still valid: entry, exit, time-based charges.
* These new changes add specialization — not a rework.
* Core flow (entry → assign → charge → exit) remains.
* New logic is modular and pluggable.


✅ PHASE 3: Final Phase — Production-Ready Smart Parking System

🎯 GOALS OF PHASE 3
* Enable online booking/reservations
* Integrate digital payment
* Use QR codes/tickets for validation at entry/exit
* Support mobile/web interface
* Integrate with real-time sensors (optional stubbed version)
* Ensure system robustness, analytics, and traceability

1. FUNCTIONAL REQUIREMENTS (Final Phase)
   ID	Requirement	Description
   FR11	Online Reservation	Users can reserve a parking spot in advance via app/web.
   FR12	Digital Payments	Support cashless payments (credit card, wallet, UPI, etc.).
   FR13	QR Code or Ticket Scanning	Vehicle gets a QR/ticket at entry; it's scanned at exit.
   FR14	User Accounts	Users can create accounts, view history, pay, etc.
   FR15	Mobile/Web UI	Basic interface for booking, payments, and user access.
   FR16	Sensor Integration (Stubbed/Mocked)	Detect real-time availability (can simulate for now).
   FR17	Notification System	Alert users when booking is close to expiry or space is limited.
   FR18	Parking History & Invoicing	Generate receipts and history logs for auditing.
2. NON-FUNCTIONAL REQUIREMENTS
   ID	Requirement	Description
   NFR10	Security	Encrypt user/payment data; secure endpoints.
   NFR11	Scalability	Should support multiple parking lots, thousands of users.
   NFR12	Reliability	Ensure recovery from errors, data backup, payment retries.
   NFR13	Integration Readiness	APIs should be well-defined for sensors, third-party services, etc.
   NFR14	Monitoring & Logs	Real-time logs, performance tracking, error alerts.
   NFR15	User Experience (UX)	Minimal clicks for booking, clear error messages, responsive UI.
3. MODULE ADDITIONS (Extensions from Phase 2)
   Module	Description
   ReservationService	Manage booking windows, hold spots temporarily.
   PaymentGateway	Integrate mock payment processors (can be stubbed).
   QRCodeService	Generate and validate QR codes for each ticket/reservation.
   NotificationService	Send SMS, email, or app push notifications.
   AccountService	Handle user sign-up, login, history, and profile.
   SensorGateway (Stub)	Interface for real-time spot detection (mocked for now).
   AnalyticsService	Logs usage, generates reports for admins.
4. SYSTEM FLOW EXAMPLES
   🔁 Online Booking + Entry Flow
1. User opens app/web, views spot availability.
2. User books a spot → receives confirmation + QR code.
3. At parking gate, user scans QR code.
4. System validates booking and assigns actual spot.
5. Parking duration starts.

💳 Exit + Payment Flow
1. Vehicle arrives at exit.
2. System looks up entry time via ticket/QR.
3. Calculates fee (includes reservation time).
4. User pays digitally.
5. Spot marked free, exit allowed.

🛠 Tech Stack Suggestions (Optional)
Layer	Example Stack
Backend	Node.js / Spring Boot / Django
Frontend	React / Angular / Flutter (for mobile)
DB	PostgreSQL / MongoDB
Auth	OAuth2 / Firebase Auth
Payment	Stripe / Razorpay (can mock)
Infra	Docker + Nginx + AWS (or mock local)
5. FINAL PHASE DESIGN GOALS
   ✅ Modular ✅ API-first ✅ Testable ✅ Scalable ✅ UI-Integrated ✅ Real-World Ready (even if simulated)

🔄 Relationship with Phase 1 & 2
Phase	Dependency
Phase 1	Still handles core parking logic (entry, exit, charge)
Phase 2	Spot types, vehicle types, admin tools, dynamic pricing
Phase 3	Adds real-world interfaces, digital tools, user-facing features
No core design is broken — just extended with abstraction and services.

🧭 Next Step Options
Would you like to:
1. Get an updated architecture diagram (including new modules)?
2. See an API design outline for Phase 3?
3. Start working on the QR/payment/reservation logic in code?
4. Design the database schema for Phase 3?
   Let me know and we’ll dive in.




