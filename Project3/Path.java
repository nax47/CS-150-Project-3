import java.util.*;
/**
 * Path class.
 * 
 * @author Nakul Talwar
 */
public class Path<K>
{
    private LinkedList<K> path;
    private double totalcost;
    /**
     * Default constructor.
     */
    public Path()
    {
        path = new LinkedList<K>();
        totalcost = 0;
    }

    /**
     * Method to add a location to the beginning of this path.
     * 
     * @param name Name of location to be added.
     * @return Returns whether or not successfuly added.
     */
    public boolean addPrev(K name){
        if(name == null){return false;}
        path.addFirst(name);
        return true;
    }

    /**
     * Method to set total cost for this path.
     * 
     * @param path Cost to be set.
     */
    public void setPathCost(double totalcost){
        this.totalcost = totalcost;
    }

    /**
     * Method to retrieve cost for current path.
     * 
     * @return Returns cost.
     */
    public double getPathCost(){
        return totalcost;
    }

    /**
     * Method to retrieve iterator for locations in this path.
     * 
     * @return Returns iterator object.
     */
    public Iterator<K> iterator(){
        return path.iterator();
    }
}
