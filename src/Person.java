import java.util.Calendar;
import java.util.Objects;

/**
 * Represents a person with an ID, name, title, and year of birth.
 */
public class Person
{
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    /**
     * Full constructor for a Person.
     *
     * @param firstName the person's first name
     * @param lastName the person's last name
     * @param ID the person's ID
     * @param title the person's title
     * @param YOB the person's year of birth
     */
    public Person(String firstName, String lastName, String ID, String title, int YOB)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    /**
     * Default constructor.
     */
    public Person()
    {
        this("", "", "", "", 0);
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Gets the ID.
     *
     * @return the ID
     */
    public String getID()
    {
        return ID;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Gets the year of birth.
     *
     * @return the year of birth
     */
    public int getYOB()
    {
        return YOB;
    }

    /**
     * Sets the year of birth.
     *
     * @param YOB the new year of birth
     */
    public void setYOB(int YOB)
    {
        this.YOB = YOB;
    }

    /**
     * Returns the person's first and last name.
     *
     * @return the person's full name
     */
    public String fullName()
    {
        return firstName + " " + lastName;
    }

    /**
     * Returns the person's title and full name.
     *
     * @return the person's formal name
     */
    public String formalName()
    {
        return title + " " + fullName();
    }

    /**
     * Calculates the person's current age.
     *
     * @return the person's current age as a String
     */
    public String getAge()
    {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return getAge(currentYear);
    }

    /**
     * Calculates the person's age in a specified year.
     *
     * @param year the year in which to calculate the age
     * @return the person's age as a String
     */
    public String getAge(int year)
    {
        return String.valueOf(year - YOB);
    }

    /**
     * Returns the Person as a CSV record.
     *
     * @return a comma-separated String
     */
    public String toCSV()
    {
        return ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }

    /**
     * Returns the Person as a JSON record.
     *
     * @return a JSON-formatted String
     */
    public String toJSON()
    {
        return "{\"ID\":\"" + ID + "\","
                + "\"firstName\":\"" + firstName + "\","
                + "\"lastName\":\"" + lastName + "\","
                + "\"title\":\"" + title + "\","
                + "\"YOB\":" + YOB + "}";
    }

    /**
     * Returns the Person as an XML record.
     *
     * @return an XML-formatted String
     */
    public String toXML()
    {
        return "<Person>"
                + "<ID>" + ID + "</ID>"
                + "<firstName>" + firstName + "</firstName>"
                + "<lastName>" + lastName + "</lastName>"
                + "<title>" + title + "</title>"
                + "<YOB>" + YOB + "</YOB>"
                + "</Person>";
    }

    /**
     * Returns a String representation of the Person.
     *
     * @return a String describing the Person
     */
    @Override
    public String toString()
    {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    /**
     * Determines whether two Person objects contain the same data.
     *
     * @param o the object to compare
     * @return true if the objects contain the same data
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;

        if (!(o instanceof Person))
            return false;

        Person person = (Person) o;

        return YOB == person.YOB &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(ID, person.ID) &&
                Objects.equals(title, person.title);
    }
}
