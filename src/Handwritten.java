import java.time.LocalDate;

public class Handwritten extends Book {
    /**
     * Handwritten book is a class that a subclass of the book and this type of the book
     * @param id id of the book
     */
    public Handwritten(int id) {
        super(id);
    }

    @Override
    public String readInfo() {
        return String.format("The Book [%s] was read in library by member [%s] at %s",
                getId(),getBorrowingUser().getId(),getBorrowTime());
    }

    public void readIn(LocalDate readDate){
        if (getStatus().equals("Available")){
            setStatus("Read In");
            setBorrowTime(readDate);
        }
    }
    public String info(){
        return getClass().getName()+ String.format("[id:%s]",getId() );
    }

    /**
     * Return function implementation for handwritten books do not work
     * with the borrowing actions like borrow or extend so it is more simple
     * @param member member that holds to book
     * @param date return time of the book
     * @throws ReturnError
     */
    @Override
    public void returnToLibrary(Member member, LocalDate date) throws ReturnError {
        if (getStatus().equals("Read In")&& getBorrowingUser().equals(member)){
            setReturnTime(date);
            setBorrowingUser(null);
        }else {
            throw new ReturnError();
        }
    }
}

