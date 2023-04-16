import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab1 {

    /**
     * Block of code to initialize before the program runs
     * used to load C++ generated library
     */
    static {
        System.loadLibrary("mean"); // Loads mean.dll
    }

    /**
     * Takes an array of integers and returns its arithmetic mean
     * @param array (int)
     * @return mean (double)
     */
    private native double mean(int[] array);

    /**
     * Main function
     * @param args <filename>.txt
     */
    public static void main(String[] args) {
        // Check there's exactly one argument
        if (args.length == 1) {
            try {
                // Validates the extension of the file
                if (!args[0].endsWith(".txt") && !args[0].endsWith(".TXT")) {
                    String msg = "Error: File must be a '.txt'.";
                    throw new IllegalArgumentException(msg);
                }

                // Read file
                File file = new File(args[0]);
                Scanner sc = new Scanner(file);

                // Read the entire line
                String str = sc.nextLine();
                sc.close();

                // Split the string into an array by whitespaces
                String[] strArray = str.split(" ");
                if (strArray.length == 0) {
                    String msg = "Error: File cannot be empty";
                    throw new IllegalArgumentException(msg);
                }

                // Create a int array and cast each String into int
                int[] array = new int[strArray.length];
                for (int i = 0; i < strArray.length; i++) {
                    int maxLength = 9;
                    // Allows one more character if number is negaive
                    if (strArray[i].startsWith("-")) { 
                        maxLength++;
                    }
                    // If number is too big, throw Exception
                    if (strArray[i].length() > maxLength) {
                        String msg = "Error: Number too big to read.";
                        throw new IllegalArgumentException(msg);
                    }
                    // Cast string and add it to array
                    array[i] = Integer.parseInt(strArray[i]);
                }

                // Call C++ function to calculate the mean
                double res = new Lab1().mean(array);
                // Print answer with 3 decimals
                System.out.printf("The mean of the integers is: %.3f", res);


            } catch (FileNotFoundException e) {
                System.err.println("Error: File not found.");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.err.println("Error: You have to write one argument");
        }
    }
}