package ticket;

public abstract class Ticket {
    protected String ticketId;
    protected String title;
    protected String description;
    protected String location;
    protected String status;

    public Ticket(String ticketId, String title, String description, String location) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.status = "New";
    }

    public abstract double priorityScore();

    public String getTicketId() { return ticketId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
}