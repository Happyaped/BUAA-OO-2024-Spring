import com.oocourse.library3.LibraryBookId;

import java.time.LocalDate;
import java.util.HashMap;

public class Student {
    private HashMap<LibraryBookId, Integer> books;//一个学生拥有的书
    private HashMap<LibraryBookId, LocalDate> backDate;//代表了规定的归还时间，存的是逾期的日期
    private int creditScore;//代表了用户的信用分
    private HashMap<LibraryBookId, Boolean> markCreditScore;//代表是否因为这本书被扣过分

    public Student() {
        books = new HashMap<>();
        backDate = new HashMap<>();
        creditScore = 10;
        markCreditScore = new HashMap<>();
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
        markCreditScore.put(bookId, false);
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

    public int getCreditScore() {
        return creditScore;
    }

    public void addCreditScore(int num) {
        int temScore = num + creditScore;
        if (temScore > 20) {
            creditScore = 20;
        } else {
            creditScore = temScore;
        }
    }

    public HashMap<LibraryBookId, Boolean> getMarkCreditScore() {
        return markCreditScore;
    }

    public HashMap<LibraryBookId, Integer> getBooks() {
        return books;
    }
}
