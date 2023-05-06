import java.time.LocalDate;

public class Student extends Member{


    public static final int timeLimit= 7;
    public Student(int id) {
        super(id);
    }

    @Override
    public void readBook(Book book, LocalDate readTime) throws AccessError {
        try {
            Printed printedBook = (Printed) book;//students do not have access the handwritten books
            printedBook.readIn(readTime);
            book.setBorrowingUser(this);


        }catch (ClassCastException e){
            throw new AccessError();
        }
    }

}
