package ticket;

public class MaintenanceTicket extends Ticket {
    private String type; // Chair/Desk/Window/Board

    public MaintenanceTicket(String ticketId, String title, String description, String location, String type) {
        super(ticketId, title, description, location);
        this.type = type;
    }

    @Override
    public double priorityScore() {
        double score = 5;
        if (location.toLowerCase().contains("lab")) score += 10;
        if (type.toLowerCase().contains("window")) score += 5;
        return score;
    }

    public String getType() { return type; }
}


