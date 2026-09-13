import java.util.Objects;

/**
 * Represents a Product with an ID, name, description, and cost.
 */
public class Product
{
    private String ID;
    private String name;
    private String description;
    private double cost;

    /**
     * Full constructor for a Product.
     *
     * @param ID the product's ID
     * @param name the product's name
     * @param description the product's description
     * @param cost the product's cost
     */
    public  Product (String ID, String name, String description, double cost)
    {
        this.ID=ID;
        this.name=name;
        this.description=description;
        this.cost=cost;
    }

    /**
     * Overloaded constructor for when no description is known yet.
     * The description defaults to an empty String.
     *
     * @param ID the product's ID
     * @param name the product's name
     * @param cost the product's cost
     */
    public Product(String ID, String name, double cost)
    {
        this(ID, name, "", cost);
    }

    /**
     * Default constructor.
     */
    public Product()
    {
        this("", "", "", 0.0);
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
     * Gets the name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }
    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * Gets the cost.
     *
     * @return the cost
     */
    public double getCost()
    {
        return cost;
    }

    /**
     * Sets the ID.
     *
     * @param ID the new ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the cost.
     *
     * @param cost the new cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Returns the Product as a CSV record.
     *
     * @return a comma-separated String
     */
    public String toCSV()
    {
        return ID + "," + name + "," + description + "," + cost;
    }

    /**
     * Returns the Product as a JSON record.
     *
     * @return a JSON-formatted String
     */
    public String toJSON()
    {
        return "{\"ID\":\"" + ID + "\","
                + "\"Name\":\"" + name + "\","
                + "\"Description\":\"" + description + "\","
                + "\"Cost\":" + cost + "}";
    }

    /**
     * Returns a String representation of the Product.
     *
     * @return a String describing the Product
     */
    @Override
    public String toString()
    {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", Name='" + name + '\'' +
                ", Description='" + description + '\'' +
                ", Cost=" + cost +
                '}';
    }

    /**
     * Returns the Product as an XML record.
     *
     * @return an XML-formatted String
     */
    public String toXML()
    {
        return "<Product>"
                + "<ID>" + ID + "</ID>"
                + "<Name>" + name + "</Name>"
                + "<Description>" + description + "</Description>"
                + "<Cost>" + cost + "</Cost>"
                + "</Product>";
    }

    /**
     * Determines whether two Product objects contain the same data.
     *
     * @param o the object to compare
     * @return true if the objects contain the same data
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;

        if (!(o instanceof Product))
            return false;

        Product product = (Product) o;

        return Double.compare(product.cost, cost) == 0 &&
                Objects.equals(ID, product.ID) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description);
    }
}
