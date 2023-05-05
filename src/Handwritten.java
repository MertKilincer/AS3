import java.time.LocalDate;

public class Handwritten extends Book{

    private LocalDate returnTime = null;

    public Handwritten(int id) {
        super(id);
    }

    public void readIn(LocalDate readDate){
        if (this.getStatus().equals("Available")){
            this.setStatus("Read In");
            this.returnTime=readDate;
        }
    }
    public String info(){
        return this.getClass().getName()+ String.format("[id:%s]",super.getId() );
    }
}
