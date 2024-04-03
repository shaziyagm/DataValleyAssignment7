import java.util.*;

class MedicalTestResult {
    private String patientName;
    private double resultValue;
    
    public MedicalTestResult(String patientName, double resultValue) {
        this.patientName = patientName;
        this.resultValue = resultValue;
    }
    
    public String getPatientName() {
        return patientName;
    }
    
    public double getResultValue() {
        return resultValue;
    }
}

public class MedicalTest {
    public static void main(String[] args) {
        List<MedicalTestResult> testResults = new ArrayList<>();
        // Populate testResults with medical test results
        
        // Example medical test results
        testResults.add(new MedicalTestResult("John", 75.0));
        testResults.add(new MedicalTestResult("Alice", 110.0));
        testResults.add(new MedicalTestResult("Bob", 90.0));
        testResults.add(new MedicalTestResult("Eve", 60.0));
        testResults.add(new MedicalTestResult("Charlie", 140.0));
        
        Map<String, Integer> patientsByResultRange = new HashMap<>();
        Map<String, Double> averageValueByResultRange = new HashMap<>();
        
        // Initialize result ranges
        String[] resultRanges = {"Normal", "Borderline", "High"};
        for (String range : resultRanges) {
            patientsByResultRange.put(range, 0);
            averageValueByResultRange.put(range, 0.0);
        }
        
        // Analyze test results
        for (MedicalTestResult result : testResults) {
            double value = result.getResultValue();
            String range = getResultRange(value);
            
            patientsByResultRange.put(range, patientsByResultRange.get(range) + 1);
            averageValueByResultRange.put(range, averageValueByResultRange.get(range) + value);
        }
        
        // Calculate average value
        for (String range : resultRanges) {
            int patients = patientsByResultRange.get(range);
            double averageValue = averageValueByResultRange.get(range) / patients;
            averageValueByResultRange.put(range, averageValue);
        }
        
        // Display results
        System.out.println("Number of patients with results falling within specific ranges and average value for each range:");
        for (String range : resultRanges) {
            System.out.println(range + ": Patients - " + patientsByResultRange.get(range) + ", Average Value - " + averageValueByResultRange.get(range));
        }
    }
    
    private static String getResultRange(double value) {
        if (value <= 100.0) {
            return "Normal";
        } else if (value <= 130.0) {
            return "Borderline";
        } else {
            return "High";
        }
    }
}