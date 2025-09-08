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

    public boolean passwordHasRequiredLength(String password) {
        boolean hasRequiredLength = false;
        if (password.length() >= 8) {
            hasRequiredLength = true;
        }
        return hasRequiredLength;
    }

    public boolean passwordHasDigit(String password) {
        boolean hasDigit = false;
        char[] digitControlArr = password.toCharArray();
        for (char character : digitControlArr)
            if (Character.isDigit(character)) {
                hasDigit = true;
                break;
            }
        return hasDigit;
    }

    public boolean passwordHasUppercase(String password) {
        boolean hasUppercase = false;
        char[] uppercaseControlArr = password.toCharArray();
        for (char character : uppercaseControlArr) {
            if (Character.isUpperCase(character)) {
                hasUppercase = true;
                break;
            }
        }
        return hasUppercase;
    }

    public boolean passwordHasSpecialChar(String password) {
        boolean hasSpecialChar = false;
        char[] specialCharControlArr = password.toCharArray();
        for (char character : specialCharControlArr) {
            if (!Character.isAlphabetic(character) && !Character.isDigit(character)) {
                hasSpecialChar = true;
                break;
            }
        }
        return hasSpecialChar;
    }

    public boolean isPasswordValid(String password) {
        return passwordHasRequiredLength(password) &&
                passwordHasDigit(password) &&
                passwordHasUppercase(password) &&
                passwordHasSpecialChar(password);
    }
}