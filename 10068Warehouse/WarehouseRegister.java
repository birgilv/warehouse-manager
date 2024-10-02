import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents the warehouseregister, which is responisble for containing
 * all the items. 
 * 
 * <p>The warehouseregister is expected to:
 * <ul>
 *  <li>Return all items in the warehouse.</li>
 *  <li>Get an item from the warehouse by the itemnumber.</li>
 *  <li>Add a new item to the warehouse.</li>
 *  <li>Increase the quantity of an item by the itemnumber.</li>
 *  <li>Decrease the quantity of an item by the itemnumber.</li>
 *  <li>Remove an item from the warehouse by the itemnuber.</li>
 *  <li>Change the price and set discounts of an item by itemnumber:</li>
 *  <ul>
 *      <li>Set discount in percent.</li>
 *      <li>Set discount in kr, norwegian kroner.</li>
 *      <li>Set new price.</li>
 *  </ul>
 * </ul>
 * 
 *
 * @author Candidate number 10068
 * @version 12-12-2022
 */
public class WarehouseRegister
{
    private ArrayList<Item> listOfItems;
    
    /**
     * Constructs an empty list of items.
     */
    public WarehouseRegister()
    {
        this.listOfItems = new ArrayList<Item>();
    }
    
    /**
     * Filling the warehouseregister with default items is a helper method
     * to test the application. The method is only for testing the application 
     * and should be removed when the class is fully implemented.
     */
    public void fillWarehouseRegisterWithDefaultItems()
    {
        this.listOfItems.add(new Item("bi41g", "A white door", 2499, "Hunton", 
                            60, 2, 3, "white", 4, Categories.DOORS));
        this.listOfItems.add(new Item("2n5ey", "A brown door", 2399, "Hunton", 
                            60, 2, 3, "brown", 7, Categories.DOORS));
        this.listOfItems.add(new Item("4bsmz", "A black door", 2599, "Hunton", 
                            60, 2, 3, "black", 10, Categories.DOORS));
        this.listOfItems.add(new Item("lhm1m", "A white window", 1499, "Egger", 
                            80, 2, 2, "white", 10, Categories.WINDOWS));
        this.listOfItems.add(new Item("3lygj", "A brown window", 1499, "Egger", 
                            80, 2, 2, "brown", 9, Categories.WINDOWS));
        this.listOfItems.add(new Item("3y65h", "A black window", 1499, "Egger", 
                            80, 2, 2, "black", 1, Categories.WINDOWS));
        this.listOfItems.add(new Item("6xoox", "A pack of 4 brown floor lamitate", 
                            99, "Pergo", 20, 1, 3, "brown", 21, Categories.FLOOR_LAMINATES));
        this.listOfItems.add(new Item("e74ln", "A pack of 4 white floor laminate", 
                            99, "Pergo", 20, 1, 3, "brown", 13, Categories.FLOOR_LAMINATES));
    }
    
    /**
     * Returns all items in the warehouseregister.
     *
     * @return All the items in the warehouseregister.
     */
    public ArrayList<Item> getAllItems()
    {
        return this.listOfItems;
    }
    
    /**
     * Returns the iterator to the collection of warehouseregister.
     *
     * @return The iterator to the collection of warehouseregister.
     */
    public Iterator<Item> getIterator()
    {
        return this.listOfItems.iterator();
    }
    
    /**
     * Returns the item found in the warehouseregister with the corresponding
     * itemnumber. Since every item has an uniqe itemnumber, is it either 
     * none or one matching item to each itemnumber. 
     * 
     * <p>If the itemnumber does not match any item, {@code null} is returned.
     *
     * @param itemNumber The itemnumber of the item to search for.
     *
     * @return The item matching the itemnumber. If no item was found,
     *         or the parameter is invalid, {@code null} is returned.
     */
    public Item findItemByItemNumber(String itemNumber)
    {
        Item foundItem = null;
        boolean notFound = true;
        Iterator<Item> it = this.listOfItems.iterator();
        
        while ((notFound) && it.hasNext())
        {
            Item item = it.next();
            if (item.getItemNumber().equals(itemNumber))
            { 
                foundItem = item;
                notFound = false;
            }
        }
        
        return foundItem;
    }
    
    /**
     * Adds an item to the warehouseregister provided by the parameter.
     *
     * @param item The item to be added to the warehouseregister.
     */
    public void addItem(Item item)
    {
        this.listOfItems.add(item);
    }
    
    /**
     * Increases the quantity of an item provided by the parameters. The 
     * quantity to be added must be greater than 0.
     *
     * @param item The item to be increased the quantity.
     * @param quantityToAdd The quantity to be added to the item.
     */
    public void increaseQuantityOfAnItem(Item item, int quantityToAdd)
    {
        int quantity = item.getQuantity();
        if (quantityToAdd > 0) 
        {
            quantity = quantity + quantityToAdd;
        }
        item.setQuantity(quantity);
    }
    
