
package Service;

//Libraries
import Entity.Zones;
import Entity.Region;
import Entity.Capacities;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;

//Class to manage different zones, like India, China, and New York.
public class ManageZones {
    
    //Atributes
    private String output; 
    private int units;
    private int hours;
    
    //Constructor
    public ManageZones(int units, int hours) {
        this.output = "";
        this.hours= hours;
        this.units= units;
        initializeZones();
    }
    
     public ManageZones() {
        this.output = "";
        this.hours= 0;
        this.units= 0;
    }

     //Get and Set
    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
     
    //Orchestrador method in charge of creating and generating the output object
    private void initializeZones (){
        try{
           //Validation when units are not multiple of ten
           if ((this.units%10!=0)||(this.units<10)){ 
               ErrorMap(10);
               return;
           }
           //Validation when hours are not greater than zero
           if (this.hours<=0){ 
               ErrorMap(12);
               return;
           }
           //Create JSON includind three different zones
           buildOutput();
           initializeNewYork();
           initializeIndia();
           initializeChina();
           buildOutput();
        }catch (Exception ex){
            System.out.println(ex);
        }
    } 
    
    //Create new zone object to calculate cost resources for New York
    public void initializeNewYork()throws Exception{
        
        Zones objNewYork= new Zones();
        Region objRegionNY = new Region();
        
        objNewYork.setName("New York");
        objNewYork.setHours(this.hours);
        objNewYork.setUnits(this.units);
        
        //Initialize costs for the zone
        ArrayList<Capacities> objCapacities= new ArrayList<Capacities> ();
        objCapacities.add(new Capacities ("10XLarge",2820,320,0,""));
        objCapacities.add(new Capacities ("8XLarge",1400,160,0,""));
        objCapacities.add(new Capacities ("4XLarge",774,80,0,""));
        objCapacities.add(new Capacities ("2XLarge",450,40,0,""));
        objCapacities.add(new Capacities ("XLarge",230,20,0,""));
        objCapacities.add(new Capacities ("Large",120,10,0,""));
        
        objNewYork.setObjCapacities(objCapacities);
        
        objRegionNY=objNewYork.evaluateResources();
        
        ObjectMapper mapper = new ObjectMapper();
        
        //Convert object to JSON format
        String jsonString = mapper.writeValueAsString(objRegionNY);
        
        this.output = this.output + jsonString + ",";
                
    }
    
    //Create new zone object to calculate cost resources for India
    public void initializeIndia()throws Exception{
        
        Zones objIndia= new Zones();
        Region objRegionIndia = new Region();
        
        objIndia.setName("India");
        objIndia.setHours(this.hours);
        objIndia.setUnits(this.units);
        
        //Initialize costs for the zone
        ArrayList<Capacities> objCapacities= new ArrayList<Capacities> ();
        objCapacities.add(new Capacities ("10XLarge",2970,320,0,""));
        objCapacities.add(new Capacities ("8XLarge",1300,160,0,""));
        objCapacities.add(new Capacities ("4XLarge",890,80,0,""));
        objCapacities.add(new Capacities ("2XLarge",413,40,0,""));
        objCapacities.add(new Capacities ("Large",140,10,0,""));
        
        objIndia.setObjCapacities(objCapacities);
        
        objRegionIndia=objIndia.evaluateResources();
        
        ObjectMapper mapper = new ObjectMapper();
        
        //Convert object to JSON format
        String jsonString = mapper.writeValueAsString(objRegionIndia);
        
        this.output = this.output + jsonString + ",";
                
    }
    //Create new zone object to calculate cost resources for China
    public void initializeChina()throws Exception{
        
        Zones objChina= new Zones();
        Region objRegionChina = new Region();
        
        objChina.setName("China");
        objChina.setHours(this.hours);
        objChina.setUnits(this.units);
        
        //Initialize costs for the zone
        ArrayList<Capacities> objCapacities= new ArrayList<Capacities> ();
        objCapacities.add(new Capacities ("8XLarge",1180,160,0,""));
        objCapacities.add(new Capacities ("4XLarge",670,80,0,""));
        objCapacities.add(new Capacities ("XLarge",200,20,0,""));
        objCapacities.add(new Capacities ("Large",110,10,0,""));
        
        objChina.setObjCapacities(objCapacities);
        
        objRegionChina=objChina.evaluateResources();
        
        ObjectMapper mapper = new ObjectMapper();
        
        //Convert object to JSON format
        String jsonString = mapper.writeValueAsString(objRegionChina);
        
        this.output = this.output + jsonString;
                
    }
    
    //Build file opening and closing
    private void buildOutput(){
        
        if (this.output.length()==0){
            this.output= "{"+"\"Output\""+":"+"[";
        }else{
            this.output= this.output+ "]}";
        }   
    }
    
    //Manage differents types of exceptions
    private void ErrorMap(int codError){
        
        if (codError==10){
            this.output= "{"+"\"codError\""+":"+"10,"+"\"Description\""+":"+"\"Units must be multiple of 10\""+"}";
        }
        if (codError==12){
            this.output= "{"+"\"codError:\""+":"+"12,"+"\"Description\""+":"+"\"Hours must be greater than 0\""+"}";
        }
    }

}
