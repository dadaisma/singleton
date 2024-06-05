import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import static java.lang.System.exit;

public class Menu {

    private static Scanner sc = new Scanner(System.in);
    private static String option;
    private static Undo undo = Undo.getInstance();

    public static void mainMenu() {
        do {
            System.out.println("""
            *** M E N U ***
            1- Generate new String
            2- Delete String
            3- List Strings
            4- List Undo
            5- Exit
            *** Choose an Option ***
            """);

            try {
                option = sc.nextLine();
                if (option.isEmpty()) {
                    System.out.println("Error, Please enter a valid number (1-5).");
                    Undo.getUndo().add("Error, Invalid Input, try again (Numbers only)");
                    continue;
                }
                int choice = Integer.parseInt(option); // Validate input as integer

                switch (choice) {
                    case 1:
                        undo.add(new WordsGen());
                        break;
                    case 2:
                        undo.list();
                        undo.remove(removeMenu());
                        break;
                    case 3:
                        undo.list();
                        break;
                    case 4:
                        undo.undoList();
                        break;
                    case 5:
                        exit(0);
                    default:
                        System.out.println("Error, Invalid option!");
                        Undo.getUndo().add("Error, Invalid pick, try again");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error, Please enter a valid number (1-5).");
                Undo.getUndo().add("Error, Invalid Input, try again (Numbers only)");
                sc.nextLine(); // Clear the invalid input from the scanner
            } catch (NoSuchElementException e) {
                System.out.println("Error, Input stream has no more data.");
                Undo.getUndo().add("Error, No Input Detected, try again");
            }
        } while (true);
    }

    private static String removeMenu() throws NoSuchElementException {
        System.out.println("Enter the ID of the String to remove: ");
        return sc.nextLine();
    }
}
