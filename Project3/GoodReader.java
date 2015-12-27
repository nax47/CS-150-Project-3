import java.util.*;
import java.io.*;
/**
 * GoodReader class.
 * 
 * @author Nakul Talwar
 */
public class GoodReader
{
    private int baked_profit;
    private int meat_profit;
    private int dairy_profit;
    private int fruit_profit;
    private int veg_profit;
    private int bev_profit; 
    private Scanner sc;
    /**
     * Default constructor.
     * 
     * @param filename Name of file from which goods details are to be read.
     */
    public GoodReader(String filename)
    {
        baked_profit = 0;
        meat_profit = 0;
        dairy_profit = 0;
        fruit_profit = 0;
        veg_profit = 0;
        bev_profit = 0;
        try{
            sc = new Scanner(new File(filename));
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }

    /**
     * Reads profit details for each type of good from file.
     */
    public void readGoodData(){
        Scanner sc2 = null;
        while(sc.hasNextLine()){
            sc2 = new Scanner(sc.nextLine());
            String good = "";
            int profit = 0;
            while(!sc2.hasNext("-")){
                good = good + sc2.next()+" ";
            }
            good = good.trim();
            sc2.next();
            profit = Integer.parseInt(sc2.next());
            if(good.equals("baked goods")){baked_profit = profit;}
            if(good.equals("meat")){meat_profit = profit;}
            if(good.equals("dairy")){dairy_profit = profit;}
            if(good.equals("fruits")){fruit_profit = profit;}
            if(good.equals("vegetables")){veg_profit = profit;}
            if(good.equals("beverages")){bev_profit = profit;}
        }
        sc2.close();
        sc.close();
    }

    /**
     * Retrieves profit for baked goods after it has been read.
     * 
     * @return Profit per unit for item.
     */
    public int getBakedProfit(){
        return baked_profit;
    }

    /**
     * Retrieves profit for meat after it has been read.
     * 
     * @return Profit per unit for item.
     */
    public int getMeatProfit(){
        return meat_profit;
    }

    /**
     * Retrieves profit for dairy after it has been read.
     * 
     * @return Profit per unit for item.
     */
    public int getDairyProfit(){
        return dairy_profit;
    }

    /**
     * Retrieves profit for fruits after it has been read.
     * 
     * @return Profit per unit for item.
     */
    public int getFruitProfit(){
        return fruit_profit;
    }

    /**
     * Retrieves profit for vegetabes after it has been read.
     * 
     * @return Profit per unit for item.
     */
    public int getVegProfit(){
        return veg_profit;
    }

    /**
     * Retrieves profit for beverages after it has been read.
     * 
     * @return Profit per unit for item.
     */
    public int getBevProfit(){
        return bev_profit;
    }
}
