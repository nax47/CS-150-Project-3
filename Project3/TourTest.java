
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class TourTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TourTest
{
    private Tour<Integer> tour;
    /**
     * Default constructor for test class TourTest
     */
    public TourTest()
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
        tour = new Tour<Integer>();
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
    public void AddTest(){
        Path<Integer> path1 = new Path<Integer>();
        Path<Integer> path2 = new Path<Integer>();
        Path<Integer> path3 = new Path<Integer>();
        assertEquals(false, tour.iterator().hasNext());
        tour.addPath(path1);
        assertEquals(path1, tour.iterator().next());
        tour.addPath(path2);
        tour.addPath(path3);
        Iterator<Path<Integer>> itr = tour.iterator();
        assertEquals(path1, itr.next());
        assertEquals(path2, itr.next());
        assertEquals(path3, itr.next());
    }

    @Test
    public void AddTest2(){
        assertEquals(false, tour.addPath(null));
    }
}
