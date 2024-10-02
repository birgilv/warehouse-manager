
/**
 * Represents an item with an item number, description, price, brand name, 
 * weight, length, height, color, amount and category.
 *
 * @author Candidate number 10068
 * @version 12-12-2022
 */
public class Item
{
    private String itemNumber;
    private String description;
    private double price;
    private String brandName;
    private double weight;
    private double length;
    private double height;
    private String color;
    private int quantity;
    private Categories category;
    
    /**
     *  Creates an instance of Item.
     *
     *  @param itemNumber The itemnumber of the item. 
     *  @param description The description of the item. 
     *  @param price The price of the item in kr, norwegian kroner.  
     *  @param brandName The brand name of the item. 
     *  @param weight The weight of the item in kg.
     *  @param length The length of the item in m.
     *  @param height The height of the item in m.
     *  @param color The color of the item. 
     *  @param quantity The quantity of the item.
     *  @param category The category if the item.
     */
    public Item(String itemNumber, String description, double price, String brandName,
                double weight, double length, double height, String color, int quantity, 
                Categories category)
    {
        setItemNumber(itemNumber);
        setDescription(description);
        setPrice(price);
        setBrandName(brandName);
        setWeight(weight);
        setLength(length);
        setHeight(height);
        setColor(color);
        setQuantity(quantity);
        setCategory(category);
    }
    
    /**
     *  Sets the itemnumber to the item provided by the parameter. 
     *  The itemnumber is a string and can consist both numbers and letters.
     *  The itemnumber can not be blank. That means it can not be empty 
     *  or contains only whitespaces.
     *  If the parameter is invalid, the itemnumber is set to INVALID_ITEMNUMBER.
     *
     *  @param itemNumber The itemnumber to be set of the item.
     */
    private void setItemNumber(String itemNumber)
    {
        if (itemNumber.isBlank() || itemNumber == null)
        {
            this.itemNumber = "INVALID_ITEMNUMBER";
        } else
        {
            this.itemNumber = itemNumber;
        }
    }
    
    /**
     * Returns the itemnumber of the item.
     *
     * @return The itemnumber of the item. 
     */
    public String getItemNumber()
    {
        return this.itemNumber;
    }
    
    /**
     *  Sets the description to the item provided by the parameter. 
     *  The description is a string and can not be blank. 
     *  That means it can not be empty or contains only whitespaces.
     *  If the parameter is invalid, the description is set to INVALID_DESCRIPTION.
     *
     *  @param description The description to be set  of the item. 
     */
    public void setDescription(String description)
    {
        if (description.isBlank() || description == null)
        {
            this.description = "INVALID_DESCRIPTION";
        } else
        {
            this.description = description;
        }
    }
    
    /**
     * Returns the description of the item.
     *
     * @return The description of the item. 
     */
    public String getDescription()
    {
        return this.description;
    }
    
    /**
     *  Sets the price to the item provided by the parameter. 
     *  The price is a decimal number, and the value must be greater than 0.
     *  The value is in kr, norwegian kroner.
     *  If the parameter is invalid, the price is set to 0,0.
     *
     *  @param price The price to be set of the item. 
     */
    public void setPrice(double price)
    {
        if (price < 0)
        {
            this.price = 0.0;
        } else
        {
            this.price = price;
        }
    }
    
    /**
     * Returns the price of the item as a decimal number.
     *
     * @return The price of the item as a decimal number. 
     */
    public double getPrice()
    {
        return this.price;
    }
    
    /**
     *  Sets the brandname to the item provided by the parameter.
     *  The brandname is a string and can not be blank. 
     *  That means it can not be empty or contains only whitespaces.
     *  If the parameter is invalid, the brandname is set to INVALID_BRANDNAME.
     *
     *  @param brandName The brandname to be set of the item. 
     */
    public void setBrandName(String brandName)
    {
        if (brandName.isBlank() || brandName == null)
        {
            this.brandName = "INVALID_BRANDNAME";
        } else
        {
            this.brandName = brandName;
        }
    }
    
