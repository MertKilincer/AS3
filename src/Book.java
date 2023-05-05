import java.time.LocalDate;

public abstract class Book {
    private final int id;
    private String status="Available";

    protected Member reader;
    protected LocalDate returnTime = null;

    public Book(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }

    public Member getReader() {
        return reader;
    }

    public void setReader(Member reader) {
        this.reader = reader;
    }

    public LocalDate getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDate returnTime) {
        this.returnTime = returnTime;
    }

    public abstract String readInfo();

    public abstract String info();

    public abstract void readIn(LocalDate readDate);
}
