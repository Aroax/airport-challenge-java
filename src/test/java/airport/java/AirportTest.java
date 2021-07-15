package airport.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//import org.junit.Before;

import org.junit.jupiter.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class AirportTest 
{
    /**
     * Rigorous Test :-)
     */
	
//	Airport airport = new Airport();
	private Airport airport;
	
	@Mock
	Plane planeA;
	Plane planeB;
	Weather weather;
	
	@BeforeEach
	public void init() {		
		weather = Mockito.mock(Weather.class);
		airport = new Airport();
//		when(weather.isStormy()).thenReturn(false);
		
	}
	
    @Test
    public void shouldHaveHangar()
    {
    	assertTrue(airport.hangar().isEmpty());
    }
    
    @Test
    public void itShouldTellPlaneToLand() throws CustomException {
    	ArrayList<Plane> testHangar = new ArrayList<Plane>(1);
    	testHangar.add(planeA);
    	
    	when(weather.isStormy()).thenReturn(false);
    	airport.land(planeA);
    	assertIterableEquals(testHangar, airport.hangar());
    }
    
    @Test
    public void shouldTellPlaneToTakeOff() throws CustomException {
    	airport.land(planeA);
    	airport.takeOff(planeA);
    	assertTrue(airport.hangar().isEmpty());
    }
    
    @Test
    public void shouldThrowErrorAtMaximumCapacity() throws CustomException {
    	airport.land(planeA);
//    	doThrow (CustomException.class).when(airport).land(planeB);
    	CustomException landingException = assertThrows(CustomException.class, () -> airport.land(planeB));
    	assertEquals("Cannot land plane, hangar full", landingException.getMessage());
//    	
    	
    }
    
    @Test
    public void shouldHaveDefaultAndOverridableCapacity() {
    	Airport defaultSizeAirport = new Airport();
    	Airport largerSizeAirport = new Airport(100);
    	assertEquals(1, defaultSizeAirport.airportCapacity);
    	assertEquals(100, largerSizeAirport.airportCapacity);
    }
    
    @Test
    public void shouldNotAllowLandingIfStormy() throws CustomException {
    	when(weather.isStormy()).thenReturn(true);
//    	airport.land(planeA);
    	assertEquals(weather.isStormy(), true);
    	CustomException stormyException = assertThrows(CustomException.class, () -> airport.land(planeA));
    	assertEquals("Cannot land plane, it's bloody windy!", stormyException.getMessage());
    }
}