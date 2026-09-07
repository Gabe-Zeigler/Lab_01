import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonReader
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean anotherFile;

        final int FIELDS_LENGTH = 5;

        do
        {
            JFileChooser chooser = new JFileChooser();
            File selectedFile;
            String rec;

            // This will store Person objects instead of Strings
            ArrayList<Person> people = new ArrayList<>();

            try
            {
                // Get the current working directory
                File workingDirectory = new File(System.getProperty("user.dir"));
                chooser.setCurrentDirectory(workingDirectory);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                {
                    selectedFile = chooser.getSelectedFile();
                    Path file = selectedFile.toPath();

                    // Open the file for reading
                    InputStream in2 =
                            new BufferedInputStream(Files.newInputStream(file));

                    BufferedReader reader =
                            new BufferedReader(new InputStreamReader(in2));

                    int line = 0;

                    while (reader.ready())
                    {
                        rec = reader.readLine();
                        line++;

                        System.out.printf("\nLine %4d %-60s ", line, rec);

                        // Split the CSV record into fields
                        String[] fields = rec.split(",");

                        if (fields.length == FIELDS_LENGTH)
                        {
                            String id = fields[0].trim();
                            String firstName = fields[1].trim();
                            String lastName = fields[2].trim();
                            String title = fields[3].trim();
                            int yob = Integer.parseInt(fields[4].trim());

                            // Create a Person object from the CSV fields
                            Person person = new Person(
                                    firstName,
                                    lastName,
                                    id,
                                    title,
                                    yob
                            );

                            // Add the Person object to the ArrayList
                            people.add(person);
                        }
                        else
                        {
                            System.out.println("\nFound a record that may be corrupt:");
                            System.out.println(rec);
                        }
                    }

                    reader.close();

                    System.out.println("\n\nData file read!");

                    // Print formatted table
                    System.out.println();
                    System.out.printf(
                            "%-10s %-15s %-15s %-8s %-6s%n",
                            "ID#",
                            "Firstname",
                            "Lastname",
                            "Title",
                            "YOB"
                    );

                    System.out.println(
                            "========================================================"
                    );

                    // Display the Person objects
                    for (Person p : people)
                    {
                        System.out.printf(
                                "%-10s %-15s %-15s %-8s %-6d%n",
                                p.getID(),
                                p.getFirstName(),
                                p.getLastName(),
                                p.getTitle(),
                                p.getYOB()
                        );
                    }
                }
                else
                {
                    System.out.println(
                            "Failed to choose a file to process"
                    );
                }
            }
            catch (IOException e)
            {
                System.out.println("File could not be read!!!");
                e.printStackTrace();
            }
            catch (NumberFormatException e)
            {
                System.out.println(
                        "A year of birth was not a valid number."
                );
            }

            anotherFile = SafeInput.getYNConfirm(
                    in,
                    "\nWould you like to open another file?"
            );

        } while (anotherFile);

        System.out.println("Goodbye!");
    }
}

