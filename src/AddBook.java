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

    /**
     * this creates our addBook class that implements Command interface
     * @param library library is the working library for command
     * @param type type is book types that is acceptable by systems like P and H
     */
    public AddBook(Library library, String type) {
        this.library=library;
        //type based book instance creation
        if (type.equals("H")){
            setBook(new Handwritten(getLibrary().getLibraryCollection().size()+1));//create book
            getLibrary().getHandwrittenList().add(getBook());//add to specific list
        }else if(type.equals("P")){
            setBook(new Printed(getLibrary().getLibraryCollection().size()+1));
            getLibrary().getPrintedList().add(getBook());//add to specific list
        }
        getLibrary().getLibraryCollection().add(getBook());//add to general list
    }
    public void execute() {
        //execution time operations
        getLibrary().updateOutput("Created new book: "+getBook().info());
    }
}

