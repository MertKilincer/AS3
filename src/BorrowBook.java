import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BorrowBook implements Command{

    private final int bookId;
    private final int memberId;
    private final Library library;
    private final LocalDate borrowTime;


    public BorrowBook(Library library,String bookId,String memberId,String borrowTime){
        this.library=library;
        this.bookId= Integer.parseInt(bookId);
        this.memberId= Integer.parseInt(memberId);
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.borrowTime=LocalDate.parse(borrowTime,formatter);
    }

    @Override
    public void execute() {
        try{
            try{
                Book book = library.getLibraryCollection().get(bookId-1);
                Member member = library.getMembers().get(memberId-1);
                member.borrowBook(book,borrowTime);
                library.updateOutput(String.format("The book [%s] was borrowed by member [%s] at %s"
                        ,bookId,memberId,borrowTime));
        }catch (ClassCastException e){
            throw new BorrowingError();
        }

    }catch (BorrowingError e){
            library.updateOutput(e.getMessage());
        }
    }
}
