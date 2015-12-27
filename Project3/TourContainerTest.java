
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TourContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TourContainerTest
{
    private TourContainer tourCont;

    /**
     * Default constructor for test class TourContainerTest
     */
    public TourContainerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        tourCont = new TourContainer();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void AddGetTest1()
    {
        Tour<Integer> tour1 = new Tour<Integer>();
        Tour<Integer> tour2 = new Tour<Integer>();  
        Tour<Integer> tour3 = new Tour<Integer>();  
        tourCont.add(tour1);
        assertEquals(tourCont.get(0),tour1);
        tourCont.add(tour2);
        tourCont.add(tour3);
        assertEquals(tourCont.get(2),tour3);
        assertEquals(tourCont.get(1),tour2);
        assertEquals(tourCont.get(0),tour1);
    }

    @Test
    public void AddGetTest2()
    {
        assertEquals(false, tourCont.add(null));
        assertEquals(null, tourCont.get(-1));
    }
}

