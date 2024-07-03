import com.oocourse.library2.LibraryBookId;

import java.time.LocalDate;

public class Request {
    private LocalDate date;
    private String studentId;
    private LibraryBookId bookId;

    public Request(LocalDate date, String studentId, LibraryBookId bookId) {
        this.date = date;
        this.studentId = studentId;
        this.bookId = bookId;
    }

    public String getStudentId() {
        return studentId;
    }

    public LibraryBookId getBookId() {
        return bookId;
    }

    public LocalDate getDate() {
        return date;
    }
}
