import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Represent the warehouse application, including the dialog with
 * the user, both input and output.
 *
 * @author Candidate number 10068
 * @version 12-12-2022
 */
public class WarehouseApp
{
    private static final int LIST_ALL_ITEMS = 1;
    private static final int SEARCH_ITEM_BY_ITEMNUMBER = 2;
    private static final int ADD_ITEM = 3; 
    private static final int INCREASE_QUANTITY_OF_AN_ITEM = 4;
    private static final int DECREASE_QUANTITY_OF_AN_ITEM = 5;
    private static final int REMOVE_ITEM = 6; 
    private static final int CHANGE_ITEM = 7;
    private static final int CHANGE_PRICE = 8;
    private static final int EXIT = 9; 
    
    private static final int CHANGE_DESCRIPTION = 1;
    private static final int CHANGE_BRANDNAME = 2;
    private static final int CHANGE_WEIGHT = 3; 
    private static final int CHANGE_LENGTH = 4;
    private static final int CHANGE_HEIGHT = 5;
    private static final int CHANGE_COLOR = 6; 
    private static final int EXIT_ITEM = 7; 
    
    private static final int DISCOUNT_PERCENT = 1;
    private static final int DISCOUNT_KRONER = 2;
    private static final int NEW_PRICE = 3;
    private static final int EXIT_PRICE = 4;
    
    private WarehouseRegister warehouseRegister;
    
    /**
     * Creates an instance of WarehouseApp.
     */
    public WarehouseApp()
    {
        this.warehouseRegister = new WarehouseRegister();
    }
    
    /**
     * Fill the warehouseregister with default items, which initializes the
     * application. 
     */
    public void init()
    {
        this.warehouseRegister.fillWarehouseRegisterWithDefaultItems();
    }
    
    /**
     * "Starts" the application, by presenting a menu for the user.
     * The user can chose from the menu, and for each choice,
     * a task is performed, and the menu is displayed again.
     * 
     * <p>When the user wants to terminate/exit the application,
     * he/she chooses the Exit-alternativ in the menue, and the
     * application terminates.
     */
    public void start()
    {
        boolean finished = false;
        while (!finished)
        {       
            int selectedMenu = showMenu();

            switch (selectedMenu)
            {
                case LIST_ALL_ITEMS:
                    this.printAllItems();
                    break;
                    
                case SEARCH_ITEM_BY_ITEMNUMBER:
                    this.findItemByItemNumber();
                    break;
                    
                case ADD_ITEM:
                    this.addItem();
                    break;
                    
                case INCREASE_QUANTITY_OF_AN_ITEM:
                    this.increaseQuantityOfAnItem();
                    break;
                    
                case DECREASE_QUANTITY_OF_AN_ITEM:
                    this.decreaseQuantityOfAnItem();
                    break;
                
                case REMOVE_ITEM:
                    this.removeItem();
                    break;
                
                case CHANGE_ITEM:
                    this.changeItem();
                    break;
                
                case CHANGE_PRICE:
                    this.changePrice();
                    break;

                case EXIT:
                    System.out.println("Thank you for choosing the WarehouseApp!");
                    finished = true;
                    break;

                default:
                    System.out.println("Sorry, you seem to have entered a wrong value."
                                       + "\nPlease try again :-)");
                    break;
            }
        }
    }
    
    /**
     * Displays the menu for the user, followed by awaiting the menu choice
     * chosen by the user, which is then returned.
     * 
     * <p>If the user inputs an invalid choice, 0 is returned.
     *
     * @return selectedMenu The menu choice of the user as an integer. If the user has
     *         entered an invalid choice, 0 is returned.
     */
    private int showMenu()
    {
        int selectedMenu = 0;
        System.out.println("\n*** Welcome to Warehouse Application ***\n");

        System.out.println("1) List all items");
        System.out.println("2) Search for an item with item number");
        System.out.println("3) Add a new item");
        System.out.println("4) Increase quantity of an item");
        System.out.println("5) Decrease quantity of an item");
        System.out.println("6) Remove item from warehouse");
        System.out.println("7) Change an item");
        System.out.println("8) Change price of an item");
        System.out.println("9) Exit");
        System.out.println();
        System.out.println("\nPlease enter a number between 1 and 9.\n");

        Scanner userInput = new Scanner(System.in);

        if (userInput.hasNextInt())
        {
            selectedMenu = userInput.nextInt();
            userInput.nextLine(); 
        } 
        
        return selectedMenu;
    }
    
