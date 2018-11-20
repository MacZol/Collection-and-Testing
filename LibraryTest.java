import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LibraryTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LibraryTest
{    
    Library myLibrary;
    Book b1, b2, b3;
        
    /**
     * Default constructor for test class LibraryTest
     */
    public LibraryTest()
    {
       
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {       
        myLibrary = new Library();
        
        b1 = new Book("Harry Potter", "J.K. Rowling");
        b2 = new Book("The Lord of the Rings", "J.R.R. Tolkien");
        b3 = new Book("Harry Potter", "J.K. Rowling");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testAddBook()
    {      
        System.out.println("#####################");
        System.out.println("### Test addBook  ###");
        System.out.println("#####################");
        System.out.println("Positive testing:");
        System.out.println("(1) Add the 1st book " + b1.getID());
        myLibrary.addBook(b1);
        System.out.println("(2) Add the 2nd book " + b2.getID());
        myLibrary.addBook(b2);
        System.out.println("(3) Add the 3rd book with the same title & author as the 1st one");
        myLibrary.addBook(b3);
        
        System.out.println("------------------------------------------------");
        System.out.println("Negative testing:");
        System.out.println("(1) Add the 1st book again");
        myLibrary.addBook(b1);
        System.out.println("(2) Add a null");
        myLibrary.addBook(null);
               
        System.out.println("------------------------------------------------");
        System.out.println("List of books in the library:");
        myLibrary.printBookDetails();        
    }
    

    @Test
    public void addMember()
    {
        System.out.println("#####################");
        System.out.println("### Test addMember ###");
        System.out.println("#####################");
        System.out.println("Positive testing:");
        System.out.println("Adding three members");
        // Create new members
        Member member1 = new Member("1", "Maciek");
        Member member2 = new Member("2", "Tim");
        Member member3 = new Member("3", "Ali");
        // Add these members to the library
        myLibrary.addMember(member1);
        myLibrary.addMember(member2);
        myLibrary.addMember(member3);
        System.out.println("------------------------------------------------");
        System.out.println("Total number of members");
        System.out.println("------------------------------------------------");
        // Print total members to confirm they have been added
        myLibrary.getMember();
        
        System.out.println("------------------------------------------------");
        System.out.println("Negative testing:");
        System.out.println("Same member ID for 2 members");
        Member member4 = new Member("4", "Maciek");
        myLibrary.addMember(member1);
        // Creating second member with the same ID
        Member member5 = new Member("4", "Tim");
        // Adding the member with same ID
        myLibrary.addMember(member2);
        System.out.println("------------------------------------------------");
        System.out.println("Adding a null value");
        // Adding null value
        myLibrary.addMember(null);
    }
}


