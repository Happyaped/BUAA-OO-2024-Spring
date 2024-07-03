import com.oocourse.library2.LibraryBookId;
import com.oocourse.library2.LibraryMoveInfo;
import com.oocourse.library2.annotation.Trigger;

import static com.oocourse.library2.LibrarySystem.PRINTER;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    private HashMap<LibraryBookId, Integer> bookShelf;//代表了书架，key是id，value是数量
    private HashMap<String, Student> studentTable;//代表了在学生手里的书，key是学号，value是每个学生手里的书
    private BorrowPlace borrowPlace;//代表了借还处
    private OrderPlace orderPlace;//代表了预约处
    private Corner cornerPlace;//代表了漂流角

    public Library() {
        bookShelf = new HashMap<>();
        studentTable = new HashMap<>();
        borrowPlace = new BorrowPlace();
        orderPlace = new OrderPlace();
        cornerPlace = new Corner();
    }

    public void addInitBookShelf(LibraryBookId libraryBookId, Integer count) {
        bookShelf.put(libraryBookId, count);
    }

    public int handleQuery(LibraryBookId bookId) {
        if (bookId.isFormal()) {
            return bookShelf.get(bookId);
        } else {
            return cornerPlace.getCornerBookCount(bookId);
        }
    }

    @Trigger(from = "InitState", to = "FinalState")
    public int handleBorrow(String studentId, LibraryBookId bookId, LocalDate today) {
        Student temStudent = getStudent(studentId);
        if (bookShelf.get(bookId) == 0) {
            return 0;
        }
        if (bookId.isTypeB()) {
            //如果是借B类书
            if (temStudent.canBorrowBBook()) {
                deleteBookShelf(bookId);
                temStudent.addBook(bookId);
                temStudent.addBackDate(bookId, today);
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
                temStudent.addBackDate(bookId, today);
                return 1;
            } else {
                deleteBookShelf(bookId);
                borrowPlace.addBook(bookId);
                return 0;
            }
        }
    }

    public int handleCornerBorrow(String studentId, LibraryBookId bookId, LocalDate today) {
        Student temStudent = getStudent(studentId);
        if (cornerPlace.getCornerBookCount(bookId) == 0) {
            return 0;
        }
        if (bookId.isTypeBU()) {
            //如果是借BU类书
            if (temStudent.canBorrowBuBook()) {
                cornerPlace.deleteCornerBook(bookId);
                temStudent.addBook(bookId);
                temStudent.addBackDate(bookId, today);
                return 1;
            } else {
                cornerPlace.deleteCornerBook(bookId);
                borrowPlace.addBook(bookId);
                return 0;
            }
        } else {
            //如果是借CU类书
            if (temStudent.canBorrowCuBook(bookId)) {
                cornerPlace.deleteCornerBook(bookId);
                temStudent.addBook(bookId);
                temStudent.addBackDate(bookId, today);
                return 1;
            } else {
                cornerPlace.deleteCornerBook(bookId);
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

    public int handlePick(String studentId, LibraryBookId bookId, LocalDate today) {
        Student temStudent = getStudent(studentId);
        if (bookId.isTypeB()) {
            //如果要取B类书
            if (temStudent.canBorrowBBook() && orderPlace.checkHasReserved(studentId, bookId)) {
                orderPlace.pickBook(studentId, bookId);
                temStudent.addBook(bookId);
                temStudent.addBackDate(bookId, today);
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
                temStudent.addBackDate(bookId, today);
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int handleReturn(String studentId, LibraryBookId bookId, LocalDate today) {
        Student temStudent = getStudent(studentId);
        temStudent.returnBook(bookId);
        LocalDate backDate = temStudent.getBackDate(bookId);
        borrowPlace.addBook(bookId);
        borrowPlace.addBorrowCount(bookId);
        if (today.compareTo(backDate) >= 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int handleRenew(String studentId, LibraryBookId bookId, LocalDate today) {
        Student temStudent = getStudent(studentId);
        LocalDate backDate = temStudent.getBackDate(bookId);
        if (today.isAfter(backDate.minusDays(6)) && today.isBefore(backDate)) {
            if (bookId.isFormal()) {
                if (bookShelf.get(bookId) == 0 && !orderPlace.checkCanRenew(bookId)) {
                    //续借失败
                    return 0;
                } else {
                    //续借成功
                    temStudent.renewDate(bookId);
                    return 1;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public void handleDonate(LibraryBookId bookId) {
        cornerPlace.addCornerBooK(bookId);
    }

    public void handleOpen(LocalDate today) {
        List<LibraryMoveInfo> moveList = new ArrayList<>();
        moveOrderPlace2BooKShelf(today, moveList);
        moveBorrowPlace2BookShelfAndCorner(moveList);
        moveBookShelf2OrderPlace(today, moveList);
        PRINTER.move(today, moveList);
    }

    public void handleClose(LocalDate today) {
        List<LibraryMoveInfo> moveList = new ArrayList<>();
        moveOrderPlace2BooKShelf(today, moveList);
        moveBorrowPlace2BookShelfAndCorner(moveList);
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

    public void moveBorrowPlace2BookShelfAndCorner(List<LibraryMoveInfo> moveList) {
        HashMap<LibraryBookId, Integer> tem = borrowPlace.getBorrowTable();
        for (LibraryBookId key : tem.keySet()) {
            if (key.isFormal()) {
                int count = tem.get(key);
                for (int i = 0; i < count; i++) {
                    addBookShelf(key);
                    LibraryMoveInfo tem1 = new LibraryMoveInfo(key, "bro", "bs");
                    moveList.add(tem1);
                }
            } else {
                int returnCount = borrowPlace.getBorrowCount(key);
                int count = tem.get(key);
                if (returnCount >= 2) {
                    //升级了
                    for (int i = 0; i < count; i++) {
                        cornerBook2BookShelf(key);
                        LibraryMoveInfo tem1 = new LibraryMoveInfo(key, "bro", "bs");
                        moveList.add(tem1);
                    }
                } else {
                    //放回漂流处
                    cornerPlace.addCornerBooK(key);
                    LibraryMoveInfo tem1 = new LibraryMoveInfo(key, "bro", "bdc");
                    moveList.add(tem1);
                }
            }
        }
        borrowPlace.finishTran();
    }

    public void moveBookShelf2OrderPlace(LocalDate today, List<LibraryMoveInfo> moveList) {
        ArrayList<Request> tem = orderPlace.getToBeOrderList();
        ArrayList<Request> outRequest = new ArrayList<>();
        for (int i = 0; i < tem.size(); i++) {
            Request request = tem.get(i);
            String studentId = request.getStudentId();
            LibraryBookId bookId = request.getBookId();
            if (bookShelf.get(bookId) > 0) {
                deleteBookShelf(bookId);
                orderPlace.addOrderList(today, studentId, bookId);
                outRequest.add(request);
                LibraryMoveInfo tem1 = new LibraryMoveInfo(bookId, "bs", "ao", studentId);
                moveList.add(tem1);
            }
        }
        orderPlace.finishTran(outRequest);
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

    public void cornerBook2BookShelf(LibraryBookId bookId) {
        LibraryBookId inShelf = bookId.toFormal();
        if (bookShelf.containsKey(inShelf)) {
            int count = bookShelf.get(inShelf) + 1;
            bookShelf.put(inShelf, count);
        } else {
            bookShelf.put(inShelf, 1);
        }
    }
}
