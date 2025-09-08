package se.ITHS.jimmy;

import java.util.ArrayList;

// Hantering av logik bakom att skapa anv. Validering av lösenord och hantering av befintliga anv
public class UserRegistrationService {
    private ArrayList<User> savedUsers = new ArrayList<>();

    public void addUser(User userToAdd) {
        if (!isUsernameTaken(userToAdd.getUsername())) {
            savedUsers.add(userToAdd);
            System.out.println("User " + userToAdd.getUsername() + " has successfully been created!");
        } else {
            System.out.println("Username already taken.");
        }

    }

    public boolean isUsernameTaken(String username) {
        User existingUser = new User(username, "", 0);
        return savedUsers.contains(existingUser);
    }

}
