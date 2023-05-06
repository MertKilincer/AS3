import java.time.LocalDate;

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

    public void returnBook(Book book, LocalDate returnTime) throws ReturnError, TimeTravelError {
        book.Return(this,returnTime);
        book.resetTimes();
    }


    public void borrowBook(Book book, LocalDate borrowTime) throws BorrowingError, BorrowExceedError {
        Printed wantedBook =(Printed) book ;
        wantedBook.Borrow(this,borrowTime);
    }
    public abstract void readBook(Book book, LocalDate readTime) throws AccessError;

    public String info() {
        return this.getClass().getName()+String.format("[id:%s]",this.getId());
    }
}