    /**
     * Listing all items in the terminal window.
     */
    private void printAllItems()
    {
        System.out.println("List of items in the warehouse: ");
        Iterator<Item> it = this.warehouseRegister.getIterator();
        while (it.hasNext())
        {
            Item item = it.next();
            this.printItemDetails(item);
        }
    }
    
    /**
     * Print item details provided by the parameter.
     *
     * @param item The item to be printed details.
     */
    private void printItemDetails(Item item)
    {
        System.out.println("Item number: " 
                + item.getItemNumber()
                + "\nDescription: " 
                + item.getDescription()
                + "\nPrice: " 
                + item.getPrice()
                + " kr\nBrand name: " 
                + item.getBrandName()
                + "\nWeight: " 
                + item.getWeight()
                + " kg\nLength: " 
                + item.getLength()
                + " m\nHeight: " 
                + item.getHeight()
                + " m\nColor: " 
                + item.getColor()
                + "\nQuantity: " 
                + item.getQuantity()
                + "\nCategory: " 
                + item.getCategory() + "\n");
                
    }

    /**
     * Find item by itemnumber chosen by the user. 
     * If a item with the provided itemnumber exsist in the warehouseregister,
     * the item details is printed. If the item does not exsist, an error 
     * message is printed to the user.
     *
     * @return item The item found by provided itemnumber
     */
    private Item findItemByItemNumber()
    {
        String itemNumber = getInputString("Please enter the item number for "
                                            + "the item you want to find:");
        Item item = this.warehouseRegister.findItemByItemNumber(itemNumber);
        if ((item ==  null) || (itemNumber.isBlank())) 
        {
            System.out.println("Sorry, no item found with item number '" + itemNumber + "'" 
                                + "\nCheck spelling errors and try again."
                                + "\nHitting whitespace is a common mistake ;)\n");
        } else
        {
            System.out.println("\nItem found with item number '" 
                               + itemNumber 
                               + "':\n");
            printItemDetails(item);
        }
        return item;
    }
    
    /**
     * Creates an new item provided by the user input. The item is added 
     * to the warehouse register. 
     * 
     * <p>If the itemnumber provided by the user already exsists in the 
     * warehouse register. The user gets an error message and need to try 
     * another itemnumber, because each item needs an uniqe itemnumber.
     */
    private void addItem()
    {
        System.out.println("Please supply following information about the item");
        String itemNumber = getInputString("Item number: ");
        while (this.warehouseRegister.findItemByItemNumber(itemNumber) != null)
        {
            System.out.println("This item number already exist, please try again.");
            itemNumber = getInputString("Item number: ");
        }
        String description = getInputString("Description: ");
        String brandName = getInputString("Brand name: ");
        double price = getInputDouble("Price in norwegian kroner: ");
        double weight = getInputDouble("Weight in kilos: ");
        double length = getInputDouble("Length in meters: ");
        double height = getInputDouble("Heightin meters: ");
        String color = getInputString("Color: ");
        int quantity = getInputInt("Quantity:");
        System.out.println("1. Floor laminates \n2. Windows \n3. Doors \n4. Lumber \n5. Unknown");
        int categoryNumber = getInputInt("Category: ");
        Categories category = Categories.getCategoryByNumber(categoryNumber);
        
        Item item = new Item(itemNumber, description, price, brandName, weight, length,
                             height, color, quantity, category);
        this.warehouseRegister.addItem(item);
    }
    
    /**
     * A helper method to check if the user input of the type String is 
     * valid. The user input can not be empty or just consisting of 
     * whitespaces. 
     *
     * @return input The user input. If the user input is valid, an error
     *         message is printed to the user. The user need to provide a 
     *         valid value.
     */
    private String getInputString(String userOutput)
    {
        Scanner userInput = new Scanner(System.in);
        String input = ""; 
        while (input.isBlank())
        {
            System.out.println(userOutput);
            input = userInput.nextLine();
            if (input.isBlank())
            {
                System.out.println("Please enter a valid input. It can't be blank.");
            }
        }
        return input;
    }
    
    /**
     * A helper method to check if the user input of the type Int is 
     * valid. The user input must be greater than 0.
     *
     * @return input The user input. If the user input is valid, an error
     *         message is printed to the user. The user need to provide a 
     *         valid value.
     */    
    private int getInputInt(String userOutput)
    {
        Scanner userInput = new Scanner(System.in);
        int input = -1;    
 
        while (input < 0)
        {
            System.out.println(userOutput);
            if (userInput.hasNextInt())
            {
                input = userInput.nextInt();
                if (input < 0)
                {
                    System.out.println("Please enter whole number greater than 0");
                }
            } else
            {
                System.out.println("Please enter whole number greater than 0");
            }
            userInput.nextLine();
        }
        return input;
    }

