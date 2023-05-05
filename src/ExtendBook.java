import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExtendBook implements Command{
    private final int bookId;
    private final int memberId;
    private final Library library;
    private final LocalDate currentTime;//check conditions

    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public Library getLibrary() {
        return library;
    }

    public LocalDate getCurrentTime() {
        return currentTime;
    }

    public ExtendBook(Library library, String bookId, String memberId, String currentDate){
        this.library=library;
        this.bookId= Integer.parseInt(bookId);
        this.memberId= Integer.parseInt(memberId);
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.currentTime =LocalDate.parse(currentDate,formatter);
    }
    @Override
    public void execute() {
        try {
        Borrowable book = (Borrowable) this.getLibrary().getLibraryCollection().get(this.getBookId()-1);
        if (book.getBorrowingUser().equals(this.getLibrary().getMembers().get(this.getMemberId()))){
            book.extend(this.getLibrary());
            this.getLibrary().updateOutput(String.format("New deadline of book [%s] is %s",
                    this.getBookId(),book.getDeadline()));
        }else {
            throw new ExtendError();
        }
    }catch (ExtendError e){
            this.getLibrary().updateOutput(e.getMessage());
        }
    }
}
