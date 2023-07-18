
import java.util.Random;
import java.util.Scanner;

public class RandomPasswordgenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();
        
        // Characters to include in the password
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()_+";

        // Generate a password with at least one uppercase letter and special character
        String password = generatePassword(length, lowercaseChars, uppercaseChars, numberChars, specialChars);
        System.out.println("Generated Password: " + password);

        scanner.close();
    }
    
    public static String generatePassword(int length, String lowercaseChars, String uppercaseChars, String numberChars, String specialChars) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        
        // Ensure at least one uppercase letter and special character
        password.append(getRandomChar(uppercaseChars, random));
        password.append(getRandomChar(specialChars, random));
        
        // Generate remaining characters for the password
        for (int i = 2; i < length; i++) {
            String allChars = lowercaseChars + uppercaseChars + numberChars + specialChars;
            password.append(getRandomChar(allChars, random));
        }
        
        // Shuffle the generated password
        for (int i = password.length() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(j));
            password.setCharAt(j, temp);
        }
        
        return password.toString();
    }
    
    public static char getRandomChar(String charSet, Random random) {
        int index = random.nextInt(charSet.length());
        return charSet.charAt(index);
    }
}
