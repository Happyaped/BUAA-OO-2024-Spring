import com.oocourse.library1.LibraryBookId;

import java.util.HashMap;

public class Student {
    private HashMap<LibraryBookId, Integer> books;//一个学生拥有的书

    public Student() {
        books = new HashMap<>();
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
}
