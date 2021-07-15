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
	
	private final Integer defaultCapacity = 1;
	public int airportCapacity;
	public Weather weather;
	public CustomException stormException = new CustomException("Cannot land plane, it's bloody windy!");
	public CustomException hangarException = new CustomException("Cannot land plane, hangar full");
	
	public static void main( String[] args )
    {
        
//		ArrayList<String> hangar = new ArrayList<String>(1); 
//		hangar.add("test plane");
//		System.out.println(hangar + "in constructor");
		
		
//		EXPERIMENTING WITH TRY CATCH AND CUSTOM ERRORS:
		
//		Airport airport = new Airport();
//		Plane planeA = new Plane();
//		try {
//			airport.land(planeA);
//		} catch (CustomException e) {
//			e.printStackTrace();
//		}
//		try {
//			airport.land(new Plane());
//		} catch (CustomException e) {
//			e.printStackTrace();
//		}
//		airport.takeOff(planeA);
//		System.out.println("I'm last");
//    	
    }
    
    public Airport(int capacity) {
    	airportCapacity = capacity;
    	this.weather = new Weather();
    }
    
    public Airport() {
    	airportCapacity = defaultCapacity;
    	this.weather = new Weather();
    }
    
    public Airport(Weather weather) {
    	airportCapacity = defaultCapacity;
    	this.weather = weather;
    	System.out.println(weather);
    }
    
    public ArrayList<Plane> hangar() {
    	System.out.println(hangar + "in hangar");
    	return hangar;
    }
    
    public void land(Plane plane) throws CustomException {
    	if (weather.isStormy() == true) {
    		throw stormException;
    	} else if (hangar.size() >= airportCapacity) {
    		throw hangarException;
    	} else {
    	hangar.add(plane);
    	}
    }
    
    public void takeOff(Plane plane) {
    	hangar.remove(plane);
    }
}






