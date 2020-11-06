import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {

    // displayed number on calculator
    static double displayNum = 0.0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isExit = false;
        int commandNum;
        DecimalFormat numberFormat = new DecimalFormat("#0.0");

        // program will continuously loop until exit button is pressed
        while (!isExit) {
            System.out.println("===============\n" +
                    numberFormat.format(displayNum) +
                    "\n===============");
            System.out.println("Enter a command (add, subtract, multiply, divide, cancel, exit): ");
            String rawCommand = input.nextLine();

            // split rawCommand value
            String[] commandWords = rawCommand.split(" ");

            try {
                commandNum = Integer.parseInt(commandWords[1]);
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                continue;
            } catch (NumberFormatException numberFormatException) {
                System.err.println("Only support integer input");
                continue;
            }

            switch (commandWords[0]) {
                case "add":
                    add(commandNum);
                    break;
                case "subtract":
                    subtract(commandNum);
                    break;
                case "multiply":
                    multiply(commandNum);
                    break;
                case "divide":
                    divide(commandNum);
                    break;
                case "cancel":
                    cancel();
                    break;
                case "exit":
                    isExit = true;
                    break;
                default:
            }
        }
        System.out.println();
    }

    private static void add(int number) {
        displayNum += number;
    }

    private static void subtract(int number) {
        displayNum -= number;
    }

    private static void multiply(int number) {
        displayNum *= number;
    }

    private static void divide(int number) {
        if (number == 0) displayNum = 0.0;
        else displayNum /= number;
    }

    private static void cancel() {
        displayNum = 0.0;
    }

}
