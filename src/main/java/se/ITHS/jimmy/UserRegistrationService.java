package se.ITHS.jimmy;

import java.util.ArrayList;
import java.util.Scanner;

// Hantering av logik bakom att skapa anv, validering av lösenord och hantering av befintliga anv
public class UserRegistrationService {

    private ArrayList<User> savedUsers = new ArrayList<>();


    public void insertUserToArr(User userToAdd) {
        if (isUserNameEmpty(userToAdd.getUsername())) {
            System.out.println("Username must contain at least one character.");
        } else if (isUsernameTaken(userToAdd.getUsername())) {
            System.out.println("Username already taken.");
        } else if (!isPasswordValid(userToAdd.getPassword())) {
            System.out.println("Password is not valid. Must have at least 8 characters, a digit, an uppercase letter, and a special character.");
        } else {
            savedUsers.add(userToAdd);
            System.out.println("User " + userToAdd.getUsername() + " has successfully been created!");
        }
    }

    public void createNewUser(Scanner sc) {
        System.out.println("Choose an unique username: ");
        String username = sc.nextLine();
        System.out.println("Pick a password, it must have at least 8 characters, a digit, an uppercase letter, and a special character.");
        String password = sc.nextLine();

        try {
            System.out.println("Whats your age: ");
            String ageString = sc.nextLine();
            int age = Integer.parseInt(ageString);
            User user = new User(username, password, age);
            insertUserToArr(user);
        } catch (NumberFormatException e) {
            System.out.println("Please write your age with numbers, try again.");
        }
    }

    public void getSavedUsers() {
        for (User user : savedUsers) {
            System.out.println("Existing user: " + user.getUsername());
        }
    }


    private boolean isUserNameEmpty(String username) {
        return username == null || username.trim().isBlank();
    }

    private boolean isUsernameTaken(String username) {
        User existingUser = new User(username, "", 0);
        return savedUsers.contains(existingUser);
    }

    private boolean passwordHasRequiredLength(String password) {
        boolean hasRequiredLength = false;
        if (password.length() >= 8) {
            hasRequiredLength = true;
        }
        return hasRequiredLength;
    }

    private boolean passwordHasDigit(String password) {
        boolean hasDigit = false;
        char[] digitControlArr = password.toCharArray();
        for (char character : digitControlArr)
            if (Character.isDigit(character)) {
                hasDigit = true;
                break;
            }
        return hasDigit;
    }

    private boolean passwordHasUppercase(String password) {
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

    private boolean passwordHasSpecialChar(String password) {
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

    private boolean isPasswordValid(String password) {
        return passwordHasRequiredLength(password) &&
                passwordHasDigit(password) &&
                passwordHasUppercase(password) &&
                passwordHasSpecialChar(password);
    }
}