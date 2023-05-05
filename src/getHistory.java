

public class getHistory implements Command{

    private Library library;


    public getHistory(Library library){
        this.library=library;
    }

    @Override
    public void execute() {
        library.updateOutput("History of library:\n"+
                "Number of the students: " +library.getStudentList().size());
        for (Member student: library.getStudentList()){
            library.updateOutput(student.info());
        }
        library.updateOutput("\nNumber of the academics: " +library.getAcademicList().size());
        for (Member academic:library.getAcademicList()){
            library.updateOutput(academic.info());
        }
        library.updateOutput("\nNumber of printed books: "+library.getPrintedList().size());
        for (Book printed:library.getPrintedList()){
            library.updateOutput(printed.info());
        }
        library.updateOutput(  "\nNumber of handwritten books: "+library.getHandwrittenList().size());
        for (Book handwritten:library.getHandwrittenList()){
            library.updateOutput(handwritten.info());
        }
        library.updateOutput("\nNumber of borrowed books: "+library.getBorrowedList().size());
        for (Book borrowed: library.getBorrowedList()){
            Borrowable book= (Borrowable) borrowed;
            library.updateOutput(book.borrowInfo());
        }
        library.updateOutput("\nNumber of books read in library: "+library.getReadInList().size());
        for (Book book: library.getReadInList()){
            library.updateOutput(book.readInfo());
        }
    }
}
