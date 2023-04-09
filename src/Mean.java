import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Adapted from website:
 * https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaNativeInterface.html
 */
public class Mean {

    // static {
    //     System.loadLibrary("mean"); // Loads mean.dll
    // }

    /**
     * Takes an array of integers and returns its arithmetic mean
     * @param array (int)
     * @return mean (double)
     */
    private native double mean(int[] array);

    /**
     * Main function
     * @param args
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                File file = new File(args[0]);
                Scanner sc1 = new Scanner(file);
                Scanner sc2 = new Scanner(file);

                // Read the amount of numbers there are
                // in the txt file
                int counter = 0;
                while (sc1.hasNextInt()) {
                    sc1.nextInt();
                    counter++;
                }

                // Create an array of the needed amount of positions
                int[] array = new int[counter];
                int i = 0;
                while (sc2.hasNextInt()) {
                    array[i] = sc2.nextInt(); // Add integers to array
                    i++;
                }

                // Call C++ function to calculate the mean
                double res = new Mean().mean(array);
                // Print answer
                System.out.println("The mean of the integers is: " + res);

                sc1.close();
                sc2.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found.");
            }
        } else {
            System.out.println("Error: You have to write one command-line argument");
        }
    }
}