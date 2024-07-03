import com.oocourse.library1.LibraryBookId;

import java.util.HashMap;

public class BorrowPlace {
    private HashMap<LibraryBookId, Integer> borrowTable;

    public BorrowPlace() {
        borrowTable = new HashMap<>();
    }

    public void addBook(LibraryBookId bookId) {
        if (borrowTable.containsKey(bookId)) {
            Integer count = borrowTable.get(bookId) + 1;
            borrowTable.put(bookId, count);
        } else {
            borrowTable.put(bookId, 1);
        }
    }

    public HashMap<LibraryBookId, Integer> getBorrowTable() {
        return borrowTable;
    }

    public void finishTran() {
        borrowTable.clear();
    }
}
