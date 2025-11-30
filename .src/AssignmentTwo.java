public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        
        System.out.println("=== PART 3 DEMONSTRATION ===");
        assignment.partThree();
        
        System.out.println("\n=== PART 4A DEMONSTRATION ===");
        assignment.partFourA();
        
        System.out.println("\n=== PART 4B DEMONSTRATION ===");
        assignment.partFourB();
        
        System.out.println("\n=== PART 5 DEMONSTRATION ===");
        assignment.partFive();
        
        System.out.println("\n=== PART 6 DEMONSTRATION ===");
        assignment.partSix();
        
        System.out.println("\n=== PART 7 DEMONSTRATION ===");
        assignment.partSeven();
    }
    
    public void partThree() {
        // Create employees and visitors
        Employee operator = new Employee("John Operator", 30, "0412345678", "EMP001", "Ride Operations");
        Ride rollerCoaster = new Ride("Thunder Bolt", "Roller Coaster", operator, 2);
        
        // Create visitors
        Visitor v1 = new Visitor("Alice", 25, "0411111111", "V001", "Adult", false);
        Visitor v2 = new Visitor("Bob", 30, "0422222222", "V002", "Adult", true);
        Visitor v3 = new Visitor("Charlie", 12, "0433333333", "V003", "Child", false);
        Visitor v4 = new Visitor("Diana", 28, "0444444444", "V004", "Adult", true);
        Visitor v5 = new Visitor("Eve", 35, "0455555555", "V005", "Adult", false);
        
        // Add visitors to queue
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);
        
        // Print queue
        rollerCoaster.printQueue();
        
        // Remove one visitor
        rollerCoaster.removeVisitorFromQueue();
        
        // Print queue again
        rollerCoaster.printQueue();
    }
    
    public void partFourA() {
        Employee operator = new Employee("Sarah Manager", 35, "0466666666", "EMP002", "Ride Operations");
        Ride waterRide = new Ride("Splash Mountain", "Water Ride", operator, 4);
        
        // Create visitors
        Visitor v1 = new Visitor("Frank", 40, "0477777777", "V006", "Adult", false);
        Visitor v2 = new Visitor("Grace", 22, "0488888888", "V007", "Student", true);
        Visitor v3 = new Visitor("Henry", 15, "0499999999", "V008", "Child", false);
        Visitor v4 = new Visitor("Ivy", 29, "0410101010", "V009", "Adult", true);
        Visitor v5 = new Visitor("Jack", 33, "0411111112", "V010", "Adult", false);
        
        // Add visitors to history
        waterRide.addVisitorToHistory(v1);
        waterRide.addVisitorToHistory(v2);
        waterRide.addVisitorToHistory(v3);
        waterRide.addVisitorToHistory(v4);
        waterRide.addVisitorToHistory(v5);
        
        // Check if a visitor is in history
        waterRide.checkVisitorFromHistory(v3);
        
        // Print number of visitors
        waterRide.numberOfVisitors();
        
        // Print ride history
        waterRide.printRideHistory();
    }
    
    public void partFourB() {
        Employee operator = new Employee("Mike Supervisor", 40, "0412121212", "EMP003", "Ride Operations");
        Ride ferrisWheel = new Ride("Sky Wheel", "Ferris Wheel", operator, 6);
        
        // Create visitors with mixed attributes for sorting demonstration
        Visitor[] visitors = {
            new Visitor("Oliver", 45, "0413131313", "V011", "Adult", true),
            new Visitor("Penny", 10, "0414141414", "V012", "Child", false),
            new Visitor("Quinn", 28, "0415151515", "V013", "Adult", true),
            new Visitor("Ryan", 15, "0416161616", "V014", "Child", true),
            new Visitor("Sophia", 32, "0417171717", "V015", "Adult", false)
        };
        
        // Add visitors to history
        for (Visitor visitor : visitors) {
            ferrisWheel.addVisitorToHistory(visitor);
        }
        
        System.out.println("=== BEFORE SORTING ===");
        ferrisWheel.printRideHistory();
        
        // Sort using comparator
        ferrisWheel.sortRideHistory(new VisitorComparator());
        
        System.out.println("=== AFTER SORTING ===");
        ferrisWheel.printRideHistory();
    }
    
    public void partFive() {
        Employee operator = new Employee("Lisa Controller", 28, "0418181818", "EMP004", "Ride Operations");
        Ride carousel = new Ride("Magic Carousel", "Carousel", operator, 3);
        
        // Create 10 visitors
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor(
                "Visitor" + i, 
                20 + i, 
                "0419" + String.format("%06d", i), 
                "V" + String.format("%03d", 100 + i),
                i % 2 == 0 ? "Adult" : "Child", 
                i % 3 == 0
            );
            carousel.addVisitorToQueue(visitor);
        }
        
        System.out.println("=== BEFORE RUNNING CYCLE ===");
        carousel.printQueue();
        
        // Run one cycle
        carousel.runOneCycle();
        
        System.out.println("=== AFTER RUNNING CYCLE ===");
        carousel.printQueue();
        
        System.out.println("=== RIDE HISTORY ===");
        carousel.printRideHistory();
    }
    
    public void partSix() {
        Employee operator = new Employee("Tom Export", 38, "0420202020", "EMP005", "Ride Operations");
        Ride testRide = new Ride("Test Ride", "Demonstration", operator, 5);
        
        // Create and add visitors
        Visitor[] visitors = {
            new Visitor("Export1", 25, "0421212121", "V101", "Adult", true),
            new Visitor("Export2", 18, "0422222223", "V102", "Student", false),
            new Visitor("Export3", 45, "0423232323", "V103", "Adult", true),
            new Visitor("Export4", 12, "0424242424", "V104", "Child", false),
            new Visitor("Export5", 30, "0425252525", "V105", "Adult", true)
        };
        
        for (Visitor visitor : visitors) {
            testRide.addVisitorToHistory(visitor);
        }
        
        // Export to file
        testRide.exportRideHistory("ride_history_export.csv");
    }
    
    public void partSeven() {
        Employee operator = new Employee("Jenny Import", 32, "0426262626", "EMP006", "Ride Operations");
        Ride importRide = new Ride("Import Ride", "Demonstration", operator, 5);
        
        // Import from file
        importRide.importRideHistory("ride_history_export.csv");
        
        // Verify import
        importRide.numberOfVisitors();
        importRide.printRideHistory();
    }
}
