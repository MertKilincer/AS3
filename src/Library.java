import java.util.ArrayList;
import java.util.LinkedList;

public class Library {

    private LinkedList<Book> libraryCollection = new LinkedList<Book>();
    private LinkedList<Member>members=new LinkedList<Member>();
    private ArrayList<String> systemOutput =new ArrayList<>();

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
        this.systemOutput.add(newExecution);
    }
}

