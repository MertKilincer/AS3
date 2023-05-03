public class PrintedBooks extends Book{

    private String type ="Printed";

    public PrintedBooks(int id) {
        super(id);
    }
    public String info(){
        return this.type+ String.format("[id:%s]",super.getId() );
    }
}
