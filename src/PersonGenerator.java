import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.nio.file.StandardOpenOption.WRITE;

public class PersonGenerator
{
    public static void main(String[] args)
    {
        ArrayList<Person> people = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        boolean done = false;

        do
        {
            String ID = SafeInput.getNonZeroLenString(in,"Enter ID");
            String firstName = SafeInput.getNonZeroLenString(in,"Enter first name");
            String lastName = SafeInput.getNonZeroLenString(in,"Enter last name");
            String title = SafeInput.getNonZeroLenString(in,"Enter title");
            int YOB = SafeInput.getRangedInt(in,"Enter year of birth", 1940, 2010);

            Person person = new Person(firstName, lastName, ID, title, YOB);

            people.add(person);

            done = !SafeInput.getYNConfirm(in,"Do you want to enter another person");

        } while (!done);

        Path file = Paths.get("personData.txt");

        try
        {
            ArrayList<String> output = new ArrayList<>();

            for (Person person : people)
            {
                output.add(person.toCSV());
            }

            Files.write(
                    file,
                    output,
                    CREATE,
                    WRITE,
                    TRUNCATE_EXISTING
            );

            System.out.println("\nPeople saved successfully to personData.txt");

        }
        catch (IOException e)
        {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}