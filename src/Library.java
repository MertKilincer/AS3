import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Library class is a container like class that holds books members in different type of array lists.
 */
public class Library {

    private LinkedList<Book> libraryCollection = new LinkedList<Book>();
    private LinkedList<Member>members=new LinkedList<Member>();
    private ArrayList<String> systemOutput =new ArrayList<>();

    private ArrayList<Book> PrintedList =new ArrayList<Book>();
    private ArrayList<Book> HandwrittenList =new ArrayList<Book>();
    private ArrayList<Member> StudentList =new ArrayList<Member>();
    private ArrayList<Member> AcademicList =new ArrayList<Member>();
    private ArrayList<Book> borrowedList =new ArrayList<Book>();
    private ArrayList<Book> readInList = new ArrayList<Book>();

    /**
     * This getter returns
     * @return
     */
    public LinkedList<Book> getLibraryCollection() {
        return libraryCollection;
    }
    public LinkedList<Member> getMembers(){
        return members;
    }

    public String getSystemOutput() {
        return String.join("\n",systemOutput);
    }
    public void updateOutput(String newExecution){
        systemOutput.add(newExecution);
    }

    public ArrayList<Book> getPrintedList() {
        return PrintedList;
    }

    public ArrayList<Book> getHandwrittenList() {
        return HandwrittenList;
    }

    public ArrayList<Member> getStudentList() {
        return StudentList;
    }

    public ArrayList<Member> getAcademicList() {
        return AcademicList;
    }

    public ArrayList<Book> getBorrowedList() {
        return borrowedList;
    }

    public ArrayList<Book> getReadInList() {
        return readInList;
    }
}

