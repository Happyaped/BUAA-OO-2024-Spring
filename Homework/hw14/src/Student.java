import com.oocourse.library2.LibraryBookId;

import java.time.LocalDate;
import java.util.HashMap;

public class Student {
    private HashMap<LibraryBookId, Integer> books;//一个学生拥有的书
    private HashMap<LibraryBookId, LocalDate> backDate;//代表了规定的归还时间，存的是逾期的日期

    public Student() {
        books = new HashMap<>();
        backDate = new HashMap<>();
    }

    public boolean canBorrowBBook() {
        int count = 0;
        for (LibraryBookId key : books.keySet()) {
            if (key.isTypeB()) {
                count += books.get(key);
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canBorrowBuBook() {
        int count = 0;
        for (LibraryBookId key : books.keySet()) {
            if (key.isTypeBU()) {
                count += books.get(key);
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canBorrowCBook(LibraryBookId bookId) {
        if (books.containsKey(bookId)) {
            if (books.get(bookId) == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public boolean canBorrowCuBook(LibraryBookId bookId) {
        if (books.containsKey(bookId)) {
            if (books.get(bookId) == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public void addBook(LibraryBookId bookId) {
        if (books.containsKey(bookId)) {
            Integer count = books.get(bookId) + 1;
            books.put(bookId, count);
        } else {
            books.put(bookId, 1);
        }
    }

    public void returnBook(LibraryBookId bookId) {
        Integer count = books.get(bookId) - 1;
        books.put(bookId, count);
    }

    public void addBackDate(LibraryBookId bookId, LocalDate today) {
        if (bookId.isFormal()) {
            //正常书
            if (bookId.isTypeB()) {
                backDate.put(bookId, today.plusDays(31));
            } else {
                backDate.put(bookId, today.plusDays(61));
            }
        } else {
            //漂流书
            if (bookId.isTypeBU()) {
                backDate.put(bookId, today.plusDays(8));
            } else {
                backDate.put(bookId, today.plusDays(15));
            }
        }
    }

    public LocalDate getBackDate(LibraryBookId bookId) {
        return backDate.get(bookId);
    }

    public void renewDate(LibraryBookId bookId) {
        LocalDate newDate = backDate.get(bookId).plusDays(30);
        backDate.put(bookId, newDate);
    }
}
