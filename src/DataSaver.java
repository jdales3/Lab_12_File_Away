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
            String firstName = getInput("Enter First Name: ");
            String lastName = getInput("Enter Last Name: ");
            String idNumber = getInput("Enter ID Number (6 digits): ");
            String email = getInput("Enter Email: ");
            String yearOfBirth = getInput("Enter Year of Birth: ");

            String csvRecord = String.format("%s, %s, %s, %s, %s",
                    firstName, lastName, idNumber, email, yearOfBirth);
            records.add(csvRecord);

            continueInput = getBooleanInput("Do you want to enter another record? (yes/no): ");
        }

        String fileName = getInput("Enter the file name (include .csv extension): ");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/" + fileName)))
        {
            for (String record : records)
            {
                bw.write(record);
                bw.newLine();
            }
            System.out.println("Data saved successfully.");
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
