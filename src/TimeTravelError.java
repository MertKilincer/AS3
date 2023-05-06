public class TimeTravelError extends Exception{

    TimeTravelError(){
        super("You cannot return the book when you have not borrowed yet!");
    }//custom Exception
}
