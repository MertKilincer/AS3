public class AddBook implements Command{
    private Book book;
    private final Library library;

    public AddBook(Library library,String type) {
        this.library=library;
        if (type.equals("H")){
            this.book=new Handwritten(library.getLibraryCollection().size()+1);
        }else if(type.equals("P")){
            this.book=new Printed(library.getLibraryCollection().size()+1);
        }
    }
    public void execute() {
        library.getLibraryCollection().add(book);
        library.updateOutput("Created new book: "+book.info());
    }
}

