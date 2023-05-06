public class BorrowExceedError extends Exception{

    public BorrowExceedError(){
        super ("You have exceeded the borrowing limit!");//Custom Exception
    }
}
