
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReturnBook implements Command{
    private final int bookId;
    private final int memberId;
    private final Library library;
    private final LocalDate returnTime;

    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public Library getLibrary() {
        return library;
    }

    public LocalDate getReturnTime() {
        return returnTime;
    }

    public ReturnBook(Library library, String bookId, String memberId, String returnTime){
        this.library=library;
        this.bookId= Integer.parseInt(bookId);
        this.memberId= Integer.parseInt(memberId);
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.returnTime =LocalDate.parse(returnTime,formatter);
    }
    @Override
    public void execute() {
        try{
            try{
                Book book = getLibrary().getLibraryCollection().get(getBookId()-1);
                Member member = getLibrary().getMembers().get(getMemberId()-1);
                member.returnBook(book,getReturnTime());
                if (!book.getStatus().equals("Available")) {
                    book.setStatus("Available");
                    if (member.getFee() > 0) {
                        getLibrary().updateOutput("You must pay a penalty!");
                    }
                    getLibrary().getBorrowedList().remove(book);
                    getLibrary().getReadInList().remove(book);
                    getLibrary().updateOutput(String.format("The book [%s] was returned by member [%s] at %s Fee: %s"
                            ,getBookId(), getMemberId(), getReturnTime(), member.getFee()));

                }else {
                    throw new ReturnError();
                }
            }catch (ClassCastException e){
                throw new ReturnError();
            }


        }catch (ReturnError e){
            getLibrary().updateOutput(e.getMessage());
        }
    }
    }

