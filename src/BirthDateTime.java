import java.util.Scanner;

public class BirthDateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = SafeInput.getRangedInt(scanner, "Enter the year of birth", 1950, 2015);
        int month = SafeInput.getRangedInt(scanner, "Enter the month of birth (1-12)", 1, 12);
        int daysInMonth;
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = 30;
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            default:
                daysInMonth = 31;
        }
        int day = SafeInput.getRangedInt(scanner, "Enter the day of birth (1-" + daysInMonth + ")", 1, daysInMonth);
        int hours = SafeInput.getRangedInt(scanner, "Enter the hour of birth (1-24)", 1, 24);
        int minutes = SafeInput.getRangedInt(scanner, "Enter the minutes of birth (1-59)", 1, 59);

        System.out.println("Birth Date and Time: " + year + "-" + month + "-" + day + " " + hours + ":" + minutes);
    }
}
