import java.time.LocalDate;


public interface Borrowable {

    void Borrow(Member member,LocalDate date) throws BorrowingError;

    String borrowInfo();

    LocalDate getReturnTime();

    LocalDate getDeadline();

    void setDeadline(LocalDate deadline);

    void resetTimes();

    void Return(Member member,LocalDate date) throws ReturnError;
}
