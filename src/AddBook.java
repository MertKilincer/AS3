public class AddBook implements Command{
    private Book book;//book instance that will be added to libray instance
    private final Library library;//library instance

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
        //type based book instance creation
        if (type.equals("H")){
            setBook(new Handwritten(getLibrary().getLibraryCollection().size()+1));
            getLibrary().getHandwrittenList().add(getBook());
        }else if(type.equals("P")){
            setBook(new Printed(getLibrary().getLibraryCollection().size()+1));
            getLibrary().getPrintedList().add(getBook());
        }
        getLibrary().getLibraryCollection().add(getBook());
    }
    public void execute() { getLibrary().updateOutput("Created new book: "+getBook().info());
    }
}