    /**
     * Decreases the quantity of an item provided by the parameters. The 
     * quantity to be added must be lower than the original quantity.
     *
     * @param item The item to be increased the quantity.
     * @param quantityToRemove The quantity to be removed to the item.
     */
    public void decreaseQuantityOfAnItem(Item item, int quantityToRemove)
    {
        int quantity = item.getQuantity();
        if (quantityToRemove <= quantity)
        {
            quantity = quantity - quantityToRemove;
        }
        item.setQuantity(quantity);
    }
    
    /**
     * Removes the item provided as a parameter. 
     *
     * <p>If the item to be removed exists in the warehouseregister, the item
     * is removed and {@code true} us returned. If not, {@code false} is 
     * returned.
     *
     * @param item The item to be removed from the warehouseregister. 
     * @return {@code true}, if the item was successfully removed.
     *         {@code false}, if the item does not exsist in the warehouseregister.
     */
    public boolean removeItem(Item item)
    {
        return this.listOfItems.remove(item);
    }
    
    /**
     * Set a new description of an item provided by the parameters. The new  
     * description can not be empty. 
     *
     * @param item The item to be set a new description. 
     * @param newDescription The new description of the item.
     */
    public void setNewDescription(Item item, String newDescription)
    {
        String description = item.getDescription();
        if (!(newDescription.isBlank()) || !(newDescription == null))
        {
            description = newDescription;
        }
        item.setDescription(description);
    }
    
    /**
     * Set a new brand name of an item provided by the parameters. The new  
     * brand name can not be empty. 
     *
     * @param item The item to be set a new brand name. 
     * @param newBrandName The new brand name of the item.
     */
    public void setNewBrandName(Item item, String newBrandName)
    {
        String brandName = item.getBrandName();
        if (!(newBrandName.isBlank()) || !(newBrandName == null))
        {
            brandName = newBrandName;
        }
        item.setBrandName(brandName);
    }
    
    /**
     * Set a new weight of an item provided by the parameters. The new weight 
     * must be greater than 0. 
     *
     * @param item The item to be set a new weight. 
     * @param newWeight The new weight of the item.
     */
    public void setNewWeight(Item item, double newWeight)
    {
        double weight = item.getWeight();
        if (newWeight > 0)
        {
            weight = newWeight;
        }
        item.setWeight(weight);
    }
    
    /**
     * Set a new length of an item provided by the parameters. The new length 
     * must be greater than 0. 
     *
     * @param item The item to be set a new length. 
     * @param newLength The new length of the item.
     */
    public void setNewLength(Item item, double newLength)
    {
        double length = item.getWeight();
        if (newLength > 0)
        {
            length = newLength;
        }
        item.setLength(length);
    }
    
    /**
     * Set a new height of an item provided by the parameters. The new height 
     * must be greater than 0. 
     *
     * @param item The item to be set a new height. 
     * @param newHeight The new height of the item.
     */
    public void setNewHeight(Item item, double newHeight)
    {
        double height = item.getHeight();
        if (newHeight > 0)
        {
            height = newHeight;
        }
        item.setHeight(height);
    }
    
    /**
     * Set a new color of an item provided by the parameters. The new  
     * color can not be empty. 
     *
     * @param item The item to be set a new color 
     * @param newColor The new color of the item.
     */
    public void setNewColor(Item item, String newColor)
    {
        String color = item.getColor();
        if ((!newColor.isBlank()) || !(newColor == null))
        {
            color = newColor;
        }
        item.setColor(color);
    }
    
    /**
     * Set a new price of an item provided by the parameters. The new price 
     * must be greater than 0. 
     *
     * @param item The item to be set a new price. 
     * @param newPrice The new price of the item.
     */
    public void setNewPrice(Item item, double newPrice)
    {
        double price = item.getPrice();
        if (newPrice > 0)
        {
            price = newPrice;
        }
        item.setPrice(price);
    }
    
    /**
     * Set a discount in percent provided by the parametes. The percent 
     * must be between 0 and 100, not incuding the limits. 
     *
     * @param item The item to be set a discount in percent.
     * @param percent The discount in percent.
     */
    public void setDiscountInPercent(Item item, int percent)
    {
        double price = item.getPrice();
        if (percent > 0 && percent < 100)
        {
            price = price - (price * percent) / 100;
            
        }
        item.setPrice(price);
    }
    
    /**
     * Set a discount in kroner provided by the parameters. The discount 
     * can not be greater than the original price. 
     *
     * @param item The item to be set a discount in kroner. 
     * @param discount The discount in kroner.
     */
    public void setDiscountInKroner(Item item, double discount)
    {
        double price = item.getPrice();
        if (discount < price)
        {
            price = price - discount;
        }
        item.setPrice(price);
    }
}
