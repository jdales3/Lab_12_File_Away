import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;
import javax.swing.JFileChooser;


public class FileInspector
{
    public static void main(String[] args)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("src"));

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION)
        {
            File file = fileChooser.getSelectedFile();
            System.out.println("File you selected: " + file.getName());

            try (BufferedReader br = new BufferedReader(new FileReader(file)))
            {
                String line;
                int lineCount = 0;
                int wordCount = 0;
                int charCount = 0;

                while ((line = br.readLine()) != null)
                {
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                    System.out.println(line);
                }

                System.out.println("Summary:");
                System.out.println("File Name: " + file.getName());
                System.out.println("Number of lines: " + lineCount);
                System.out.println("Number of words: " + wordCount);
                System.out.println("Number of characters: " + charCount);

            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("No file was selected.");
        }
    }
}
