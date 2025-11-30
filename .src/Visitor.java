public class Visitor extends Person {
    private String visitorId;
    private String ticketType;
    private boolean hasPriorityPass;
    
    // Default constructor
    public Visitor() {
        super();
    }
    
    // Parameterized constructor
    public Visitor(String name, int age, String contactNumber, String visitorId, String ticketType, boolean hasPriorityPass) {
        super(name, age, contactNumber);
        this.visitorId = visitorId;
        this.ticketType = ticketType;
        this.hasPriorityPass = hasPriorityPass;
    }
    
    // Getters and setters
    public String getVisitorId() { 
        return visitorId; 
    }
    
    public void setVisitorId(String visitorId) { 
        this.visitorId = visitorId; 
    }
    
    public String getTicketType() { 
        return ticketType; 
    }
    
    public void setTicketType(String ticketType) { 
        this.ticketType = ticketType; 
    }
    
    public boolean hasPriorityPass() { 
        return hasPriorityPass; 
    }
    
    public void setPriorityPass(boolean priorityPass) { 
        hasPriorityPass = priorityPass; 
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Visitor ID: " + visitorId + ", Ticket: " + ticketType + 
               ", Priority Pass: " + (hasPriorityPass ? "Yes" : "No");
    }
}
