public class Product
{
     private String ID;
     private String name;
     private String description;
     private double cost;

     public  Product (String ID, String name, String description, double cost)
     {
         this.ID=ID;
         this.name=name;
         this.description=description;
         this.cost=cost;
     }

     public String getID()
     {
         return ID;
     }
     public String getName()
     {
         return name;
     }
     public String getDescription()
     {
         return description;
     }
     public double getCost()
     {
         return cost;
     }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toJSON()
    {
        return "{\"ID\":\"" + ID + "\","
                + "\"Name\":\"" + name + "\","
                + "\"Description\":\"" + description + "\","
                + "\"Cost\":" + cost + "}";
    }

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

    public String toXML()
    {
        return "<Product>"
                + "<ID>" + ID + "</ID>"
                + "<Name>" + name + "</Name>"
                + "<Description>" + description + "</Description>"
                + "<Cost>" + cost + "</Cost>"
                + "</Product>";
    }
}

