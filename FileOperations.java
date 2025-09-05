package Task1;
import java.io.*;
import java.util.Scanner;

public class FileOperations {
    private static final String FILE_PATH = "example.txt"; 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("File Operations Menu:");
            System.out.println("1. Read File");
            System.out.println("2. Write to File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    readFile();
                    break;
                case 2:
                    writeToFile();
                    break;
                case 3:
                    modifyFile();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Reads the contents of the text file and displays them to the console.
     */
    private static void readFile() {
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            System.out.println("File contents:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    /**
     * Prompts the user to enter text and writes it to the text file.
     */
    private static void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH, true); // true for appending
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            System.out.print("Enter text to write to the file: ");
            String text = new Scanner(System.in).nextLine();
            bufferedWriter.write(text);
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Text written to the file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    /**
     * Prompts the user to enter new text and replaces the contents of the file with the new text.
     */
    private static void modifyFile() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            System.out.print("Enter new text to replace the file contents: ");
            String newText = new Scanner(System.in).nextLine();
            bufferedWriter.write(newText);

            bufferedWriter.close();
            fileWriter.close();
            System.out.println("File contents modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying the file: " + e.getMessage());
        }
    }
}
