public class ErroneousCommand implements Command{

    private final Library library;

    ErroneousCommand(Library library){
        this.library=library;
    }

    public Library getLibrary() {
        return library;
    }

    @Override
    public void execute() {
        getLibrary().updateOutput("Incorrect Command!");
    }
}
