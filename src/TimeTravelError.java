public class TimeTravelError extends Exception{

    TimeTravelError(){
        super("You cannot return the book when you did not borrowed this time!");
    }//custom Exception
}
