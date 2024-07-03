import com.oocourse.library1.LibraryBookId;
import com.oocourse.library1.LibraryMoveInfo;

import static com.oocourse.library1.LibrarySystem.PRINTER;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    private HashMap<LibraryBookId, Integer> bookShelf;//代表了书架，key是id，value是数量
    private HashMap<String, Student> studentTable;//代表了在学生手里的书，key是学号，value是每个学生手里的书
    private BorrowPlace borrowPlace;//代表了借还处
    private OrderPlace orderPlace;//代表了预约处

    public Library() {
        bookShelf = new HashMap<>();
        studentTable = new HashMap<>();
        borrowPlace = new BorrowPlace();
        orderPlace = new OrderPlace();
    }

    public void addInitBookShelf(LibraryBookId libraryBookId, Integer count) {
        bookShelf.put(libraryBookId, count);
    }

    public int handleQuery(LibraryBookId bookId) {
        return bookShelf.get(bookId);
    }

    public int handleBorrow(String studentId, LibraryBookId bookId) {
        Student temStudent = getStudent(studentId);
        if (bookShelf.get(bookId) == 0) {
            return 0;
        }
        if (bookId.isTypeB()) {
            //如果是借B类书
            if (temStudent.canBorrowBBook()) {
                deleteBookShelf(bookId);
                temStudent.addBook(bookId);
                return 1;
            } else {
                deleteBookShelf(bookId);
                borrowPlace.addBook(bookId);
                return 0;
            }
        } else {
            //如果是借C类书
            if (temStudent.canBorrowCBook(bookId)) {
                deleteBookShelf(bookId);
                temStudent.addBook(bookId);
                return 1;
            } else {
                deleteBookShelf(bookId);
                borrowPlace.addBook(bookId);
                return 0;
            }
        }
    }

    public int handleOrder(String studentId, LibraryBookId bookId, LocalDate today) {
        Student temStudent = getStudent(studentId);
        if (bookId.isTypeB()) {
            //如果是预约B类书
            if (temStudent.canBorrowBBook()) {
                orderPlace.addToBeOrderList(studentId, today, bookId);
                return 1;
            } else {
                return 0;
            }
        } else {
            //如果是预约C类书
            if (temStudent.canBorrowCBook(bookId)) {
                orderPlace.addToBeOrderList(studentId, today, bookId);
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int handlePick(String studentId, LibraryBookId bookId) {
        Student temStudent = getStudent(studentId);
        if (bookId.isTypeB()) {
            //如果要取B类书
            if (temStudent.canBorrowBBook() && orderPlace.checkHasReserved(studentId, bookId)) {
                orderPlace.pickBook(studentId, bookId);
                temStudent.addBook(bookId);
                return 1;
            } else {
                return 0;
            }
        } else {
            //如果要取C类书
            if (temStudent.canBorrowCBook(bookId) &&
                    orderPlace.checkHasReserved(studentId, bookId)) {
                orderPlace.pickBook(studentId, bookId);
                temStudent.addBook(bookId);
                return 1;
            } else {
                return 0;
            }
        }
    }

    public void handleReturn(String studentId, LibraryBookId bookId) {
        Student temStudent = getStudent(studentId);
        temStudent.returnBook(bookId);
        borrowPlace.addBook(bookId);
    }

    public void handleOpen(LocalDate today) {
        List<LibraryMoveInfo> moveList = new ArrayList<>();
        moveOrderPlace2BooKShelf(today, moveList);
        moveBorrowPlace2BookShelf(moveList);
        moveBookShelf2OrderPlace(today, moveList);
        PRINTER.move(today, moveList);
    }

    public void handleClose(LocalDate today) {
        List<LibraryMoveInfo> moveList = new ArrayList<>();
        moveOrderPlace2BooKShelf(today, moveList);
        moveBorrowPlace2BookShelf(moveList);
        PRINTER.move(today, moveList);
    }

    public void moveOrderPlace2BooKShelf(LocalDate today, List<LibraryMoveInfo> moveList) {
        ArrayList<Request> tem = orderPlace.toBooKShelf(today);
        for (int i = 0; i < tem.size(); i++) {
            Request request = tem.get(i);
            addBookShelf(request.getBookId());
            LibraryMoveInfo tem1 = new LibraryMoveInfo(request.getBookId(), "ao", "bs");
            moveList.add(tem1);
        }
    }

    public void moveBorrowPlace2BookShelf(List<LibraryMoveInfo> moveList) {
        HashMap<LibraryBookId, Integer> tem = borrowPlace.getBorrowTable();
        for (LibraryBookId key : tem.keySet()) {
            int count = tem.get(key);
            for (int i = 0; i < count; i++) {
                addBookShelf(key);
                LibraryMoveInfo tem1 = new LibraryMoveInfo(key, "bro", "bs");
                moveList.add(tem1);
            }
        }
        borrowPlace.finishTran();
    }

    public void moveBookShelf2OrderPlace(LocalDate today, List<LibraryMoveInfo> moveList) {
        ArrayList<Request> tem = orderPlace.getToBeOrderList();
        for (int i = 0; i < tem.size(); i++) {
            Request request = tem.get(i);
            String studentId = request.getStudentId();
            LibraryBookId bookId = request.getBookId();
            if (bookShelf.get(bookId) > 0) {
                deleteBookShelf(bookId);
                orderPlace.addOrderList(today, studentId, bookId);
                LibraryMoveInfo tem1 = new LibraryMoveInfo(bookId, "bs", "ao", studentId);
                moveList.add(tem1);
            }
        }
        orderPlace.finishTran();
    }

    public void deleteBookShelf(LibraryBookId bookId) {
        Integer count = bookShelf.get(bookId) - 1;
        bookShelf.put(bookId, count);
    }

    public void addBookShelf(LibraryBookId bookId) {
        Integer count = bookShelf.get(bookId) + 1;
        bookShelf.put(bookId, count);
    }

    public Student getStudent(String studentId) {
        if (studentTable.containsKey(studentId)) {
            return studentTable.get(studentId);
        } else {
            Student student = new Student();
            studentTable.put(studentId, student);
            return student;
        }
    }
}
