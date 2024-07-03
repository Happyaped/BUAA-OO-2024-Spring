import com.oocourse.library2.LibraryBookId;

import java.util.HashMap;

public class BorrowPlace {
    private HashMap<LibraryBookId, Integer> borrowTable;
    private HashMap<LibraryBookId, Integer> markBorrowCount;//代表了漂流处的书借的次数

    public BorrowPlace() {
        borrowTable = new HashMap<>();
        markBorrowCount = new HashMap<>();
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

    public void addBorrowCount(LibraryBookId bookId) {
        if (!bookId.isFormal()) {
            if (markBorrowCount.containsKey(bookId)) {
                int count = markBorrowCount.get(bookId) + 1;
                markBorrowCount.put(bookId, count);
            } else {
                markBorrowCount.put(bookId, 1);
            }
        }
    }

    public int getBorrowCount(LibraryBookId bookId) {
        if (!markBorrowCount.containsKey(bookId)) {
            return 0;
        } else {
            return markBorrowCount.get(bookId);
        }
    }
}
