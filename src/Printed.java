import java.time.LocalDate;

public class Printed extends Book implements Borrowable{

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
        return super.getReturnTime();
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
        return getClass().getName()+ String.format("[id:%s]",getId());
    }

    @Override
    public void Borrow(Member member, LocalDate date) throws BorrowingError, BorrowExceedError {
        if (getStatus().equals("Available")){
            if (member.checkLimit()){
            setStatus("borrowed");
            setBorrowingUser(member);
            setDeadline(date);
            getBorrowingUser().increaseBorrowCount();
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
                getId(),getBorrowingUser().getId(),getBorrowTime());
    }
    @Override
    public void Return(Member member,LocalDate date) throws ReturnError {
        if (getStatus().equals("borrowed")&& getBorrowingUser().equals(member)){
            setReturnTime(date);
            getBorrowingUser().decreaseBorrowCount();
            setBorrowingUser(null);
        }else {
            throw new ReturnError();
        }
    }
    public void resetTimes(){
        setReturnTime(null);
        setBorrowTime(null);
    }

    public void extend(Library library) throws ExtendError {
        if (!getExtendable()){
            library.updateOutput(String.format("The deadline of book [%s] was extended by member [%s] at %s"
                    ,getId(),getBorrowingUser().getId(),getDeadline()));
            setDeadline(getDeadline());
            setExtendable(true);
        }else {
            throw new ExtendError();
        }

    }
    public void readIn(LocalDate readDate){
        if (getStatus().equals("Available")){
            setStatus("Read In");
            setReturnTime(readDate);
        }
    }


}