    /**
     * A helper method to check if the user input of the type Double is 
     * valid. The user input must be greater than 0.
     *
     * @return input The user input. If the user input is valid, an error
     *         message is printed to the user. The user need to provide a 
     *         valid value.
     */    
    private double getInputDouble(String userOutput)
    {
        Scanner userInput = new Scanner(System.in);
        double input = -1.0;    
        while (input < 0)
        {
            System.out.println(userOutput);
            if (userInput.hasNextDouble())
            {
                input = userInput.nextDouble();
                if (input < 0)
                {
                    System.out.println("Please enter a number greater than 0");
                }
            } else
            {
                System.out.println("Please enter a number greater than 0");
            }
            userInput.nextLine();
        }
        return input;
    }
    
    /**
     * Requests the itemnumber to the item to be increased quantity from 
     * the user. 
     * 
     * <p>If the item with provided itemnumber exsist, the user provide the 
     * quantity to add to the found item. The quantity to add is added to 
     * the original quantiny. If not, an error message is printed to the user.
     */
    private void increaseQuantityOfAnItem()
    {
        Item foundItem = findItemByItemNumber();
        
        if (!(foundItem == null))
        {
            int quantityToAdd = getInputInt("Select an quantity to add: ");
            this.warehouseRegister.increaseQuantityOfAnItem(foundItem, quantityToAdd); 
            System.out.println("The quantity is " + foundItem.getQuantity() + " units.");
        }
    }
    
    /**
     * Requests the itemnumber to the item to be decreased quantity from 
     * the user. 
     *
     * <p>If the item with provided itemnumber exsist, the user provide the 
     * quantity to remove to the found item. The quantity to remove is removed to 
     * the original quantiny. If not, an error message is printed to the user.
     */

    private void decreaseQuantityOfAnItem()
    {
        Item foundItem = findItemByItemNumber();

        if (!(foundItem == null))
        {
            int quantityToRemove = getInputInt("Select an quantity to remove: ");
            if (quantityToRemove > foundItem.getQuantity())
            {
                System.out.println("Please enter a valid value. "  
                                    + "\nThe quantity to decrease can not be "
                                    + "larger than the original quantity of the item.");
            }
            this.warehouseRegister.decreaseQuantityOfAnItem(foundItem, quantityToRemove); 
            System.out.println("The quantity is " + foundItem.getQuantity() + " units");
        }
    }
    
    /**
     * Requests the itemnumber to the item to be removed from the user. 
     *
     * <p>If the item with provided itemnumber exsist, the item will be 
     * removed. If the item do not exsist, an error message is printed
     * to the user. 
     */

    private void removeItem()
    {
        Item itemToDelete = findItemByItemNumber();
        
        if (!(itemToDelete == null))
        {
            if (this.warehouseRegister.removeItem(itemToDelete))
            {
                System.out.println("Item with item number '" 
                                   + itemToDelete.getItemNumber() 
                                   + "' was successfully removed");
            } else
            {
                System.out.println("Sorry, could not remove the item with item number '" 
                                   + itemToDelete.getItemNumber() + "'");
            }
        }
    }

    /**
     * Representing a menu for the user. 
     * The user chooses how to change a item.
     * 
     * <p>The user can exit the item menu by using the "Exit" menu choice.
     */
    private void changeItem()
    {
        boolean finished = false;
        
        while (!finished)
        {
            
            int selectedMenu = itemMenu();
            
            switch (selectedMenu)
            {
                case CHANGE_DESCRIPTION:
                    this.setNewDescription();
                    break;
                       
                case CHANGE_BRANDNAME:
                    this.setNewBrandName();
                    break;
                    
                case CHANGE_WEIGHT:
                    this.setNewWeight();
                    break;
                    
                case CHANGE_LENGTH:
                    this.setNewLength();
                    break;
                
                case CHANGE_HEIGHT:
                    this.setNewHeight();
                    break;
                    
                case CHANGE_COLOR:
                    this.setNewColor();
                    break;
                    
                case EXIT_ITEM:
                    finished = true;
                    break;
                default:
                    System.out.println("Sorry, you seem to have entered something else "
                                    + "than a number between 1 and 8."
                                    + "\nPlease try again :-)");
                    
            }
        }
    }
    
