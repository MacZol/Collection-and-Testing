import java.util.ArrayList;

/**
 * Write a description of class Library here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Library
{
    private ArrayList<Member> members;   // A list of members registered in the library
    private ArrayList<Book> books;       // A collection of books in the library
    
    // The maximum number of books a member can borrow from the library
    public final int MAX_NUM_BOOKS = 4;
    
    /**
     * Constructor for objects of class Library
     */
    public Library()
    {
        members = new ArrayList<>();
        books = new ArrayList<>();
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    // Start of your code
    
    /**
     * Task 1
     * Method to print the details of all members in the library
     * also contain total number of members
     */
    public void getMember()
    {
        // Local variable
        int totalMemb = 0;
        System.out.println("All members: ");
        //For loop to access and print out all details out of array list
        for(Member member : members) {
            //Print details of member
            member.print();
            // Increase total count of members
            totalMemb++;
        }
        System.out.println("Total number of members: " + totalMemb);
        
    }
    
    
    /**
     * Task 2
     * Method that takes title and author and returns number of copies of the same book in ibrary
     */
    public int numbOfCopies(String title, String author)
    {
        // Local variable
        int sameBooks = 0;
        for (Book b : books)
        {
            // If the same title and author is found
            boolean sameDetails = b.isSame(title, author);
            // If value is positive, it will increase count
            if (sameDetails)
            {   
                // Increase count
                sameBooks++;
            }
        }
        return sameBooks;
    }
    
    
    /**
     * Task 3
     * Register a new member in the library, takes an object of member returns nothing
     * adds member into members list if valid, if not message is displayed
     * the list members must not contain null values
     * the membership ID must be unique
     */
    public void addMember(Member newMember) 
    {
        // Check if newMember is null
        if (newMember == null) {
            System.out.println("It is null."); 
        }
        else
        {        
            // Check if newMember is already in the library
            if (isMember(newMember) == true || uniqueMID(newMember.getID()) == false)
            {
                // Error message
                System.out.println(newMember.getID() + " is already a member."); 
            }
            else
            {
                // Add member
                members.add(newMember);        
            }
        }
    }
    
    
    /**
     * Task4
     * Checks if there is a book with given title and author in the library that is
     * available for members to borrow, if there is, it should retuern the book
     */
    public Book getBook(String title, String author)
    {
        for (Book b : books)
        {
            if (b.isOnLoan() == false && b.isSame(title, author) == true)
            {
                return b;
            }
        }
        return null;
    }
    
    /**
     * Task 5
     * Method that takes an object of member and prints out the details of given member
     * Also print out details of all books borrowed by member
     */
    public void printMembDetails(Member memb)
    {
        // Checks if the member exists
        if (!isMember(memb)) 
        {
            // If not error message comes up
            System.out.println("This member does not exist!");
        }
        else
        {
            // If yes member details are printed out
            memb.print();
            
            // With for loop to print out all of the details of the books borrrowed by the member
            for (Book b : memb.getBooks())
            {
                b.print();
            }
        }
    }
    
    /**
     * Task 6
     * Method that allows member to borrow a book, by taking parameters of member,
     * title and author
     * Only members can borrow books
     * If a member already has a copy of a book, they cannot take it our again
     */ 
    public void memberBorrowBook(Member memb, String title, String author)
    {
        // Checks if member is registered
        if (!isMember(memb)) 
        {   
            // Message informing user
            System.out.println("This person is not a member");
        }
        else
        {   
            // If member, for loop is used to carry out actions like printng out details for book array list
            for (Book b : books)
            {   
                // Checks if given title and author matches within the array list
                if (b.isSame(title, author)) 
                {
                    // Checks if book is on loan
                    if (b.isOnLoan() == false)
                    {
                        // If book is not loaned out, member is allowed to borrow the book
                        memb.borrowBook(b);
                        // With following message informing the user they borrowed the book
                        System.out.println(memb.getName() + " has now borrowed " + title + " " + author);
                    }
                    else
                    {
                        // If the book is loaned out, error message comes up
                        System.out.println("The member " + memb.getName() + " cannot take out the book " + title + " " + author);
                    }
                }
                else
                {
                    // If not book is found, an error message comes up
                    System.out.println("This book is not in the library");
                }
                // Break used to exit loop after code is executed, otherwise if there are more than one of the same book, the for loop would take out all of the same book for one user
                break;
            }
        }
    }
    // End of your code
    //////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Add a new book into the books list of the library
     * 
     * @param newBook A given book to be added into the books list of the library
     */
    public void addBook(Book newBook) 
    {
        // Check if newBook is null
        if (newBook == null) {
            System.out.println("It is null."); 
        }
        else {        
            // Check if newBook is already in the library
            if (books.contains(newBook)) {
                System.out.println(newBook.getID() + " is already in the library."); 
            }
            else {
                books.add(newBook);        
            }
        }
    }
              
    /**    
     * Print the details of all books 
     */
    public void printBookDetails() 
    {
        for (Book b: books) {
            b.print();
        }      
    }   
    
    /**
     * A member returns a book
     * 
     * @param aMember   An object of Member
     * @param title  The title of a book
     * @param author The author of a book
     * 
     */
    public void returnBook(Member aMember, String title, String author) 
    {
        // Check if the given aMember is a registered member of the library 
        if (!isMember(aMember)) {
            System.out.println("This person is not a member.");
        }
        else {                
            Book bookBorrowed = aMember.getBookBorrowed(title, author);
            
            // Check if the given member has actually borrowed 
            // a book with the given title and author                   
            if (bookBorrowed == null) {
                System.out.println(aMember.getID() + 
                    " has not borrowed '" + title + "' by " + author);
            }
            else {
                aMember.returnBook(bookBorrowed); 
                System.out.println(aMember.getID() + " has now returned the book '" 
                                  + title + "' by " + author);
            }
        }
    }
    
    /**
     * Check if a given member is a registered member of the library
     * 
     * @param aMember A given member
     * @return true if aMember is in the list members, otherwise false
     */
    public boolean isMember(Member aMember) 
    {
        return members.contains(aMember);
    }
    
    /**
     * Check if the given member ID is unique
     * 
     * @param mid A given member ID
     * @return true if the given mid is not assigned to any members in the library
     * otherwise false
     */
    public boolean uniqueMID(String mid) 
    {
        boolean isUnique = true;
        int index = 0;
        while (index < members.size() && isUnique) {
            Member m = members.get(index);
            if (m.getID().equals(mid)) {
                isUnique = false;
            }
            index++;
        }
        return isUnique;
    }  
}
