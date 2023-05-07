import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReadInLibrary implements Command{
    private final int bookId;
    private final int memberId;
    private final Library library;
    private final LocalDate readTime;

    public int getMemberId() {
        return memberId;
    }

    public Library getLibrary() {
        return library;
    }

    public LocalDate getReadTime() {
        return readTime;
    }

    public int getBookId() {
        return bookId;
    }

    /**
     *
     * @param library working library
     * @param bookId id of the  book returned
     * @param memberId member Id that holds the book
     * @param readTime readTime of the book
     */
    public ReadInLibrary(Library library, String bookId, String memberId, String readTime){
        this.library=library;
        this.bookId= Integer.parseInt(bookId);
        this.memberId= Integer.parseInt(memberId);
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.readTime =LocalDate.parse(readTime,formatter);
    }


    @Override
    public void execute() {
        try {
        Book book = getLibrary().getLibraryCollection().get(getBookId()-1);
        if (book.getStatus().equals("Available")){
            Member member = getLibrary().getMembers().get(getMemberId()-1);
            member.readBook(book,getReadTime());
            getLibrary().getReadInList().add(book);//add book to specific read In list
            getLibrary().updateOutput(String.format("The book [%s] was read in library by member [%s] at %s"
                ,getBookId(),getMemberId(),getReadTime()));
        }else {
            throw new ReadError();
        }
    }catch (AccessError | ReadError e){
            getLibrary().updateOutput(e.getMessage());
        }
    }
}