    /**
     * Displays the item menu for the user. The user need to choose what to
     * change by provide the corresponding number
     * to the task. 
     * 
     * <p>If the user input is an invalid value, 0 is returned. 
     *
     * @return selectedMenu The selected menu choice. If the user input is
     *         invalid, 0 is returned. 
     */
    private int itemMenu()
    {
        int selectedMenu = 0;
        System.out.println("Select change");

        System.out.println("1. Description");
        System.out.println("2. Brand name");
        System.out.println("3. Weight");
        System.out.println("4. Length");
        System.out.println("5. Height");
        System.out.println("6. Color");
        System.out.println("7. Exit");
        System.out.println();
        System.out.println("\nPlease enter a number between 1 and 7.\n");
        
        Scanner userInput = new Scanner(System.in);
        
        if (userInput.hasNextInt())
        {
            selectedMenu = userInput.nextInt();
        } 

        userInput.close();
        
        return selectedMenu;
    }
    
    /**
     * Requests the itemnumber to the item to be set a new description from the user. 
     * 
     * <p>If the item with provided itemnumber exsist, the user is requested to
     * enter the new description for the found item. If the item do not exsist, an error
     * message is printed to the user.
     */
    private void setNewDescription()
    {
        Item foundItem = findItemByItemNumber();
        
        if (!(foundItem == null))
        {
            String newDescription = getInputString("Select the new description");
            this.warehouseRegister.setNewDescription(foundItem, newDescription); 
            System.out.println("The new description for " 
                               + foundItem.getItemNumber() 
                               + " is '"
                               + newDescription 
                               + "'");
        }
    }
    
    /**
     * Requests the itemnumber to the item to be set a new brand name from the user. 
     * 
     * <p>If the item with provided itemnumber exsist, the user is requested to
     * enter the new brand name for the found item. If the item do not exsist, an error
     * message is printed to the user.
     */
    private void setNewBrandName()
    {
        Item foundItem = findItemByItemNumber();
        
        if (!(foundItem == null))
        {
            String newBrandName = getInputString("Select the new brand name");
            this.warehouseRegister.setNewBrandName(foundItem, newBrandName); 
            System.out.println("The new brand name for " 
                               + foundItem.getItemNumber() 
                               + " is '"
                               + newBrandName
                               + "'");
        }
    }
    
    /**
     * Requests the itemnumber to the item to be set a new weight from the user. 
     * 
     * <p>If the item with provided itemnumber exsist, the user is requested to
     * enter the new weight for the found item. If the item do not exsist, an error
     * message is printed to the user.
     */
    private void setNewWeight()
    {
        Item foundItem = findItemByItemNumber();
        
        if (!(foundItem == null))
        {
            double newWeight = getInputDouble("Select the new weight");
            this.warehouseRegister.setNewWeight(foundItem, newWeight); 
            System.out.println("The new weight for " 
                               + foundItem.getItemNumber() 
                               + " is "
                               + newWeight 
                               + " kg.");
        }
    }
    
    /**
     * Requests the itemnumber to the item to be set a new length from the user. 
     * 
     * <p>If the item with provided itemnumber exsist, the user is requested to
     * enter the new length for the found item. If the item do not exsist, an error
     * message is printed to the user.
     */
    private void setNewLength()
    {
        Item foundItem = findItemByItemNumber();
        
        if (!(foundItem == null))
        {
            double newLength = getInputDouble("Select the new length");
            this.warehouseRegister.setNewLength(foundItem, newLength); 
            System.out.println("The new length for " 
                               + foundItem.getItemNumber() 
                               + " is "
                               + newLength 
                               + " m.");
        }
    }
    
    /**
     * Requests the itemnumber to the item to be set a new height from the user. 
     * 
     * <p>If the item with provided itemnumber exsist, the user is requested to
     * enter the new height for the found item. If the item do not exsist, an error
     * message is printed to the user.
     */
    private void setNewHeight()
    {
        Item foundItem = findItemByItemNumber();
        
        if (!(foundItem == null))
        {
            double newHeight = getInputDouble("Select the new height");
            this.warehouseRegister.setNewHeight(foundItem, newHeight); 
            System.out.println("The new height for " 
                               + foundItem.getItemNumber() 
                               + " is "
                               + newHeight
                               + " m.");
        }
    }
    
