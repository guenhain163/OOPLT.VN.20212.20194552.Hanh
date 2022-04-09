import java.util.Scanner;

public class DisplayNumberDaysOfMonth {
    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
            String monthInString;
            Integer monthInInteger = 0;
            Integer yearInInteger = 0;

            do {
                System.out.print("Enter month: ");
                monthInString = keyboard.nextLine();

                monthInInteger = switch (monthInString) {
                    case "1", "Jan", "Jan." -> 1;
                    case "2", "Feb", "Feb." -> 2;
                    case "3", "Mar", "Mar." -> 3;
                    case "4", "Apr", "Apr." -> 4;
                    case "5", "May", "May." -> 5;
                    case "6", "Jun", "Jun." -> 6;
                    case "7", "Jul", "Jul." -> 7;
                    case "8", "Aug", "Aug." -> 8;
                    case "9", "Sep", "Sep." -> 9;
                    case "10", "Oct", "Oct." -> 10;
                    case "11", "Nov", "Nov." -> 11;
                    case "12", "Dec", "Dec." -> 12;
                    default -> 0;
                };
            } while (monthInInteger <= 0 || monthInInteger > 12);

            do {
                System.out.print("Enter year: ");
                yearInInteger = keyboard.nextInt();
            } while (yearInInteger <= 0);
            
            Integer numberDaysOfMonth = 0;
            switch (monthInInteger) {
                case 1, 3, 5, 7, 8, 10, 12: 
                    numberDaysOfMonth = 31;    
                    break;
                case 2:
                    if ((yearInInteger % 100 != 0 && yearInInteger % 4 == 0) || yearInInteger % 400 == 0)  {
                        numberDaysOfMonth = 29;
                    } else {
                        numberDaysOfMonth = 28;
                    }
                    break;
                case 4, 6, 9, 11:
                    numberDaysOfMonth = 30;    
                    break;
                default: 
                    numberDaysOfMonth = 0;
                    break;
            }

            System.out.println("The number of days of " + monthInInteger + "/" + yearInInteger
                                + " is: " + numberDaysOfMonth + "\n");
        }
    }
}
