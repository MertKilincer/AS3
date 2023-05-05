import java.time.LocalDate;

public class Student extends Member{

    public static boolean Access = false;
    public static final int timeLimit= 7;
    public Student(int id) {
        super(id);
    }

    @Override
    public void readBook(Book book, LocalDate readTime) throws AccessError {
        try {
            Printed printedBook = (Printed) book;
            printedBook.readIn(readTime);


        }catch (ClassCastException e){
            throw new AccessError();
        }
    }

}
