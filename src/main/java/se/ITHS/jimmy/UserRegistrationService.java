package se.ITHS.jimmy;

import java.util.ArrayList;

// Hantering av logik bakom att skapa anv. Validering av lösenord och hantering av befintliga anv
public class UserRegistrationService {
    private ArrayList<User> savedUsers = new ArrayList<>();

    public void addUser(User userToAdd) {
        savedUsers.add(userToAdd);

    }

}
