import java.time.LocalDate;

/**
 * Academic class is a subclass of member class that have different time limit constant and
 * readBook function
 */
public class Academic extends Member {

    public static final int timeLimit=14;//time limit for academics
    public Academic(int id) {
        super(id);
    }

    @Override
    public void readBook(Book book, LocalDate readTime) {
        book.readIn(readTime);//read book
        book.setBorrowingUser(this);//define the reader of the book
    }
}
