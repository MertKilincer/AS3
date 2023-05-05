import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        String [] inputs =ReadInputFile.readFile(args[0]);
        Library library = new Library();
        //displayInput(inputs);
        for (String Line : inputs){
            String[] command=Line.split("\t");
            switch (command[0]) {
                case "addBook":
                    Command addBook = new AddBook(library, command[1]);
                    addBook.execute();
                    break;
                case "addMember":
                    Command addMember = new AddMember(library, command[1]);
                    addMember.execute();
                    break;
                case "borrowBook":
                    Command borrowBook = new BorrowBook(library, command[1], command[2], command[3]);
                    borrowBook.execute();
                    break;
                case "returnBook":
                    Command returnBook = new ReturnBook(library, command[1], command[2], command[3]);
                    returnBook.execute();
                    break;
                case "extendBook":
                    Command extend = new ExtendBook(library, command[1], command[2], command[3]);
                    extend.execute();
                    break;
                case "readInLibrary":
                    Command readIn = new ReadInLibrary(library, command[1], command[2], command[3]);
                    readIn.execute();
                    break;
                case "getTheHistory":
                    Command history = new getHistory(library);
                    history.execute();
                    break;
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
