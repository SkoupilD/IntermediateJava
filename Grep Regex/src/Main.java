import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // Define the regex pattern to match one or more digits
        Pattern pattern = Pattern.compile("\\d+");

        // Open and scan all five text files sequentially
        for (int i = 1; i <= 5; i++) {
            String filename = "TestFile" + i + ".txt";
            try {
                File file = new File(filename);
                Scanner fileScanner = new Scanner(file);

                // Use each line of text to match against the pattern
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    Matcher matcher = pattern.matcher(line);

                    // If a match is found, print the filename and the line
                    if (matcher.find()) {
                        System.out.println(filename + ":" + line);
                    }
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filename);
            }
        }
    }
}