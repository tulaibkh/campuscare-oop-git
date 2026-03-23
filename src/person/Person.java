package person;

public class Person {
    private String id;
    private String name;
    private String email;

    public Person(String id, String name, String email) {
        this.id = id;
        this.name = name;
        setEmail(email);
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public void setEmail(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
    }
    public String getEmail() { return email; }
}