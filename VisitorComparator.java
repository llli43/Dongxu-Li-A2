import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // First compare by priority pass (priority pass holders first)
        if (v1.hasPriorityPass() && !v2.hasPriorityPass()) {
            return -1;
        } else if (!v1.hasPriorityPass() && v2.hasPriorityPass()) {
            return 1;
        }
        
        // Then compare by age (younger first)
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
        if (ageComparison != 0) {
            return ageComparison;
        }
        
        // Finally compare by name alphabetically
        return v1.getName().compareTo(v2.getName());
    }
}
