import java.util.*;
/**
 * WarehouseContainer class.
 * 
 * @author Nakul Talwar
 */
public class WarehouseContainer
{
    //ArrayList object to be used as the container.
    private ArrayList<Warehouse> cont;
    /**
     * Default constructor.
     */
    public WarehouseContainer()
    {
        cont = new ArrayList<Warehouse>();
    }

    /**
     * Method to add an item to the container.
     * 
     * @return Whether the item was added successfully.
     */
    public boolean add(Warehouse warehouse)
    {
        if(warehouse==null){return false;}
        return cont.add(warehouse);
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
    public Warehouse get(int index){
        try{
            return cont.get(index);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.toString());
            return null;
        }
    }
}
