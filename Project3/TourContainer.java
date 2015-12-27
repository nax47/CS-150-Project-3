import java.util.*;
/**
 * TourContainer class.
 * 
 * @author Nakul Talwar
 */
public class TourContainer
{
    //ArrayList object to be used as the container.
    private ArrayList<Tour<Integer>> cont;
    /**
     * Default constructor.
     */
    public TourContainer()
    {
        cont = new ArrayList<Tour<Integer>>();
    }

    /**
     * Method to add an item to the container.
     * 
     * @return Whether the item was added successfully.
     */
    public boolean add(Tour<Integer> tour)
    {
        if(tour==null){return false;}
        return cont.add(tour);
    }

    /**
     * Method to retrieve size of the container.
     * 
     * @return Returns the size.
     */
    public int size(){
        return cont.size();
    }

    /**
     * Method to retrieve an item in the container.
     * 
     * @return Returns the item at specified index.
     */
    public Tour<Integer> get(int index){
        try{
            return cont.get(index);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.toString());
            return null;
        }
    }
}
