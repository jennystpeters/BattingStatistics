import java.util.Scanner;

/**
 * Created by jenny on 7/5/2017.
 */
public class Validator {

    public static String getString(Scanner entry, String prompt) {
        System.out.print(prompt);
        String s = entry.next();  // read user entry
        entry.nextLine();  // discard any other data entered on the line
        return s;
    }

    public static String getString(Scanner entry, String prompt, String invalidPrompt) {
        boolean isValid = false;
        String s = "";
        while (isValid == false) {
            System.out.print(prompt);
            s = entry.next();  // read user entry
            entry.nextLine();  // discard any other data entered on the line
            if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("n")) {
                isValid = true;
            } else {
                System.out.print(invalidPrompt);
            }
        }
        return s;
    }

    public static int getInt(Scanner entry, String prompt) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (entry.hasNextInt()) {
                i = entry.nextInt();
                isValid = true;
                return i;
            } else {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            entry.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(Scanner entry, String prompt, String invalidPrompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(entry, prompt);
            if (i < min)
                System.out.print(invalidPrompt);
            else if (i > max)
                System.out.print(invalidPrompt);
            else
                isValid = true;
        }
        return i;
    }
}