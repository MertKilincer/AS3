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
        Book book = getLibrary().getLibraryCollection().get(getBookId()-1);
        if (book.getBorrowingUser().equals(getLibrary().getMembers().get(getMemberId()-1))&&
                getCurrentTime().isBefore(((Borrowable)getLibrary().getLibraryCollection().get(getBookId()-1)).getDeadline())){
            ((Borrowable) book).extend(getLibrary());
            this.getLibrary().updateOutput(String.format("New deadline of book [%s] is %s",
                    getBookId(),((Borrowable)book).getDeadline()));
        }else {
            throw new ExtendError();
        }
    }catch (ExtendError e){
            getLibrary().updateOutput(e.getMessage());
        }
    }
}
