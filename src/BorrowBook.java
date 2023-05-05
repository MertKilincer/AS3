import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BorrowBook implements Command {

    private final int bookId;
    private final int memberId;
    private final Library library;
    private final LocalDate borrowTime;


    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public Library getLibrary() {
        return library;
    }

    public LocalDate getBorrowTime() {
        return borrowTime;
    }

    public BorrowBook(Library library, String bookId, String memberId, String borrowTime) {
        this.library = library;
        this.bookId = Integer.parseInt(bookId);
        this.memberId = Integer.parseInt(memberId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.borrowTime = LocalDate.parse(borrowTime, formatter);
    }

    @Override
    public void execute() {
        try {
            try {
                Book book = getLibrary().getLibraryCollection().get(getBookId() - 1);
                if (book.getStatus().equals("Available")) {
                    Member member = getLibrary().getMembers().get(getMemberId() - 1);
                    member.borrowBook(book, getBorrowTime());
                    getLibrary().getBorrowedList().add(book);
                    getLibrary().updateOutput(String.format("The book [%s] was borrowed by member [%s] at %s"
                            , getBookId(), getMemberId(), getBorrowTime()));
                } else {
                    throw new BorrowingError();
                }
            } catch (ClassCastException e) {
                throw new BorrowingError();
            }

        } catch (BorrowingError | BorrowExceedError e) {
            getLibrary().updateOutput(e.getMessage());
        }
    }
}
