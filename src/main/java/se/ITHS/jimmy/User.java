package se.ITHS.jimmy;

// Datamodell som hanterar info om anv
public class User {
    private String username;
    private String password;
    private int age;

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    // Override equals för att kontrollera hur UserRegServ ska jämföra anv-namn
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User otherUser = (User) obj;
        return username.equals(otherUser.username);
    }

    // get & set for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // get & set for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // get & set for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
