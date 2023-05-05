import java.time.LocalDate;

public class Printed extends Book implements Borrowable{

    private String type ="Printed";
    private LocalDate borrowTime = null;
    private LocalDate Deadline = null;
    private Member borrowingUser;

    private boolean extendable = false;

    public Printed(int id) {
        super(id);
    }

    @Override
    public String readInfo() {
            return String.format("The Book [%s] was read in library by member [%s] at %s",
                    super.getId(),super.reader.getId(),super.returnTime);
    }

    public void setDeadline(LocalDate deadline) {
        this.borrowTime=deadline;
        if (borrowingUser instanceof Academic){
            this.Deadline=deadline.plusDays(Academic.timeLimit);
        }else{
            this.Deadline=deadline.plusDays(Student.timeLimit);
        }
    }

    public LocalDate getDeadline() {
        return Deadline;
    }
    public LocalDate getReturnTime() {
        return returnTime;
    }

    public LocalDate getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(LocalDate borrowTime) {
        this.borrowTime = borrowTime;
    }

    public boolean getExtendable(){
        return this.extendable;
    }
    public void setExtendable(boolean extendable) {
        this.extendable = extendable;
    }
    public void setBorrowingUser(Member borrowingUser) {
        this.borrowingUser = borrowingUser;
    }
    public Member getBorrowingUser() {
        return borrowingUser;
    }



    public String info(){
        return this.getClass().getName()+ String.format("[id:%s]",super.getId() );
    }

    @Override
    public void Borrow(Member member, LocalDate date) throws BorrowingError, BorrowExceedError {
        if (super.getStatus().equals("Available")){
            if (member.checkLimit()){
            this.setStatus("borrowed");
            this.setBorrowingUser(member);
            this.setDeadline(date);
            this.getBorrowingUser().increaseBorrowCount();
        } else {
            throw new BorrowExceedError();
        }
    }else{
            throw new BorrowingError();
        }
    }
    @Override
    public String borrowInfo(){
        return String.format("The Book [%s] was borrowed by member [%s] at %s",
                super.getId(),this.getBorrowingUser().getId(),this.getBorrowTime());
    }
    @Override
    public void Return(Member member,LocalDate date) throws ReturnError {
        if (this.getStatus().equals("borrowed")&&this.getBorrowingUser().equals(member)){
            super.setReturnTime(date);
            this.getBorrowingUser().decreaseBorrowCount();
            this.setBorrowingUser(null);
        }else {
            throw new ReturnError();
        }
    }
    public void resetTimes(){
        this.setReturnTime(null);
        this.setBorrowTime(null);
    }

    public void extend(Library library) throws ExtendError {
        if (!this.getExtendable()){
            library.updateOutput(String.format("The deadline of book [%s] was extended by member [%s] at %s"
                    ,super.getId(),this.getBorrowingUser().getId(),this.getDeadline()));
            this.setDeadline(this.getDeadline());
            this.setExtendable(true);
        }else {
            throw new ExtendError();
        }

    }
    public void readIn(LocalDate readDate){
        if (this.getStatus().equals("Available")){
            this.setStatus("Read In");
            this.setReturnTime(readDate);
        }
    }


}
