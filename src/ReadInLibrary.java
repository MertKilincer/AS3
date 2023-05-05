import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReadInLibrary implements Command{
    private final int bookId;
    private final int memberId;
    private final Library library;
    private final LocalDate readTime;

    public ReadInLibrary(Library library,String bookId,String memberId,String readTime){
        this.library=library;
        this.bookId= Integer.parseInt(bookId);
        this.memberId= Integer.parseInt(memberId);
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.readTime =LocalDate.parse(readTime,formatter);
    }


    @Override
    public void execute() {
        try {
        Book book = library.getLibraryCollection().get(bookId-1);
        if (book.getStatus().equals("Available")){
        Member member = library.getMembers().get(memberId-1);
        member.readBook(book,readTime);
        library.getReadInList().add(book);
        library.updateOutput(String.format("The book [%s] was read in library by member [%s] at %s"
                ,bookId,memberId,readTime));
        }else {
            throw new ReadError();
        }
    }catch (AccessError | ReadError e){
            library.updateOutput(e.getMessage());
        }
    }
}
