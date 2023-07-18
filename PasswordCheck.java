import java.util.Scanner;

public class PasswordCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ENTER THE PASSWORD: ");
        String password = scanner.nextLine();
        int lower = 0; // variable for counting lowercase alphabets
        int upper = 0; // variable for counting uppercase alphabets
        int numbers = 0; // variable for counting numbers
        int special = 0; // variable for counting special characters

        if (password.length() >= 6 && password.length() <= 12) {
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (ch >= 'a' && ch <= 'z') { // counting lowercase alphabets
                    lower++;
                }
                if (ch >= 'A' && ch <= 'Z') { // counting uppercase alphabets
                    upper++;
                }
                if (ch >= '0' && ch <= '9') { // counting numbers
                    numbers++;
                }
                if (ch == '$' || ch == '#' || ch == '@') { // counting special characters
                    special++;
                }
            }
            int total = lower + upper + numbers + special;
            if (lower >= 1 && upper >= 1 && numbers >= 1 && special >= 1 && total == password.length()) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        } else {
            System.out.println("Invalid");
        }

        scanner.close();
    }
}
