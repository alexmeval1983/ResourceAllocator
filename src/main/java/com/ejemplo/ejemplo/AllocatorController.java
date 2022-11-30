
package com.ejemplo.ejemplo;

//Libraries
import Service.ManageZones;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Rest Service
@RestController
public class AllocatorController 
{
        // Get Method to process requests
        @GetMapping (value= "/allocator")
        public String allocator (@RequestParam String capacity,@RequestParam String hours){

            // Object to calculate cost for allocating resources
            ManageZones objManage=new ManageZones(Integer.parseInt(capacity),Integer.parseInt(hours));

            //Service Response
            return objManage.getOutput();
        }





}
