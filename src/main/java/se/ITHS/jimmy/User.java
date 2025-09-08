package se.ITHS.jimmy;

// Datamodell som hanterar info om anv
public class User {
    private String username;
    private String password;
    private int age;

    // get & set for username
    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
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
