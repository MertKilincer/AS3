import java.time.LocalDate;


public interface Borrowable {

    void Borrow(Member member,LocalDate date) throws BorrowingError, BorrowExceedError;

    String borrowInfo();

    LocalDate getDeadline();

    void setDeadline(LocalDate deadline);


    void extend(Library library) throws ExtendError;
}
