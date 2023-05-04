import java.time.LocalDate;

public class Printed extends Book implements Borrowable{

    private String type ="Printed";
    private LocalDate borrowTime = null;
    private LocalDate returnTime = null;

    private Member borrowingUser;


    public Printed(int id) {
        super(id);
    }

    public void setBorrowTime(LocalDate borrowTime) {
        this.borrowTime = borrowTime;
    }

    public LocalDate getBorrowTime() {
        return borrowTime;
    }

    public String info(){
        return this.type+ String.format("[id:%s]",super.getId() );
    }



    @Override
    public void Borrow(Member member, LocalDate date) throws BorrowingError {
        if ((member instanceof Academic && member.getBorrowCount() <= 4) ||
                (member instanceof Student && member.getBorrowCount() <= 2)) {
            this.setStatus("borrowed");
            this.setBorrowTime(date);
            this.borrowingUser = member;
            this.borrowingUser.increaseBorrowCount();
        } else {
            throw new BorrowingError();
        }
    }
    @Override
    public String borrowInfo(){
        return String.format("The Book [%s] was borrowed by member [%s] at %s",
                super.getId(),this.borrowingUser.getId(),this.borrowTime);
    }
    @Override
    public void Return(Member member,LocalDate date) {
        if (this.getStatus().equals("borrowed")){
            this.setStatus("Available");
            borrowingUser.decreaseBorrowCount();
            this.borrowingUser= null;
        }
    }
    public void resetTimes(){
        this.borrowTime =null;
        this.returnTime = null;
    }


}
