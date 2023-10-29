import java.util.Scanner;
public class DevTest {
    public static Scanner testScan = new Scanner(System.in);

    public static void main(String[] args) {
        String firstName = "";
        String yesNo = "";
        String ssn = "";
        int age = 0;
        double salary = 0;
        int favNum = 0;
        double salaryRange = 0;




        firstName = SafeInput.getNonZeroLenString(testScan, "Enter your first name");
        System.out.println("Firstname is " + firstName);

        age = SafeInput.getInt(testScan, "Enter your age");
        System.out.println("You said your age is: " + age);

        salary = SafeInput.getDouble(testScan, "Enter your salary");
        System.out.println("You said your salary is: " + salary);

        favNum = SafeInput.getRangedInt(testScan, "Enter your favorite number", 1, 10);
        System.out.println("You said your favorite number is: " + favNum);

        salaryRange = SafeInput.getRangedDouble(testScan, "Enter your salary", 300, 100000);
        System.out.println("You said your salary is: " + salaryRange);

        yesNo = String.valueOf(SafeInput.getYNConfirm(testScan,"Enter yes or no"));
        System.out.println("You entered: " + yesNo);

        String ssnRegEx = "\\d{3}-\\d{2}-\\d{4}$";
        ssn = getRegExString(testScan, "Enter your SSN", ssnRegEx);
        System.out.println("You said your ssn is: " + ssn);

    }
    // Methods go here!

    /**
     * returns a String input by the user that must be at least one character
     *
     * @param pipe   the scanner to use for the input
     * @param prompt the message for the user telling them what to input
     * @return a String of at least one character
     */

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        boolean done = false;
        String response = "";

        do {
            System.out.print(prompt + ": ");
            response = pipe.nextLine();

            if (response.length() > 0) {
                done = true;
            } else {
                System.out.println("\nYou must enter at least one character! \n");
            }
        } while (!done);

        return response;
    }


    /**
     * gets a double value from the user with no constraints
     *
     * @param pipe   the scanner to use for the input
     * @param prompt message to user for what to enter
     * @return any valid double
     */
    public static int getInt(Scanner pipe, String prompt) {
        boolean done = false;
        String trash = "";
        int value = 0;


        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine(); // Clear the buffer
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a number, You entered: " + trash);
            }
        } while (!done);

        return value;
    }


    /**
     * returns an unconstrained double value
     *
     * @param pipe   the scanner to use for input
     * @param prompt message to tell user what to input
     * @return an unconstrained double value
     */
    public static double getDouble(Scanner pipe, String prompt) {
        boolean done = false;
        String trash = "";
        double value = 0;


        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine(); // Clear the buffer
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a number, You entered: " + trash);
            }
        } while (!done);

        return value;

    }


    /**
     * returns an unconstrained double value
     *
     * @param pipe   the scanner to use for input
     * @param prompt message to tell user what to input
     * @param low    the bottom value for the inclusive range
     * @param high   the top value for the inclusive range
     * @return an int within the inclusive range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        boolean done = false;
        String trash = "";
        int value = 0;


        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine(); // Clear the buffer

                if (value >= low && value <= high) {
                    done = true;
                } else {
                    System.out.println("\nYou must enter a value within the range [" + low + " - " + high + "]: " + value);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a number, You entered: " + trash);
            }
        } while (!done);

        return value;
    }

    /**
     * Gets a double value within an inclusive range
     *
     * @param pipe   Scanner to use for input
     * @param prompt message to user about what to enter
     * @param low    low bound of inclusive range
     * @param high   high bound of inclusive range
     * @return a double within the inclusive range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        boolean done = false;
        String trash = "";
        double value = 0;


        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine(); // Clear the buffer

                if (value >= low && value <= high) {
                    done = true;
                } else {
                    System.out.println("\nYou must enter a value within the range [" + low + " - " + high + "]: " + value);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a number, You entered: " + trash);
            }
        } while (!done);

        return value;
    }


    /**
     * Returns a true false value for yes or no input [YN]
     *
     * @param pipe   scanner to read the input
     * @param prompt message to tell the user what to input
     * @return a boolean true or false for yes or no
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean done = false;
        boolean retVal = false;
        String response = "";

        do {
            System.out.print(prompt + "[YyNn]: ");
            response = pipe.nextLine();

            if (response.toUpperCase().matches("[YN]")) {
                done = true;
                if (response.equalsIgnoreCase("Y")) {
                    retVal = true;
                } else {
                    retVal = false;
                }
            } else {
                System.out.println("\nYou must enter a [Y/N] \n");
            }
        } while (!done);

        return retVal;
    }

    /**
     * takes a regEx String and returns a valid match from the user
     *
     * @param pipe   scanner to use for input
     * @param prompt message to user telling them what to input
     * @param regEx  a String that represents a regular expression to use for the test
     * @return a String value that matches the regular expression
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        boolean done = false;
        String response = "";

        do {
            System.out.print(prompt + " " + regEx + ": ");
            response = pipe.nextLine();

            if (response.matches(regEx)) {
                done = true;
            } else {
                System.out.println("\nYou must enter a String that matches the pattern" + regEx + "!\n");
            }
        } while (!done);

        return response;
    }

    public static void prettyHeader(String msg) {

        for (int x = 0; x <= 60; x++) {
            System.out.print("*");
        }
        System.out.println();

        int msgLength = msg.length();
        int totalLength = 54 - msgLength;
        int spaceLength = totalLength / 2;

        System.out.print("***");
        for (int x = 0; x <= spaceLength; x++) {
            System.out.print(" ");
        }
        System.out.print(msg);

        for (int x = 0; x <= spaceLength; x++) {
            System.out.print(" ");
        }
        System.out.print("***");
        System.out.println();

        for (int x = 0; x <= 60; x++) {
            System.out.print("*");
        }
    }
}
