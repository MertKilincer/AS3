import java.time.LocalDate;

public abstract class Book {
    private int id;
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

    public abstract String readInfo();




    public abstract String info();

    public abstract void readIn(LocalDate readDate);
}
