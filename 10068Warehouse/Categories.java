
/**
 * Represents the valid categories in the warehouse register.
 *
 * @author Candidate number 10068
 * @version 12-12-2022
 */
public enum Categories
{
    FLOOR_LAMINATES(1), WINDOWS(2), DOORS(3), LUMBER(4), UNKNOWN(5);
     
    int categoryNumber;
    
    /**
     * Initialise with the corresponding categorynumber.
     *
     * @param categoryNumber The categorynumber.
     */
    Categories(int categoryNumber)
    {
        this.categoryNumber = categoryNumber;
    }
    
    /**
     * Returns the category as a number.
     *
     * @return The category as a number.
     */
    public int getCategory()
    {
        return categoryNumber;
    }
    
    /**
     * Returns the found category to the given corresponding categorynumber.
     *
     * @param number The categorynumber to be found
     * @return The found category to the given corresponding categorynumber.
     */
    public static Categories getCategoryByNumber(int number)
    {
        Categories[] categories = Categories.values();
        Categories foundCategory = Categories.UNKNOWN;
        for (int i = 0; i < categories.length; i++)
        {
            Categories currentCategory = categories[i];
            if (currentCategory.getCategory() == number)
            {
                foundCategory = currentCategory;
            }
        }
        return foundCategory;
    }
}
