import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReturnBook implements Command{
    private final int bookId;
    private final int memberId;
    private final Library library;
    private final LocalDate returnTime;

    public ReturnBook(Library library,String bookId,String memberId,String returnTime){
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
                Book book = library.getLibraryCollection().get(bookId-1);
                ((Printed) book).Return(library.getMembers().get(memberId-1),returnTime);
                Duration duration = Duration.between(((Printed) book).getBorrowTime(), returnTime);
                long diff = Math.abs(duration.toDays());
                ((Printed) book).resetTimes();
                library.updateOutput(String.format("The book [%s] was returned by member [%s] at %s Fee: %s"
                        ,bookId,memberId,returnTime,diff));
            }catch (ClassCastException e){
                throw new BorrowingError();
            }

        }catch (BorrowingError e){
            library.updateOutput(e.getMessage());
        }
    }
    }

