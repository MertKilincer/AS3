import java.time.LocalDate;


public interface Borrowable {

    void Borrow(Member member,LocalDate date) throws BorrowingError, BorrowExceedError;

    String borrowInfo();

    LocalDate getReturnTime();

    LocalDate getDeadline();

    Member getBorrowingUser();

    void setDeadline(LocalDate deadline);

    void resetTimes();

    void Return(Member member,LocalDate date) throws ReturnError;

    void extend(Library library) throws ExtendError;
}
