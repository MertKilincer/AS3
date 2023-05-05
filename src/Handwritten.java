import java.time.LocalDate;

public class Handwritten extends Book{

    public Handwritten(int id) {
        super(id);
    }

    @Override
    public String readInfo() {
        return String.format("The Book [%s] was read in library by member [%s] at %s",
                super.getId(),super.getReader().getId(),super.getReturnTime());
    }

    public void readIn(LocalDate readDate){
        if (this.getStatus().equals("Available")){
            this.setStatus("Read In");
            super.setReturnTime(readDate);
        }
    }
    public String info(){
        return this.getClass().getName()+ String.format("[id:%s]",super.getId() );
    }
}
