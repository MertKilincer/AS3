import java.time.LocalDate;

public class Handwritten extends Book {

    public Handwritten(int id) {
        super(id);
    }

    @Override
    public String readInfo() {
        return String.format("The Book [%s] was read in library by member [%s] at %s",
                super.getId(),super.getBorrowingUser().getId(),getBorrowTime());
    }

    public void readIn(LocalDate readDate){
        if (getStatus().equals("Available")){
            setStatus("Read In");
            setBorrowTime(readDate);
        }
    }
    public String info(){
        return this.getClass().getName()+ String.format("[id:%s]",super.getId() );
    }

    @Override
    public void Return(Member member, LocalDate date) throws ReturnError {
        if (getStatus().equals("Read In")&& getBorrowingUser().equals(member)){
            setReturnTime(date);
            setBorrowingUser(null);
        }else {
            throw new ReturnError();
        }
    }
}

