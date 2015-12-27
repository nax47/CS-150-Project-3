import java.util.*;
import java.io.*;
/**
 * LocationReader class.
 * 
 * @author Nakul Talwar
 */
public class LocationReader
{
    private WarehouseContainer baked_stores;
    private WarehouseContainer meat_stores;
    private WarehouseContainer dairy_stores;
    private WarehouseContainer fruit_stores;
    private WarehouseContainer veg_stores;
    private WarehouseContainer bev_stores; 
    private Scanner sc;
    /**
     * Default constructor.
     * 
     * @param filename Name of file from which warehouse location details are to be read.
     */
    public LocationReader(String filename)
    {
        baked_stores = new WarehouseContainer();
        meat_stores = new WarehouseContainer();
        dairy_stores = new WarehouseContainer();
        fruit_stores = new WarehouseContainer();
        veg_stores = new WarehouseContainer();
        bev_stores = new WarehouseContainer();
        try{
            sc = new Scanner(new File(filename));
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }

    /**
     * Reads location details for each type of warehouse from file.
     */
    public void readLocationData(){
        Scanner sc2 = null;
        while(sc.hasNextLine()){
            sc2 = new Scanner(sc.nextLine());
            String good = "";
            String location = "";
            while(!sc2.hasNextInt()){
                good = good + sc2.next()+" ";
            }
            good = good.trim();
            location = sc2.next();
            if(good.equals("baked goods")){baked_stores.add(new Warehouse(location,good));}
            if(good.equals("meat")){meat_stores.add(new Warehouse(location,good));}
            if(good.equals("dairy")){dairy_stores.add(new Warehouse(location,good));}
            if(good.equals("fruits")){fruit_stores.add(new Warehouse(location,good));}
            if(good.equals("vegetables")){veg_stores.add(new Warehouse(location,good));}
            if(good.equals("beverages")){bev_stores.add(new Warehouse(location,good));}
        }
        sc2.close();
        sc.close();
    }

    /**
     * Retrieves set of warehouses for baked goods.
     * 
     * @return Return the set as a container object.
     */
    public WarehouseContainer getBakedLocations(){
        return baked_stores;
    }

    /**
     * Retrieves set of warehouses for meat.
     * 
     * @return Return the set as a container object.
     */
    public WarehouseContainer getMeatLocations(){
        return meat_stores;
    }

    /**
     * Retrieves set of warehouses for dairy.
     * 
     * @return Return the set as a container object.
     */
    public WarehouseContainer getDairyLocations(){
        return dairy_stores;
    }

    /**
     * Retrieves set of warehouses for fruits.
     * 
     * @return Return the set as a container object.
     */
    public WarehouseContainer getFruitLocations(){
        return fruit_stores;
    }

    /**
     * Retrieves set of warehouses for vegetables.
     * 
     * @return Return the set as a container object.
     */
    public WarehouseContainer getVegLocations(){
        return veg_stores;
    }

    /**
     * Retrieves set of warehouses for beverages.
     * 
     * @return Return the set as a container object.
     */
    public WarehouseContainer getBevLocations(){
        return bev_stores;
    }
}
