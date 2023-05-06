import java.time.LocalDate;
import java.time.Period;

public class Printed extends Book implements Borrowable{


    private LocalDate Deadline = null;

    private boolean extendable = false;

    public Printed(int id) {
        super(id);
    }

    @Override
    public String readInfo() {
            return String.format("The Book [%s] was read in library by member [%s] at %s",
                    super.getId(),super.getBorrowingUser().getId(),getBorrowTime());
    }

    public void setDeadline(LocalDate deadline) {
        if (getBorrowingUser() instanceof Academic){
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

    @Override
    public void resetTimes(){
        super.resetTimes();
        setBorrowTime(null);
    }

    public boolean getExtendable(){
        return this.extendable;
    }
    public void setExtendable(boolean extendable) {
        this.extendable = extendable;
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
                setBorrowTime(date);
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
    public void Return(Member member,LocalDate date) throws ReturnError, TimeTravelError {
        if (!getStatus().equals("Available")  && getBorrowingUser().equals(member)){
            if (date.isBefore(this.getBorrowTime())){
                throw new TimeTravelError();
            }else {
                setReturnTime(date);
            if (getStatus().equals("borrowed"))   {
            if (getReturnTime().isAfter(getDeadline())) {
                Period period = Period.between(getDeadline(), getReturnTime());
                member.setFee(Math.abs(period.getDays()));
                getBorrowingUser().decreaseBorrowCount();
            }
            } else {
                member.setFee(0);
                getBorrowingUser().decreaseBorrowCount();
            }
            setBorrowingUser(null);
        }
        }else {
            throw new ReturnError();
        }
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
            setBorrowTime(readDate);
        }
    }


}
