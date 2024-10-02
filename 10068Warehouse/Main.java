
/**
 * Represents the starting point of the application.
 *
 * @author Candidate number 10068
 * @version 12-12-2022
 */
public class Main
{
    /**
     * The main starting point of the application. The operating system
     * of the computer expects to find a publicly available method it can call
     * without having to create objects first. 
     * 
     * <p>This method is standardized accross languages and operating systems
     * and must have the signature given below.
     *
     * @param args an fixed size array of strings holding arguments provided
     *        from the command line during the startup of the application.
     *        In this application, args is not being used, and can be ignored.
     */
    public static void main(String[] args) 
    {
        WarehouseApp warehouseApp = new WarehouseApp();
        
        warehouseApp.init();
        warehouseApp.start();
    }
}
