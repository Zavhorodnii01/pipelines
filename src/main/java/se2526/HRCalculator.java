package se2526;

public class HRCalculator {
    public static int calculateMaxHR(int age){
        if(age>120 || age < 0){
            throw new IllegalArgumentException(
                    "Age out of bounds"
            );
        }
        return 220- age;
    }
    public static String getWorkoutZone(int age, int bpm) {
        int maxHR = calculateMaxHR(age);

        double percent = bpm * 100.0 / maxHR;

        if(percent < 50) return "Below warm-up";
        else if(percent < 60) return "Warm-up";
        else if(percent < 70) return "Fat burn";
        else if(percent < 80) return "Aerobic";
        else if(percent < 90) return "Anaerobic";
        else if(percent <= 100) return "Red line";
        else return "Above max HR";
    }

}