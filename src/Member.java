import java.time.LocalDate;
import java.time.Period;

public abstract class Member {
    private final int id;
    private int borrowCount;
    protected int fee;

    public Member(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void increaseBorrowCount(){
        this.borrowCount += 1;
    }
    public void decreaseBorrowCount(){
        this.borrowCount -= 1;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee){
        this.fee=fee;
    }

    public boolean checkLimit(){
        if (this instanceof Academic && this.getBorrowCount() <4){
            return true;
        } else if (this instanceof Student && this.getBorrowCount() <2) {
            return true;
        }else{
            return false;
        }
    }

    public void returnBook(Book book, LocalDate returnTime) throws ReturnError {
        Borrowable borrowed =(Borrowable) book ;
        borrowed.Return(this,returnTime);
        if (borrowed.getReturnTime().isAfter(borrowed.getDeadline())){
            Period period = Period.between(borrowed.getDeadline(), borrowed.getReturnTime());
            setFee(Math.abs(period.getDays()));
            borrowed.resetTimes();
        }else{
            setFee(0);
        }


    }
    public void borrowBook(Book book,LocalDate borrowTime) throws BorrowingError, BorrowExceedError {
        Printed wantedBook =(Printed) book ;
        wantedBook.Borrow(this,borrowTime);
    }
    public abstract void readBook(Book book,LocalDate readTime) throws AccessError;
    public String info() {
        return this.getClass().getName()+String.format("[id:%s]",this.getId());
    }
}
