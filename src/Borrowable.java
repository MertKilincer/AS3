import java.time.LocalDate;


public interface Borrowable {//borrowable interface for books that can be taken out from the library

    void Borrow(Member member,LocalDate date) throws BorrowingError, BorrowExceedError;//

    String borrowInfo();//borrow ınfo interface that about borrowing state info

    LocalDate getDeadline();

    void setDeadline(LocalDate deadline);//set deadline to according to member type


    void extend(Library library) throws ExtendError;//methods extend the book borrowing deadline
}
