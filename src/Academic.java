import java.time.LocalDate;


public class Academic extends Member {

    public static final int timeLimit=14;
    public Academic(int id) {
        super(id);
    }

    @Override
    public void readBook(Book book, LocalDate readTime) {
        book.readIn(readTime);
        book.setReader(this);
    }
}
