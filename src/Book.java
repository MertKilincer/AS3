import java.time.LocalDate;

public abstract class Book implements  Returnable{
    private final int id;
    private String status="Available";



    private LocalDate borrowTime = null;
    private Member borrowingUser;
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

    @Override
    public Member getBorrowingUser() {
        return borrowingUser;
    }

    @Override
    public void setBorrowingUser(Member borrowingUser) {
        this.borrowingUser = borrowingUser;
    }
    public LocalDate getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(LocalDate borrowTime) {
        this.borrowTime = borrowTime;
    }
    public LocalDate getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDate returnTime) {
        this.returnTime = returnTime;
    }

    public void resetTimes(){
        setReturnTime(null);
    }

    public abstract String readInfo();

    public abstract String info();

    public abstract void readIn(LocalDate readDate);
}
