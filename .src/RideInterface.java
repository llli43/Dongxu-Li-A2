import java.util.Comparator;

public interface RideInterface {
    // Queue operations
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();
    
    // History operations
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();
    
    // Ride operation
    void runOneCycle();
    
    // File operations
    void exportRideHistory(String filename);
    void importRideHistory(String filename);
    
    // Sorting method
    void sortRideHistory(Comparator<Visitor> comparator);
}
