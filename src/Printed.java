import java.time.LocalDate;

public class Printed extends Book implements Borrowable{

    private String type ="Printed";
    private LocalDate borrowTime = null;

    private LocalDate Deadline = null;
    private LocalDate returnTime = null;

    private Member borrowingUser;


    public Printed(int id) {
        super(id);
    }



    public void setDeadline(LocalDate deadline) {
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

    public String info(){
        return this.type+ String.format("[id:%s]",super.getId() );
    }



    @Override
    public void Borrow(Member member, LocalDate date) throws BorrowingError {
        if (super.getStatus().equals("Available")){
        if ((member instanceof Academic && member.getBorrowCount() <4) ||
                (member instanceof Student && member.getBorrowCount() <2)) {
            this.setStatus("borrowed");
            this.borrowingUser = member;
            this.setDeadline(date);
            this.borrowingUser.increaseBorrowCount();
        } else {
            throw new BorrowingError();
        }
    }else{
            throw new BorrowingError();
        }
    }
    @Override
    public String borrowInfo(){
        return String.format("The Book [%s] was borrowed by member [%s] at %s",
                super.getId(),this.borrowingUser.getId(),this.borrowTime);
    }
    @Override
    public void Return(Member member,LocalDate date) throws ReturnError {
        if (this.getStatus().equals("borrowed")&&this.borrowingUser.equals(member)){
            this.setStatus("Available");
            this.returnTime=date;
            borrowingUser.decreaseBorrowCount();
            this.borrowingUser= null;
        }else {
            throw new ReturnError();
        }
    }
    public void resetTimes(){
        this.borrowTime =null;
        this.returnTime = null;
    }


}
