package config;

import java.util.HashMap;
import java.util.Map;
import enums.VehicleType;

public class ParkingCostConfig {
    private static final Map<String, Double> hourlyRates = new HashMap<>();
    private static final Map<VehicleType, Double> vehicleTypeMultipliers = new HashMap<>();

    static {
        // Default hourly rates for different time brackets
        hourlyRates.put("UNDER_ONE_HOUR", 1.5);
        hourlyRates.put("WITHIN_DAY", 1.0);
        hourlyRates.put("OVER_ONE_DAY", 0.8);

        // Vehicle type multipliers
        vehicleTypeMultipliers.put(VehicleType.FourWheeler, 2.0);
        vehicleTypeMultipliers.put(VehicleType.ThreeWheeler, 1.0);
        vehicleTypeMultipliers.put(VehicleType.TwoWheeler, 0.5);
    }

    public static double getHourlyRate(String timeCategory) {
        return hourlyRates.getOrDefault(timeCategory, 1.0);
    }

    public static double getVehicleMultiplier(VehicleType type) {
        return vehicleTypeMultipliers.getOrDefault(type, 1.0);
    }
}
