import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        if (findProduct(item.getID()) == null)
        {
            stock.add(item);
        }        
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
       if (findProduct(id) != null)
       {    
          Product productMatch = findProduct(id);
          productMatch.increaseQuantity(amount);
       }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        int index = 0;      
        Product productMatch = null;
        boolean productFinded = false;
        while (!productFinded && index < stock.size())        
        {            
            if (stock.get(index).getID() == id) 
            {
                productMatch = stock.get(index);
                productFinded = true;
            }
            index++;
        }
        return productMatch;
    }
    
    public Product findProduct(String name)
    {
        int index = 0;      
        Product productMatch = null;
        boolean productFinded = false;
        while (!productFinded && index < stock.size())        
        {            
            if (stock.get(index).getName() == name) 
            {
                productMatch = stock.get(index);
                productFinded = true;
            }
            index++;
        }
        return productMatch;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        int i = 0;
        for (Product product : stock)
        {
            if (product.getID() == id)
            {
                i++;
            }            
        }
        return i;
    }
        
    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for (Product product : stock)
        {
            System.out.println(product.toString());
        }
    }
    
    public void printStockProducts(int amount)
    {
        for (Product product : stock)
        {
            if (product.getQuantity() < amount)
            {
                System.out.println(product.toString());
            }
        }
    }
}
