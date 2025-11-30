import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Comparator;
import java.io.*;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private Employee operator;
    private int maxRider;
    private int numOfCycles;
    
    // Collections for queue and history
    private Queue<Visitor> waitingQueue;
    private LinkedList<Visitor> rideHistory;
    
    // Default constructor
    public Ride() {
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.numOfCycles = 0;
    }
    
    // Parameterized constructor
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this();
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider;
    }
    
    // Getters and setters
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    
    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }
    
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
    
    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = maxRider; }
    
    public int getNumOfCycles() { return numOfCycles; }
    
    @Override
    public String toString() {
        return "Ride: " + rideName + ", Type: " + rideType + ", Operator: " + 
               (operator != null ? operator.getName() : "None") + ", Max Riders: " + maxRider;
    }
    
    // Part 3: Queue operations
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingQueue.add(visitor);
            System.out.println("Success: " + visitor.getName() + " added to queue for " + rideName);
        } else {
            System.out.println("Error: Cannot add null visitor to queue");
        }
    }
    
    @Override
    public void removeVisitorFromQueue() {
        if (!waitingQueue.isEmpty()) {
            Visitor removed = waitingQueue.poll();
            System.out.println("Success: " + removed.getName() + " removed from queue");
        } else {
            System.out.println("Error: Queue is empty, cannot remove visitor");
        }
    }
    
    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Queue for " + rideName + " is empty");
            return;
        }
        
        System.out.println("=== Waiting Queue for " + rideName + " ===");
        int position = 1;
        for (Visitor visitor : waitingQueue) {
            System.out.println(position + ". " + visitor);
            position++;
        }
    }
    
    // Part 4A: History operations
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null && !rideHistory.contains(visitor)) {
            rideHistory.add(visitor);
            System.out.println("Success: " + visitor.getName() + " added to ride history");
        } else if (visitor == null) {
            System.out.println("Error: Cannot add null visitor to history");
        } else {
            System.out.println("Warning: " + visitor.getName() + " already in ride history");
        }
    }
    
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean found = rideHistory.contains(visitor);
        System.out.println("Check result: " + visitor.getName() + " in history: " + found);
        return found;
    }
    
    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Number of visitors in history: " + count);
        return count;
    }
    
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history for " + rideName + " is empty");
            return;
        }
        
        System.out.println("=== Ride History for " + rideName + " ===");
        Iterator<Visitor> iterator = rideHistory.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            System.out.println(count + ". " + iterator.next());
            count++;
        }
    }
    
    // Part 4B: Sorting
    @Override
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (!rideHistory.isEmpty()) {
            rideHistory.sort(comparator);
            System.out.println("Success: Ride history sorted");
        } else {
            System.out.println("Warning: Cannot sort empty ride history");
        }
    }
    
    // Part 5: Run one cycle
    @Override
    public void runOneCycle() {
        // Check if operator is assigned
        if (operator == null || !operator.isAvailable()) {
            System.out.println("Error: No available operator assigned to run the ride");
            return;
        }
        
        // Check if queue is empty
        if (waitingQueue.isEmpty()) {
            System.out.println("Error: No visitors in queue to run the ride");
            return;
        }
        
        System.out.println("=== Running " + rideName + " - Cycle " + (numOfCycles + 1) + " ===");
        int ridersThisCycle = Math.min(maxRider, waitingQueue.size());
        
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor rider = waitingQueue.poll();
            if (rider != null) {
                addVisitorToHistory(rider);
                System.out.println(rider.getName() + " is enjoying the ride!");
            }
        }
        
        numOfCycles++;
        System.out.println("Cycle completed. " + ridersThisCycle + " visitors enjoyed the ride.");
    }
    
    // Part 6: Export to file
    @Override
    public void exportRideHistory(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                // Format: name,age,contact,visitorId,ticketType,hasPriorityPass
                writer.println(visitor.getName() + "," + 
                              visitor.getAge() + "," + 
                              visitor.getContactNumber() + "," + 
                              visitor.getVisitorId() + "," + 
                              visitor.getTicketType() + "," + 
                              visitor.hasPriorityPass());
            }
            System.out.println("Success: Ride history exported to " + filename);
        } catch (IOException e) {
            System.out.println("Error exporting ride history: " + e.getMessage());
        }
    }
    
    // Part 7: Import from file
    @Override
    public void importRideHistory(String filename) {
        int importedCount = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String contact = parts[2];
                    String visitorId = parts[3];
                    String ticketType = parts[4];
                    boolean hasPriorityPass = Boolean.parseBoolean(parts[5]);
                    
                    Visitor visitor = new Visitor(name, age, contact, visitorId, ticketType, hasPriorityPass);
                    addVisitorToHistory(visitor);
                    importedCount++;
                }
            }
            System.out.println("Success: Imported " + importedCount + " visitors from " + filename);
        } catch (IOException e) {
            System.out.println("Error importing ride history: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing data: " + e.getMessage());
        }
    }
}
