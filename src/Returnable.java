import java.time.LocalDate;

public interface Returnable {//interface defined for return operations

    void Return(Member member, LocalDate date) throws ReturnError, TimeTravelError;

    Member getBorrowingUser();

    void setBorrowingUser(Member member);

    LocalDate getReturnTime();

}
