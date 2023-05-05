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
            this.setBook(new Handwritten(library.getLibraryCollection().size()+1));
            library.getHandwrittenList().add(this.getBook());
        }else if(type.equals("P")){
            this.setBook(new Printed(library.getLibraryCollection().size()+1));
            library.getPrintedList().add(this.getBook());
        }
    }
    public void execute() {
        this.getLibrary().getLibraryCollection().add(this.getBook());
        this.getLibrary().updateOutput("Created new book: "+this.getBook().info());
    }
}

