public class AddBook implements Command{
    private Book book;

    public AddBook(Library library,String type) {
        if (type.equals("H")){
            this.book=new Handwritten(library.getLibraryCollection().size()+1);
        }else if(type.equals("P")){
            this.book=new PrintedBooks(library.getLibraryCollection().size()+1);
        }
    }
    public void execute(Library library) {
        library.getLibraryCollection().add(book);
        library.updateOutput("Created new book: "+book.info());
    }
}

