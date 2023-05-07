import java.time.LocalDate;

public abstract class Book implements  Returnable{
    private final int id;//book's Id
    private String status="Available";//book status and every book have initial status as Available

    private LocalDate borrowTime = null;//borrow time of the book for borrowing and read in the library operations
    private Member borrowingUser;//borrowing user for library operations
    private LocalDate returnTime = null;//time that the book returned

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
