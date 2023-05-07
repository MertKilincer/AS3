import java.time.LocalDate;
import java.time.Period;

public class Printed extends Book implements Borrowable {


    private LocalDate deadline = null;//deadline of the borrowed book

    private boolean extendable = false;//boolean status of the book deadline can be extend if its only false

    public Printed(int id) {
        super(id);
    }

    @Override
    public String readInfo() {
        return String.format("The Book [%s] was read in library by member [%s] at %s",
                super.getId(), super.getBorrowingUser().getId(), getBorrowTime());
    }

    /**
     * SetDeadline of the book according to member type
     * @param date date of the borrow time or the current deadline
     */
    public void setDeadline(LocalDate date) {
        if (getBorrowingUser() instanceof Academic) {
            this.deadline = date.plusDays(Academic.timeLimit);
        } else {
            this.deadline = date.plusDays(Student.timeLimit);
        }
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public LocalDate getReturnTime() {
        return super.getReturnTime();
    }

    @Override
    public void resetTimes() {//reset time function set the times of the borrowTime and returnTime to null.
        super.resetTimes();
        setBorrowTime(null);
    }

    public boolean getExtendable() {
        return this.extendable;
    }

    public void setExtendable(boolean extendable) {
        //extend process is only allowed one time action so my implementation of the system holds as a boolean value
        this.extendable = extendable;
    }


    public String info() {
        return getClass().getName() + String.format("[id:%s]", getId());
    }

    @Override
    public void Borrow(Member member, LocalDate date) throws BorrowingError, BorrowExceedError {
        if (getStatus().equals("Available")) {
            if (member.checkLimit()) {
                setStatus("borrowed");
                setBorrowingUser(member);
                setDeadline(date);
                setBorrowTime(date);
                getBorrowingUser().increaseBorrowCount();//increase the user borrow count
            } else {
                throw new BorrowExceedError();
            }
        } else {
            throw new BorrowingError();
        }
    }

    @Override
    public String borrowInfo() {
        return String.format("The Book [%s] was borrowed by member [%s] at %s",
                getId(), getBorrowingUser().getId(), getBorrowTime());
    }

    @Override
    public void returnToLibrary(Member member, LocalDate date) throws ReturnError, TimeTravelError {
        if (!getStatus().equals("Available") && getBorrowingUser().equals(member)) {
            if (date.isBefore(this.getBorrowTime())) {
                throw new TimeTravelError();
            } else {
                setReturnTime(date);
                if (getStatus().equals("borrowed")) {
                    if (getReturnTime().isAfter(getDeadline())) {
                        //Time difference between deadline and return time
                        Period period = Period.between(getDeadline(), getReturnTime());
                        member.setFee(Math.abs(period.getDays()));
                        getBorrowingUser().decreaseBorrowCount();
                    }
                } else {
                    member.setFee(0);//you do not have to  pay any penalty
                    getBorrowingUser().decreaseBorrowCount();
                }
                setBorrowingUser(null);
            }
        } else {
            throw new ReturnError();
        }
    }


    public void extend(Library library) throws ExtendError {
        if (!getExtendable()) {
            library.updateOutput(String.format("The deadline of book [%s] was extended by member [%s] at %s"
                    , getId(), getBorrowingUser().getId(), getDeadline()));
            setDeadline(getDeadline());//extend deadline with this method calls
            setExtendable(true);
        } else {
            throw new ExtendError();
        }

    }

    public void readIn(LocalDate readDate) {
        if (getStatus().equals("Available")) {
            setStatus("Read In");
            setBorrowTime(readDate);
        }
    }


}
