import java.util.*;
/**
 * Tour class.
 * 
 * @author Nakul Talwar
 */
public class Tour<K>
{
    private LinkedList<Path<K>> tour;
    private double totalcost;
    /**
     * Default constructor.
     */
    public Tour()
    {
        tour = new LinkedList<Path<K>>();
    }

    /**
     * Method to add a path to this tour.
     * 
     * @param path Path object to be added.
     * @return Returns whether or not successfuly added.
     */
    public boolean addPath(Path<K> path){
        if(path==null){return false;}
        tour.add(path);
        totalcost += path.getPathCost();
        return true;
    }

    /**
     * Method to retrieve iterator for paths in this tour.
     * 
     * @return Returns iterator object.
     */
    public Iterator<Path<K>> iterator(){
        return tour.iterator();
    }

    /**
     * Method to retrieve cost for current tour.
     * 
     * @return Returns cost.
     */
    public double getTourCost(){
        return totalcost;
    }
}
