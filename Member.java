import java.util.ArrayList;

/**
 * The Member class represents a member in a local library.
 * It holds relevant details of a member.
 * 
 * @author Yang He
 * @version  Oct 2017
 */
public class Member
{
    private String id;              // Member's ID
    private String name;            // Member's name
    private ArrayList<Book> books;  // books borrowed by the member
    
    /**
     * Create a new member with a given ID and name.
     * 
     * @param id   Member's ID
     * @param name Member's name 
     */
    public Member(String id, String name)
    {
        this.id = id;
        this.name = name;
        books = new ArrayList<>();
    }

    /**
     * Get the member's ID.
     * 
     * @return The ID of the member.
     */
    public String getID()
    {
        return id;
    }
    
    /**
     * Get the member's name.
     * 
     * @return The name of the member.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Get the list of books borrowed by the member.
     * 
     * @return The list of books borrowed by the member.
     */
    public ArrayList<Book> getBooks()
    {
        return books;
    }
    
    /**
     * Borrows a book.
     * 
     * @param A given book.
     */
    public void borrowBook(Book aBook)
    {
        aBook.borrowed();
        books.add(aBook);
    }
    
    /**
     * Returns a book.
     * 
     * @param A given book.
     */
    public void returnBook(Book aBook)
    {
        
        aBook.returned();
        books.remove(aBook);
    }
    
    /**
     * Returns the number of books borrowed by the member
     * 
     * @return The number of books borrowed by the member
     */
    public int numberOfBooks()
    {
        return books.size();
    }
    
    /**
     * Check if the member has borrowed a book
     * with the given title by the given author.
     * 
     * @param The title of a given book
     * @param the author of a given book
     * @return The book borrowed by the member that has
     * the given title by the given author
     */
    public Book getBookBorrowed(String title, String author)
    {
        Book bookFound = null;
        int index = 0;
        while (index < books.size() && bookFound == null) {
            Book b = books.get(index);
            if (b.isSame(title, author)) {
                bookFound = b;
            }
            index++;
        }
        return bookFound;
    }
    
    /**
     * Print the details of the member:
     * ID, name and the number of books borrowed
     * 
     */ 
    public void print()
    {
        String info = "ID: " + id + "  Name: " + name + " (borrowed ";
        if (numberOfBooks() == 0) {
            info = info + "none.)";
        }
        else {
            info = info + numberOfBooks() + " books)";
        }
        System.out.println(info);
    }
    
}
