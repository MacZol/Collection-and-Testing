/**
 *  A class that maintains information about a book.
 * 
 * @author  Yang He 
 * @version Oct 2017
 */
public class Book
{
    private String id;          // Unique book ID 
    private String title;       // Book title
    private String author;      // Book author
    private boolean onloan;     // A flag indicating the status of the book, i.e. on load or not
    
    private static int nextID = 1;  // A static variable for generating a unique book ID
    
    /**
     * Create a new book with the given title and author
     * 
     * @param title  Book's title
     * @param author Book's author
     */
    public Book(String title, String author)
    {
        id = "Book#" + nextID;
        this.title = title;
        this.author = author;
        onloan = false;
        nextID++;
    }

    /**
     * Get the book ID.
     * 
     * @return The book ID.
     */
    public String getID()
    {
        return id;
    }
    
    /**
     * Get the book title.
     * 
     * @return The title of the book.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Get the book author.
     * 
     * @return The author of the book.
     */
    public String getAuthor()
    {
        return author;
    }
        
    /**
     * Check if the book is on loan
     * 
     * @return true if the book is on load, false otherwise
     */
    public boolean isOnLoan()
    {
        return onloan;
    }
    
    /**
     * Mark the book as on loan.
     */
    public void borrowed()
    {
        onloan = true;
    }
    
    /**
     * Mark the book as returned.
     */
    public void returned()
    {
        onloan = false;
    }
     
    /**
     * Print the details of the book, i.e. its id, title, author and whether it's status
     */
    public void print()
    {
        String details = id + ": '" + title + "'  by " + author;
        if (isOnLoan()) {
            details += " (on loan)";
        }
        else {    
            details += " (available)";
        }
        System.out.println(details);
    } 
    
    /**
     * Check if this book's title and author 
     * are the same as the given ones
     * 
     * @param title  The title of abook
     * @param author The author of abook
     * @return true if the book book's title and author 
     * are the same as the given ones. Otherwise false.
     */
    public boolean isSame(String title, String author)
    {
        return this.title.equals(title) &&
               this.author.equals(author);
    }
}
