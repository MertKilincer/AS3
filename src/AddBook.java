public class AddBook implements Command{
    private Book book;
    private final Library library;

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Library getLibrary() {
        return library;
    }

    public AddBook(Library library, String type) {
        this.library=library;
        if (type.equals("H")){
            setBook(new Handwritten(getLibrary().getLibraryCollection().size()+1));
            getLibrary().getHandwrittenList().add(getBook());
        }else if(type.equals("P")){
            setBook(new Printed(getLibrary().getLibraryCollection().size()+1));
            getLibrary().getPrintedList().add(getBook());
        }
    }
    public void execute() {
        getLibrary().getLibraryCollection().add(getBook());
        getLibrary().updateOutput("Created new book: "+getBook().info());
    }
}

