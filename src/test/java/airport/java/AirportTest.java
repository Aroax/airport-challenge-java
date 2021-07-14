package airport.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//import org.junit.Before;

import org.junit.jupiter.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class AirportTest 
{
    /**
     * Rigorous Test :-)
     */
	
	Airport airport = new Airport();
	
	@Mock
	Plane planeA;
	
//	@BeforeEach
//	public void init() {
//		Airport airport = new Airport();
//	}
	
    @Test
    public void shouldHaveHangar()
    {
    	assertTrue(airport.hangar().isEmpty());
    }
    
    @Test
    public void itShouldTellPlaneToLand() {
    	ArrayList<Plane> testHangar = new ArrayList<Plane>(1);
    	testHangar.add(planeA);
    	airport.land(planeA);
    	assertIterableEquals(testHangar, airport.hangar());
    }
}