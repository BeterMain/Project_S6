package Project_S6;

/*
 * Write a program that graphically displays a working calculator for simple infix expressions that consist of single-digit operands; the operators +, -, *, and /; and parentheses. 
 * Make the following assumptions:
	Unary operators (as in -2) are illegal.
	All operations, including division, are integer operations.
	The input expression contains no embedded spaces and no illegal characters, since it is entered by using a keypad.
	The input expression is a syntactically correct infix expression.
	Division by zero will not occur. (Consider how you can remove this restriction.)
The calculator has a display and a keypad of 20 keys, which are arranged as follows:
C < Q /
7 8 9 *
4 5 6 –
1 2 3 +
0 ( ) =

As the user presses keys to enter an infix expression, the corresponding characters appear in the display. The C (Clear) key erases all input entered so far; the 6 (Backspace) key erases the last character entered. When the user presses the = key, the expression is evaluated and the result replaces the expression in the display window. The user can then press C and enter another expression. If the user presses the Q (Quit) key, the calculator ceases operation and is erased from the screen.

 */

import java.util.Scanner;
import java.util.Stack;

public class CalculatorGUI {
    
    public static void run() {

        /* Declare Vars */
        boolean isRunning = true;

        Scanner input = new Scanner(System.in);
        String entry;

        Stack<String> expression = new Stack<>();
        
        /* Main Loop */

        while (isRunning) {

            System.out.println("Entry: " + expression.toString());
            System.out.println("C < Q /");
            System.out.println("7 8 9 *");
            System.out.println("4 5 6 -");
            System.out.println("1 2 3 +");
            System.out.println("0 ( ) =");
            
            entry = input.nextLine();

            if (entry.equals("=")) {
                System.err.println(calculateEntry(expression));
                expression.clear();
            }
            else {
                expression.push(entry);
            }

        }

    }

    private static float calculateEntry(Stack<String> expression) {

        float result = 0;

        String[] operators = {"+", "-", "*", "/"};

        StringBuilder builder = new StringBuilder();
        boolean hasPartner = false;
        Integer tempInt = 0;

        //  Example : [1, +, 1]

        /* Loop through each index of the stack */
        for (String entry : expression) {

            /* Loop through each available operator in the calculator */
            for (String operator : operators) { // TODO: Find better method with searching for correct operator

                /* Check if the operator is what being checked */
                if (!entry.equals(operator)) {
                    if (hasPartner) {

                        /* Execute the operation and assign it to the result */
                        if (operator.equals("+")) {
                            tempInt += Integer.parseInt(entry);
                        }
                        else if (operator.equals("-")) { // TODO: Fix ERROR with not getting correct String
                            tempInt -= Integer.parseInt(entry);
                        }
                        else if (operator.equals("*")) {
                            tempInt *= Integer.parseInt(entry);
                        }
                        else if (operator.equals("/")) {
                            tempInt /= Integer.parseInt(entry);
                        }
                        
                    }
                    else {

                        /* Add the current number to the total temp number */
                        builder.append(entry);
                    }
                }
                else {

                    /* Assign the temperary integer and allow math to occur */
                    tempInt = Integer.parseInt(builder.toString());
                    hasPartner = true;
                }
            }
            

        }

        return result;

    }

}
