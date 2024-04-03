import java.util.*;

class EmployeeWorkHours {
    private String employeeName;
    private int[] dailyHours;
    
    public EmployeeWorkHours(String employeeName, int[] dailyHours) {
        this.employeeName = employeeName;
        this.dailyHours = dailyHours;
    }
    
    public String getEmployeeName() {
        return employeeName;
    }
    
    public int[] getDailyHours() {
        return dailyHours;
    }
}

public class WorkingHours {
    public static void main(String[] args) {
        List<EmployeeWorkHours> workHoursList = new ArrayList<>();
        // Populate workHoursList with employee work hours
        
        // Example employee work hours
        workHoursList.add(new EmployeeWorkHours("John", new int[]{8, 8, 8, 8, 8}));
        workHoursList.add(new EmployeeWorkHours("Alice", new int[]{9, 9, 8, 8, 7}));
        workHoursList.add(new EmployeeWorkHours("Bob", new int[]{8, 8, 7, 7, 5}));
        workHoursList.add(new EmployeeWorkHours("Eve", new int[]{8, 8, 8, 8, 4}));
        workHoursList.add(new EmployeeWorkHours("Charlie", new int[]{10, 10, 10, 10, 10}));
        
        Map<String, Integer> employeesByWorkHours = new HashMap<>();
        Map<String, Double> averageHoursPerDayByGroup = new HashMap<>();
        
        // Initialize groups
        String[] groups = {"More than 40 hours", "Exactly 40 hours", "Less than 40 hours"};
        for (String group : groups) {
            employeesByWorkHours.put(group, 0);
            averageHoursPerDayByGroup.put(group, 0.0);
        }
        
        // Analyze work hours
        for (EmployeeWorkHours employee : workHoursList) {
            int totalHours = 0;
            for (int hours : employee.getDailyHours()) {
                totalHours += hours;
            }
            int averageHoursPerDay = totalHours / 5;
            String group = getWorkHourGroup(totalHours);
            
            employeesByWorkHours.put(group, employeesByWorkHours.get(group) + 1);
            averageHoursPerDayByGroup.put(group, averageHoursPerDayByGroup.get(group) + averageHoursPerDay);
        }
        
        // Calculate average hours per day
        for (String group : groups) {
            int employees = employeesByWorkHours.get(group);
            double averageHoursPerDay = averageHoursPerDayByGroup.get(group) / employees;
            averageHoursPerDayByGroup.put(group, averageHoursPerDay);
        }
        
        // Display results
        System.out.println("Number of employees who worked more than 40 hours, exactly 40 hours, or less than 40 hours in a week, and the average hours worked per day for each group:");
        for (String group : groups) {
            System.out.println(group + ": Employees - " + employeesByWorkHours.get(group) + ", Average Hours Per Day - " + averageHoursPerDayByGroup.get(group));
        }
    }
    
    private static String getWorkHourGroup(int totalHours) {
        if (totalHours > 40) {
            return "More than 40 hours";
        } else if (totalHours == 40) {
            return "Exactly 40 hours";
        } else {
            return "Less than 40 hours";
        }
    }
}