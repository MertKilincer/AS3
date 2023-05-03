import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String [] inputs =ReadInputFile.readFile(args[0]);
        Library library = new Library();
        displayInput(inputs);
        for (String Line : inputs){
            String[] command=Line.split("\t");
            if(command[0].equals("addBook")){
                Command addBook = new AddBook(library,command[1]);
                addBook.execute(library);
            } else if (command[0].equals("addMember")) {
                Command addMember = new AddMember(library,command[1]);
                addMember.execute(library);
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
