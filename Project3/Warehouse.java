/**
 * Warehouse class.
 * 
 * @author Nakul Talwar
 */
public class Warehouse
{
    private City city;
    private Item item;

    /**
     * Default constructor.
     */
    public Warehouse(String city_name, String item_type)
    {
        city = new City(city_name);
        item = new Item(item_type);
    }

    /**
     * Method to retrieve city name.
     * 
     * @return Name of city.
     */
    public String getCity()
    {
        return city.getName();
    }

    /**
     * Method to retrieve Item type.
     * 
     * @return The type of item.
     */
    public String getItem()
    {
        return item.getType();
    }
}
