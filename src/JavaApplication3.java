import person.*;
import ticket.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaApplication3 {

    static ArrayList<Ticket> tickets = new ArrayList<>();
    static ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- CampusCare Menu ---");
            System.out.println("1. Add Person (Student/Staff)");
            System.out.println("2. Create Ticket");
            System.out.println("3. View All Tickets");
            System.out.println("4. Update Ticket Status");
            System.out.println("5. View All People");
            System.out.println("6. Exit");
            System.out.print("Select: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: // Add Person
                    System.out.print("Enter type (Student/Staff): ");
                    String type = sc.nextLine();
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    if (type.equalsIgnoreCase("Student")) {
                        System.out.print("Enter Program: ");
                        String program = sc.nextLine();
                        System.out.print("Enter Semester: ");
                        int sem = sc.nextInt(); sc.nextLine();
                        people.add(new Student(id, name, email, program, sem));
                    } else if (type.equalsIgnoreCase("Staff")) {
                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();
                        people.add(new Staff(id, name, email, dept));
                    } else {
                        System.out.println("Invalid type!");
                        break;
                    }
                    System.out.println(type + " added successfully.");
                    break;

                case 2: // Create Ticket
                    System.out.print("Enter Ticket type (Maintenance/Cleaning): ");
                    String tType = sc.nextLine();
                    System.out.print("Enter Ticket ID: ");
                    String tId = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter Location: ");
                    String loc = sc.nextLine();

                    if (tType.equalsIgnoreCase("Maintenance")) {
                        System.out.print("Enter Maintenance Type (Chair/Desk/Window/Board): ");
                        String mtype = sc.nextLine();
                        tickets.add(new MaintenanceTicket(tId, title, desc, loc, mtype));
                    } else if (tType.equalsIgnoreCase("Cleaning")) {
                        System.out.print("Enter Cleaning Type (Trash/Dirty Area): ");
                        String ctype = sc.nextLine();
                        tickets.add(new CleaningTicket(tId, title, desc, loc, ctype));
                    } else {
                        System.out.println("Invalid ticket type!");
                        break;
                    }
                    System.out.println("Ticket created successfully.");
                    break;

                case 3: // View All Tickets
                    System.out.println("\n--- All Tickets ---");
                    for (Ticket t : tickets) {
                        System.out.println("ID: " + t.getTicketId() +
                                           " | Title: " + t.getTitle() +
                                           " | Status: " + t.getStatus() +
                                           " | Priority: " + t.priorityScore());
                    }
                    break;

                case 4: // Update Ticket Status
                    System.out.print("Enter Ticket ID to update: ");
                    String updateId = sc.nextLine();
                    boolean found = false;

                    for (Ticket t : tickets) {
                        if (t.getTicketId().equals(updateId)) {
                            found = true;
                            System.out.print("Enter new status (New/Assigned/Resolved): ");
                            String newStatus = sc.nextLine();
                            t.setStatus(newStatus);
                            System.out.println("Ticket status updated to: " + t.getStatus());
                        }
                    }
                    if (!found) System.out.println("Ticket ID not found!");
                    break;

                case 5: // View all people
                    System.out.println("\n--- All People ---");
                    for (Person p : people) {
                        System.out.println("ID: " + p.getId() + " | Name: " + p.getName() + " | Email: " + p.getEmail());
                    }
                    break;

                case 6: // Exit
                    running = false;
                    System.out.println("Exiting CampusCare...");
                    break;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
        sc.close();
    }
}