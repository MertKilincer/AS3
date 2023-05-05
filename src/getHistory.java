import java.util.ArrayList;

public class getHistory implements Command{

    private Library library;

    private ArrayList<Book> PrintedList =new ArrayList<Book>();
    private ArrayList<Book> HandwrittenList =new ArrayList<Book>();
    private ArrayList<Member> StudentList =new ArrayList<Member>();
    private ArrayList<Member> AcademicList =new ArrayList<Member>();
    private ArrayList<Book> borrowedList =new ArrayList<Book>();
    private ArrayList<Book> readInList = new ArrayList<Book>();

    public getHistory(Library library){
        this.library=library;
    }

    @Override
    public void execute() {

    }
}
