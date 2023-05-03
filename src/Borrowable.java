import java.time.LocalDateTime;

public interface Borrowable {
    
    LocalDateTime borrowTime = null;
    LocalDateTime returnTime = null;

    void Borrow(Library library,int id);
}
