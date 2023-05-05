public class ReturnError extends Exception{

    public ReturnError(){
        super("You cannot return this book!");
    }
}
