
package Entity;


/*Class to define capacities and resources*/

public class Capacities {
    
    //Atributes
    private String size;
    private int price;
    private int units;
    private double totalCost;
    private String description; 

    //Constructor
    public Capacities(String size, int price, int units, double totalCost, String description) {
        this.size = size;
        this.price = price;
        this.units = units;
        this.totalCost = totalCost;
        this.description = description;
    }
    
    public Capacities() {
        this.size = "";
        this.price = 0;
        this.units = 0;
        this.totalCost = 0;
        this.description = "";
    }

    //GET and SET
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
