package airport.java;

import java.util.*;

/**
 * Hello world!
 *
 */
public class Airport 
{
	ArrayList<Plane> hangar = new ArrayList<Plane>(1); 
//	hangar = new ArrayList<String>(1);
	
	
	public static void main( String[] args )
    {
        
//		ArrayList<String> hangar = new ArrayList<String>(1); 
//		hangar.add("test plane");
//		System.out.println(hangar + "in constructor");
    	
    }
    
    public void Constructor() {
    	
    }
    
    public ArrayList<Plane> hangar() {
    	System.out.println(hangar + "in hangar");
    	return hangar;
    }
    
    public void land(Plane plane) {
    	hangar.add(plane);
    }
}
