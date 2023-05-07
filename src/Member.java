import java.time.LocalDate;

public abstract class Member {
    private final int id;//member Id
    private int borrowCount;//borrow count of the members
    private int fee;//if member pays a fee it is stored here temporarily

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

    /**
     * Check member can have right to borrow books
     * @return true for they can still borrow books false for they can not have borrow books
     */
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
        book.returnToLibrary(this,returnTime);
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
