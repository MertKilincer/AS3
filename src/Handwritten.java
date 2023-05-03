public class Handwritten extends Book{


    public Handwritten(int id) {
        super(id);
    }

    public String info(){
        return this.getClass().getName()+ String.format("[id:%s]",super.getId() );
    }
}
