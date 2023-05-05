import java.time.LocalDate;

public class Handwritten extends Book{

    private LocalDate returnTime = null;

    public Handwritten(int id) {
        super(id);
    }

    @Override
    public String readInfo() {
        return String.format("The Book [%s] was read in library by member [%s] at %s",
                super.getId(),super.reader.getId(),super.returnTime);
    }

    public void readIn(LocalDate readDate){
        if (this.getStatus().equals("Available")){
            this.setStatus("Read In");
            super.returnTime=readDate;
        }
    }
    public String info(){
        return this.getClass().getName()+ String.format("[id:%s]",super.getId() );
    }
}
