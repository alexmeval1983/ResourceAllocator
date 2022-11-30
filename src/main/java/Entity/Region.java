
package Entity;

/*Class to manage different regions*/

public class Region {
    
    //Atributes
    private String region;
    private String total_cost;
    private String machines;

    //Constructor
    public Region(String region, String total_cost, String machines) {
        this.region = region;
        this.total_cost = total_cost;
        this.machines = machines;
    }
    
     public Region() {
        this.region = "";
        this.total_cost = "";
        this.machines = "";
    }

     //GET and SET
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(String total_cost) {
        this.total_cost = total_cost;
    }

    public String getMachines() {
        return machines;
    }

    public void setMachines(String machines) {
        this.machines = machines;
    }
    
    
    
}
