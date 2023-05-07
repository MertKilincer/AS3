import java.time.LocalDate;

public interface Returnable {//interface defined for return operations

    void returnToLibrary(Member member, LocalDate date) throws ReturnError, TimeTravelError;

    Member getBorrowingUser();

    void setBorrowingUser(Member member);

    LocalDate getReturnTime();

}
