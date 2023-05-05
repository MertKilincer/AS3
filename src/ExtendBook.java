import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExtendBook implements Command{
    private final int bookId;
    private final int memberId;
    private final Library library;
    private final LocalDate currentTime;
    public ExtendBook(Library library,String bookId,String memberId,String currentDate){
        this.library=library;
        this.bookId= Integer.parseInt(bookId);
        this.memberId= Integer.parseInt(memberId);
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.currentTime =LocalDate.parse(currentDate,formatter);
    }
    @Override
    public void execute() {
        try {
        Borrowable book = (Borrowable) library.getLibraryCollection().get(bookId-1);
        Member member = library.getMembers().get(memberId-1);
        book.extend(library);
        library.updateOutput(String.format("New deadline of book [%s] is %s",bookId,book.getDeadline()));
    }catch (ExtendError e){
            library.updateOutput(e.getMessage());
        }
    }
}
