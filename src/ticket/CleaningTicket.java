

package ticket;

public class CleaningTicket extends Ticket {
    private String type; // Trash/Dirty Area

    public CleaningTicket(String ticketId, String title, String description, String location, String type) {
        super(ticketId, title, description, location);
        this.type = type;
    }

    @Override
    public double priorityScore() {
        double score = 5;
        if (description.toLowerCase().contains("trash")) score += 10;
        if (type.toLowerCase().contains("dirty")) score += 5;
        return score;
    }

    public String getType() { return type; }
}




