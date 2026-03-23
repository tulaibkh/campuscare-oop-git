package person;

public class Staff extends Person {
    private String department;

    public Staff(String id, String name, String email, String department) {
        super(id, name, email);
        this.department = department;
    }

    public String getDepartment() { return department; }
}