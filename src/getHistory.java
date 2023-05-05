

public class getHistory implements Command{

    private final Library library;

    public Library getLibrary() {
        return library;
    }

    public getHistory(Library library){
        this.library=library;
    }

    @Override
    public void execute() {
        this.getLibrary().updateOutput("History of library:\n"+
                "Number of the students: " +getLibrary().getStudentList().size());
        for (Member student: getLibrary().getStudentList()){
            getLibrary().updateOutput(student.info());
        }
        getLibrary().updateOutput("\nNumber of the academics: " +getLibrary().getAcademicList().size());
        for (Member academic:getLibrary().getAcademicList()){
            getLibrary().updateOutput(academic.info());
        }
        getLibrary().updateOutput("\nNumber of printed books: "+getLibrary().getPrintedList().size());
        for (Book printed:getLibrary().getPrintedList()){
            getLibrary().updateOutput(printed.info());
        }
        getLibrary().updateOutput(  "\nNumber of handwritten books: "+getLibrary().getHandwrittenList().size());
        for (Book handwritten:getLibrary().getHandwrittenList()){
            getLibrary().updateOutput(handwritten.info());
        }
        getLibrary().updateOutput("\nNumber of borrowed books: "+getLibrary().getBorrowedList().size());
        for (Book borrowed: getLibrary().getBorrowedList()){
            Borrowable book= (Borrowable) borrowed;
            getLibrary().updateOutput(book.borrowInfo());
        }
        getLibrary().updateOutput("\nNumber of books read in library: "+getLibrary().getReadInList().size());
        for (Book book: getLibrary().getReadInList()){
            getLibrary().updateOutput(book.readInfo());
        }
    }
}