    /**
     * Requests the itemnumber to the item to be set a new color from the user. 
     * 
     * <p>If the item with provided itemnumber exsist, the user is requested to
     * enter the new color for the found item. If the item do not exsist, an error
     * message is printed to the user.
     */
    private void setNewColor()
    {
        Item foundItem = findItemByItemNumber();
        
        if (!(foundItem == null))
        {
            String newColor = getInputString("Select the new color");
            this.warehouseRegister.setNewColor(foundItem, newColor); 
            System.out.println("The new color for " 
                               + foundItem.getItemNumber() 
                                   + " is '"
                               + newColor
                               + "'");
        }
    }
    
    /**
     * Representing a menu for the user. 
     * The user chooses how to change the price of an item, by discount or
     * setting a new price.
     * 
     * <p>The user can exit the price menu by using the "Exit" menu choice.
     */
    private void changePrice()
    {
        boolean finished = false;
        
        while (!finished)
        {
            
            int selectedMenu = discountMenu();
            
            switch (selectedMenu)
            {
                case DISCOUNT_PERCENT:
                    this.setDiscountInPercent();
                    break;
                       
                case DISCOUNT_KRONER:
                    this.setDiscountInKroner();
                    break;
                        
                case NEW_PRICE:
                    this.setNewPrice();
                    break;
                       
                case EXIT_PRICE:
                    finished = true;
                    break;
                default:
                    System.out.println("Sorry, you seem to have entered something else "
                                    + "than a number between 1 and 3."
                                    + "\nPlease try again :-)");
                    
            }
        }
    }
    
    /**
     * Displays the price menu for the user. The user need to choose how 
     * to change the price in the menu by provide the corresponding number
     * to the task. 
     * 
     * <p>If the user input is an invalid value, 0 is returned. 
     *
     * @return selectedMenu The selected menu choice. If the user input is
     *         invalid, 0 is returned. 
     */
    private int discountMenu()
    {
        int selectedMenu = 0;
        System.out.println("Select discount type");

        System.out.println("1. Percent");
        System.out.println("2. Kroner");
        System.out.println("3. New price");
        System.out.println("4. Exit discount menu");
        System.out.println();
        System.out.println("\nPlease enter a number between 1 and 4.\n");
        
        Scanner userInput = new Scanner(System.in);
        
        if (userInput.hasNextInt())
        {
            selectedMenu = userInput.nextInt();
        } 

        userInput.close();
        
        return selectedMenu;
    }

    /**
     * Requests the itemnumber to the item to be discounted from the user. 
     * 
     * <p>If the item with provided itemnumber exsist, the user is requested to
     * enter the discount in percent. If the item do not exsist, an error
     * message is printed to the user.
     */
    private void setDiscountInPercent()
    {
        Item foundItem = findItemByItemNumber();
        
        if (!(foundItem == null))
        {
            int percent = getInputInt("Select the discount in percent. 0-100.");
            this.warehouseRegister.setDiscountInPercent(foundItem, percent); 
            System.out.println(percent + "% off gives " + foundItem.getItemNumber() 
                               + " the new price " 
                               + foundItem.getPrice() 
                               + " kr.");
        }
    }

    /**
     * Requests the itemnumber to the item to be discounted from the user. 
     * 
     * <p>If the item with provided itemnumber exsist, the user is requested to
     * enter the discount in kroner. If the item do not exsist, an error
     * message is printed to the user.
     */
    private void setDiscountInKroner()
    {
        Item foundItem = findItemByItemNumber();
        
        if (!(foundItem == null))
        {
            double discount = getInputDouble("Select the discount in kroner.");
            if (discount >= foundItem.getPrice())
            {
                System.out.println("Please enter a valid value. "
                                   + "The discount can not be higher "
                                   + "than the original price of the item.");
            }
            this.warehouseRegister.setDiscountInKroner(foundItem, discount); 
            System.out.println("The price for " 
                               + foundItem.getItemNumber() 
                               + " is " 
                               + foundItem.getPrice() 
                               + " kr.");
        }
    }

    /**
     * Requests the itemnumber to the item to be set a new price from the user. 
     * 
     * <p>If the item with provided itemnumber exsist, the user is requested to
     * enter the new price for the found item. If the item do not exsist, an error
     * message is printed to the user.
     */
    private void setNewPrice()
    {
        Item foundItem = findItemByItemNumber();
        
        if (!(foundItem == null))
        {
            double newPrice = getInputInt("Select the new price");
            this.warehouseRegister.setNewPrice(foundItem, newPrice); 
            System.out.println("The price for " 
                               + foundItem.getItemNumber() 
                               + " is "
                               + newPrice 
                               + " kr.");
        }
    }
}