    /**
     * Returns the brandname of the item.
     *
     * @return The brandname of the item.
     */
    public String getBrandName()
    {
        return this.brandName;
    }
    
    /**
     *  Sets the weight to the item provided by the parameter. 
     *  The weight is a decimal number, and the value must be greater than 0.
     *  The value is in m, meters.
     *  If the parameter is invalid, the weight is set to 0,0.
     *
     *  @param weight The weight to be set of the item. 
     */
    public void setWeight(double weight)
    {
        if (weight < 0)
        {
            this.weight = 0.0;
        } else
        {
            this.weight = weight;
        }
    }
    
    /**
     * Returns the weight of the item.
     *
     * @return The weight of the item. 
     */
    public double getWeight()
    {
        return this.weight;
    }
    
    /**
     *  Sets the length to the item provided by the parameter. 
     *  The length is a decimal number, and the value must be greater than 0.
     *  The value is in m, meters.
     *  If the parameter is invalid, the length is set to 0,0.
     *
     *  @param length The length to be set of the item. 
     */
    public void setLength(double length)
    {
        if (length < 0)
        {
            this.length = 0.0;
        } else
        {
            this.length = length;
        }
    }
    
    /**
     * Returns the length of the item.
     *
     * @return The length of the item. 
     */
    public double getLength()
    {
        return this.length;
    }
    
    /**
     *  Sets the height to the item provided by the parameter. 
     *  The height is a decimal number, and the value must be greater than 0.
     *  The value is in m, meters.
     *  If the parameter is invalid, the height is set to 0,0.
     *
     *  @param height The height to be set of the item. 
     */
    public void setHeight(double height)
    {
        if (height < 0)
        {
            this.height = 0.0;
        } else
        {
            this.height = height;
        }
    }
    
    /**
     * Returns the height of the item.
     *
     * @return The height of the item.
     */
    public double getHeight()
    {
        return this.height;
    }
    
    /**
     *  Sets the color to the item provided by the parameter.
     *  The color is a string and can not be blank. 
     *  That means it can not be empty or contains only whitespaces. 
     *  If the parameter is invalid, the color is set to INVALID_COLOR.
     *
     *  @param color The color to be set of the item. 
     */
    public void setColor(String color)
    {
        if (color.isBlank() || color == null)
        {
            this.color = "INVALID_COLOR";
        } else
        {
            this.color = color;
        }
    }
    
    /**
     * Returns the color of the item.
     *
     * @return The color of the item.
     */
    public String getColor()
    {
        return this.color;
    }
    
    /**
     *  Sets the quantity of the item provided by the parameter. 
     *  The quantity is a whole number, and must be greater than 0.
     *  If the parameter is invalid, the quantity is set to 0.
     *
     *  @param quantity The quantity to be set of the item. 
     */
    public void setQuantity(int quantity)
    {
        if (quantity < 0)
        {
            this.quantity = 0;
        } else
        {
            this.quantity = quantity;
        }
    }
    
    /**
     * Returns the quantity of the item.
     *
     * @return The quantity of the item. 
     */
    public int getQuantity()
    {
        return quantity;
    }
    
    /**
     * Sets the category to the item provided by the parameter. 
     * The category is given by the category-number and displayed as the 
     * corresponding category.
     * 1 is floor, 2 is windows, 3 is doors and 4 is lumber, 5 is unknown.
     *  If the parameter is invalid, the category is set to UNKNOWN.
     *
     * @param category The category to be set of the item. 
    */
    
    private void setCategory(Categories category)
    {
        if (category == null)
        {
            this.category = Categories.UNKNOWN;
        } else
        {
            this.category = category;
        }
    }
    
    /**
     * Returns the category of the item.
     *
     * @return The category of the item. 
     */
    public Categories getCategory()
    {
        return this.category; 
    } 
}
