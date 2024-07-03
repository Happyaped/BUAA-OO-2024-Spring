import com.oocourse.library2.LibraryBookId;

import java.util.HashMap;

public class Corner {
    private HashMap<LibraryBookId, Integer> cornerShelf;//代表了漂流角的书架

    public Corner() {
        cornerShelf = new HashMap<>();
    }

    public void addCornerBooK(LibraryBookId bookId) {
        if (cornerShelf.containsKey(bookId)) {
            int tem = cornerShelf.get(bookId) + 1;
            cornerShelf.put(bookId, tem);
        } else {
            cornerShelf.put(bookId, 1);
        }
    }

    public int getCornerBookCount(LibraryBookId bookId) {
        return cornerShelf.get(bookId);
    }

    public void deleteCornerBook(LibraryBookId bookId) {
        Integer count = cornerShelf.get(bookId) - 1;
        cornerShelf.put(bookId, count);
    }
}
