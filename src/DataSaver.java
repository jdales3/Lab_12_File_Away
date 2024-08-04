import java.io.*;
import java.util.*;
import java.text.*;
import java.util.regex.*;

public class DataSaver
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        ArrayList<String> records = new ArrayList<>();
        boolean continueInput = true;

        while (continueInput)
        {
            String firstName = getInput("Please enter First Name: ");
            String lastName = getInput("Please enter Last Name: ");
            String idNumber = getInput("Please enter ID Number (6 digits): ");
            String email = getInput("Please enter Email: ");
            String yearOfBirth = getInput("Please enter Year of Birth: ");

            String csvRecord = String.format("%s, %s, %s, %s, %s",
                    firstName, lastName, idNumber, email, yearOfBirth);
            records.add(csvRecord);

            continueInput = getBooleanInput("Would you like to enter another record? (yes/no): ");
        }

        String fileName = getInput("Please enter the file name including the .csv extension: ");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/" + fileName)))
        {
            for (String record : records)
            {
                bw.write(record);
                bw.newLine();
            }
            System.out.println("Your data was saved successfully.");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String getInput(String prompt)
    {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static boolean getBooleanInput(String prompt)
    {
        System.out.print(prompt);
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("yes");
    }
}
