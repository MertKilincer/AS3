import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        String [] inputs =ReadInputFile.readFile(args[0]);
        Library library = new Library();
        displayInput(inputs);
        for (String Line : inputs){
            String[] command=Line.split("\t");
            if(command[0].equals("addBook")){
                Command addBook = new AddBook(library,command[1]);
                addBook.execute();
            } else if (command[0].equals("addMember")) {
                Command addMember = new AddMember(library,command[1]);
                addMember.execute();
            } else if (command[0].equals("borrowBook")){
                Command borrowBook = new BorrowBook(library,command[1],command[2],command[3]);
                borrowBook.execute();
            } else if (command[0].equals("returnBook")) {
                Command returnBook = new ReturnBook(library,command[1],command[2],command[3]);
                returnBook.execute();
            } else if (command[0].equals("extendBook")) {

            }
        }

        try {
            FileWriter writer = new FileWriter(args[1]);
            writer.write(library.getSystemOutput());
            writer.close();
        }catch (IOException e){

        }
    }






















    public static void displayInput(String [] inputs){
        for (String i:inputs
        ) {
            System.out.println(i);
        }
    }
}
