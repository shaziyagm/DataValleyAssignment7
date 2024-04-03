import java.util.*;

class House {
    private double price;
    private double squareFootage;
    
    public House(double price, double squareFootage) {
        this.price = price;
        this.squareFootage = squareFootage;
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getSquareFootage() {
        return squareFootage;
    }
}

public class Housing {
    public static void main(String[] args) {
        List<House> houses = new ArrayList<>();
        // Populate houses list with housing data
        
        // Example housing data
        houses.add(new House(150000.0, 1200.0));
        houses.add(new House(220000.0, 1800.0));
        houses.add(new House(180000.0, 1500.0));
        houses.add(new House(280000.0, 2000.0));
        houses.add(new House(130000.0, 1000.0));
        
        Map<String, Integer> housesByPriceRange = new HashMap<>();
        Map<String, Double> averageSquareFootageByPriceRange = new HashMap<>();
        
        // Initialize price ranges
        String[] priceRanges = {"$100,000-200,000", "$200,000-300,000", "$300,000-400,000", "Above $400,000"};
        for (String range : priceRanges) {
            housesByPriceRange.put(range, 0);
            averageSquareFootageByPriceRange.put(range, 0.0);
        }
        
        // Analyze housing data
        for (House house : houses) {
            double price = house.getPrice();
            double squareFootage = house.getSquareFootage();
            String range = getPriceRange(price);
            
            housesByPriceRange.put(range, housesByPriceRange.get(range) + 1);
            averageSquareFootageByPriceRange.put(range, averageSquareFootageByPriceRange.get(range) + squareFootage);
        }
        
        // Calculate average square footage
        for (String range : priceRanges) {
            int housesSold = housesByPriceRange.get(range);
            double averageSquareFootage = averageSquareFootageByPriceRange.get(range) / housesSold;
            averageSquareFootageByPriceRange.put(range, averageSquareFootage);
        }
        
        // Display results
        System.out.println("Number of houses sold within specific price ranges and the average square footage for each price range:");
        for (String range : priceRanges) {
            System.out.println(range + ": Houses Sold - " + housesByPriceRange.get(range) + ", Average Square Footage - " + averageSquareFootageByPriceRange.get(range));
        }
    }
    
    private static String getPriceRange(double price) {
        if (price >= 100000.0 && price < 200000.0) {
            return "$100,000-200,000";
        } else if (price >= 200000.0 && price < 300000.0) {
            return "$200,000-300,000";
        } else if (price >= 300000.0 && price < 400000.0) {
            return "$300,000-400,000";
        } else {
            return "Above $400,000";
        }
    }
}