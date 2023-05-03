public abstract class Book {
    private int id;
    public Book(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public abstract String info();
}
