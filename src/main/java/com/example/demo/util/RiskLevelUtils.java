package com.example.demo.util;

public class RiskLevelUtils {

    private RiskLevelUtils() {
        // prevent instantiation
    }

    public static String determineRiskLevel(int score) {

        if (score >= 80) {
            return "CRITICAL";
        }

        if (score >= 50) {
            return "HIGH";
        }

        if (score >= 20) {
            return "MEDIUM";
        }

        return "LOW";
    }
}



// package com.example.demo.util;

// public class RiskLevelUtils {

//     private RiskLevelUtils() {
//         // utility class
//     }

//     public static String determineRiskLevel(int score) {
//         if (score < 20) return "LOW";
//         if (score < 50) return "MEDIUM";
//         if (score < 80) return "HIGH";
//         return "CRITICAL";
//     }
// }
