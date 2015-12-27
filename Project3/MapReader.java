import java.util.*;
import java.io.*;
/**
 * MapReader class.
 * 
 * @author Nakul Talwar
 */
public class MapReader
{
    private CityMapContainer citymap;
    private Scanner sc;
    /**
     * Default constructor.
     * 
     * @param filename Name of file from which map is to be read.
     */
    public MapReader(String filename)
    {
        citymap = new CityMapContainer();
        try{
            sc = new Scanner(new File(filename));
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }

    /**
     * Constructs map by reading city and road data from an external file.
     * 
     * @return Returns the created map.
     */
    public CityMapContainer createMap(){
        Scanner sc2 = null;
        while(sc.hasNextLine()){
            sc2 = new Scanner(sc.nextLine());
            int n1 = Integer.parseInt(sc2.next());
            sc2.next();
            int n2 = Integer.parseInt(sc2.next());
            double weight = Double.parseDouble(sc2.next());
            citymap.addRoad(n1,n2,weight);
        }
        sc2.close();
        sc.close();
        return citymap;
    }
}
