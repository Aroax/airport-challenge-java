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
	public Weather weather = new Weather();
	
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
    }
    
    public Airport() {
    	airportCapacity = defaultCapacity;
    }
    
    public ArrayList<Plane> hangar() {
    	System.out.println(hangar + "in hangar");
    	return hangar;
    }
    
    public void land(Plane plane) throws CustomException {
    	if (hangar.size() >= airportCapacity) throw new CustomException("Cannot land plane, hangar full");
    	if (weather.isStormy()) throw new CustomException("Cannot land plane, it's bloody windy!");
    	hangar.add(plane);
//        System.out.println(hangar + "landed!");
    }
    
    public void takeOff(Plane plane) {
    	hangar.remove(plane);
//    	System.out.println(hangar + "in takeOff");
    }
}






