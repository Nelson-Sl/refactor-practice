package com.twu.refactoring;

public class Receipt {
    private static final int FIXED_CHARGE = 50;
    private static final double PEAK_TIME_MULTIPLIER = 1.2;
    private static final double OFF_PEAK_MULTIPLIER = 1.0;
    private static final int RATE_CHANGE_DISTANCE = 10;
    private static final int PRE_RATE_CHANGE_NON_AC_RATE = 15;
    private static final int POST_RATE_CHANGE_NON_AC_RATE = 12;
    private static final int PRE_RATE_CHANGE_AC_RATE = 20;
    private static final int POST_RATE_CHANGE_AC_RATE = 17;
    private static final double SALES_TAX_RATE = 0.1;

    private final Taxi taxi;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    public double getTotalCost() {
        double totalCost = 0;

        //add fixed charge
        totalCost += FIXED_CHARGE;

        //calculate total charges
        int totalKms = taxi.getTotalKms();
        double peakTimeMultiple = taxi.isPeakTime() ? PEAK_TIME_MULTIPLIER : OFF_PEAK_MULTIPLIER;
        if(taxi.isAirConditioned()) {
            totalCost += airConditionedPreRateCharge(totalKms, peakTimeMultiple);
            totalCost += airConditionedPostRateCharge(totalKms, peakTimeMultiple);
        } else {
            totalCost += unAirConditionedPreRateCharge(totalKms, peakTimeMultiple);
            totalCost += unAirConditionedPostRateCharge(totalKms, peakTimeMultiple);
        }

        return totalCost * (1 + SALES_TAX_RATE);
    }

    public static double airConditionedPreRateCharge(int totalDistance, double peakTimeMultiple) {
        return Math.min(RATE_CHANGE_DISTANCE, totalDistance) * PRE_RATE_CHANGE_AC_RATE * peakTimeMultiple;
    }

    public static double airConditionedPostRateCharge(int totalDistance, double peakTimeMultiple) {
        return Math.max(0, totalDistance - RATE_CHANGE_DISTANCE) * POST_RATE_CHANGE_AC_RATE * peakTimeMultiple;
    }

    public static double unAirConditionedPreRateCharge(int totalDistance, double peakTimeMultiple) {
        return Math.min(RATE_CHANGE_DISTANCE, totalDistance) * PRE_RATE_CHANGE_NON_AC_RATE * peakTimeMultiple;
    }

    public static double unAirConditionedPostRateCharge(int totalDistance, double peakTimeMultiple) {
        return Math.max(0, totalDistance - RATE_CHANGE_DISTANCE) * POST_RATE_CHANGE_NON_AC_RATE * peakTimeMultiple;
    }
}
