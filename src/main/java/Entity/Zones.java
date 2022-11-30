
package Entity;


//Libraries
import Entity.Region;
import Entity.Capacities;
import java.util.ArrayList;


//Class to manage different zones
public class Zones {
    
    private String name;
    private double hours;
    private int units;
    private ArrayList<Capacities> objCapacities;
   
    //Constructor
    public Zones(String name, double hours, int units, ArrayList<Capacities> objCapacities) {
        this.name = name;
        this.hours = hours;
        this.units = units;
        this.objCapacities = objCapacities;

    }
    
     public Zones() {
        this.name = "";
        this.hours = 0;
        this.units = 0;
        this.objCapacities = new ArrayList<>();

    }

     //GET and SET
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public ArrayList<Capacities> getObjCapacities() {
        return objCapacities;
    }

    public void setObjCapacities(ArrayList<Capacities> objCapacities) {
        this.objCapacities = objCapacities;
    }
    
   // Method used to calculate cost of resources according to units and hours, no matter the zone or region
   public Region evaluateResources(){
       
       int result=0;
       int total=0;
       int flag=0;
       double totalTemp=0;
       
       //Region Object
       Region objRegion=new Region();
              
       for (int i = 0; i < this.objCapacities.size(); i++) {
           total=this.units;  
           for (int j = i; j < this.objCapacities.size(); j++) {
               
               result= total/this.objCapacities.get(j).getUnits();
               if (result>0){
                   flag=1;
                   total=total - (result*this.objCapacities.get(j).getUnits());
                   this.objCapacities.get(i).setTotalCost(this.objCapacities.get(i).getTotalCost() + (result*this.objCapacities.get(j).getPrice()));
                   if (this.getObjCapacities().get(i).getDescription().length()!=0){
                      this.objCapacities.get(i).setDescription(this.getObjCapacities().get(i).getDescription()+",");
                   }else{
                       this.objCapacities.get(i).setDescription("["+this.getObjCapacities().get(i).getDescription());
                   }
                   this.objCapacities.get(i).setDescription(this.getObjCapacities().get(i).getDescription()+"("+this.objCapacities.get(j).getSize()+","+result+")"  );
               }
           }
           
           if (flag==1){
               this.objCapacities.get(i).setDescription(this.getObjCapacities().get(i).getDescription()+"]");
           }
           
           if ((i==0)&&(flag==1)){
                objRegion.setRegion(this.getName());
                objRegion.setTotal_cost("$"+String.valueOf((int)(this.objCapacities.get(i).getTotalCost()*this.hours)));
                objRegion.setMachines(String.valueOf(this.objCapacities.get(i).getDescription()));
                flag=0;
                totalTemp=this.objCapacities.get(i).getTotalCost();
           }
           if((i!=0)&&(flag==1)){
               if (totalTemp>this.objCapacities.get(i).getTotalCost()){
                    objRegion.setRegion(this.getName());
                    objRegion.setTotal_cost("$"+String.valueOf((int)(this.objCapacities.get(i).getTotalCost()*this.hours)));
                    objRegion.setMachines(String.valueOf(this.objCapacities.get(i).getDescription()));
                    flag=0;
                    totalTemp=this.objCapacities.get(i).getTotalCost();
               } 
           } 
       }
       return objRegion;
       
   }

}
