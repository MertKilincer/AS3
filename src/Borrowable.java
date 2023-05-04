import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Borrowable {

    void Borrow(Member member,LocalDate date) throws BorrowingError;

    String borrowInfo();

    void Return(Member member,LocalDate date);
}
