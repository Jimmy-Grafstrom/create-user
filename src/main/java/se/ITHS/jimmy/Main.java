package se.ITHS.jimmy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user1 = new User("Jimmy", "Secure-password", 31);
        User user2 = new User("Svante", "Secure-password", 31);
        User user3 = new User("Jimmy", "Secure-password", 31);
        UserRegistrationService newUser = new UserRegistrationService();


        newUser.addUser(user1);
        newUser.addUser(user2);
        newUser.addUser(user3);
        System.out.println(user3.getUsername() + user3.getPassword() + user3.getAge());

    }
}