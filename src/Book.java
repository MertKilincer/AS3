public abstract class Book {
    private int id;
    private String status="Available";

    public Book(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }

    public abstract String info();
}
