
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
                Member member = library.getMembers().get(memberId-1);
                member.returnBook(book,returnTime);
                if (!book.getStatus().equals("Available")) {
                    book.setStatus("Available");
                    if (member.getFee() > 0) {
                        library.updateOutput("You must pay a penalty!");
                    }
                    library.getBorrowedList().remove(book);
                    library.getReadInList().remove(book);
                    library.updateOutput(String.format("The book [%s] was returned by member [%s] at %s Fee: %s"
                            , bookId, memberId, returnTime, member.getFee()));

                }else {
                    throw new ReturnError();
                }
            }catch (ClassCastException e){
                throw new ReturnError();
            }


        }catch (ReturnError e){
            library.updateOutput(e.getMessage());
        }
    }
    }

