import com.oocourse.library1.LibraryBookId;
import com.oocourse.library1.LibraryCommand;
import com.oocourse.library1.LibraryRequest;
import java.time.LocalDate;
import java.util.Map;
import static com.oocourse.library1.LibrarySystem.PRINTER;
import static com.oocourse.library1.LibrarySystem.SCANNER;

public class ParserInput {
    private Library library;

    public ParserInput() {
        library = new Library();
    }

    public void initLibrary() {
        Map<LibraryBookId, Integer> temMap;
        temMap = SCANNER.getInventory();
        for (LibraryBookId key : temMap.keySet()) {
            library.addInitBookShelf(key, temMap.get(key));
        }
    }

    public void parserInputRequest() {
        //处理请求
        while (true) {
            LibraryCommand<?> command = SCANNER.nextCommand();
            if (command == null) {
                break;
            }
            LocalDate today = command.getDate();
            if (command.getCmd().equals("OPEN")) {
                // 在图书馆开门之前干点什么
                open(today);
            } else if (command.getCmd().equals("CLOSE")) {
                // 在图书馆关门之后干点什么
                close(today);
            } else {
                LibraryRequest request = (LibraryRequest) command.getCmd();
                // 对 request 干点什么
                String studentId = request.getStudentId();
                LibraryBookId bookId = request.getBookId();
                LibraryRequest.Type type = request.getType();
                if (type == LibraryRequest.Type.QUERIED) {
                    queryRequest(today, bookId);
                } else if (type == LibraryRequest.Type.PICKED) {
                    pickRequest(today, studentId, bookId, request);
                } else if (type == LibraryRequest.Type.ORDERED) {
                    orderRequest(today, studentId, bookId, request);
                } else if (type == LibraryRequest.Type.BORROWED) {
                    borrowRequest(today, studentId, bookId, request);
                } else if (type == LibraryRequest.Type.RETURNED) {
                    returnRequest(today, studentId, bookId, request);
                }
            }
        }
    }

    public void queryRequest(LocalDate today, LibraryBookId bookId) {
        int count = library.handleQuery(bookId);
        PRINTER.info(today, bookId, count);
    }

    public void pickRequest(LocalDate today, String studentId,
                            LibraryBookId bookId, LibraryRequest request) {
        int mark = library.handlePick(studentId, bookId);
        if (mark == 0) {
            PRINTER.reject(today, request);
        } else {
            PRINTER.accept(today, request);
        }
    }

    public void orderRequest(LocalDate today, String studentId,
                             LibraryBookId bookId, LibraryRequest request) {
        if (bookId.isTypeA()) {
            PRINTER.reject(today, request);
        } else {
            int mark = library.handleOrder(studentId, bookId, today);
            if (mark == 0) {
                PRINTER.reject(today, request);
            } else {
                PRINTER.accept(today, request);
            }
        }
    }

    public void borrowRequest(LocalDate today, String studentId,
                              LibraryBookId bookId, LibraryRequest request) {
        if (bookId.isTypeA()) {
            PRINTER.reject(today, request);
        } else {
            int mark = library.handleBorrow(studentId, bookId);
            if (mark == 0) {
                PRINTER.reject(today, request);
            } else {
                PRINTER.accept(today, request);
            }
        }
    }

    public void returnRequest(LocalDate today, String studentId,
                              LibraryBookId bookId, LibraryRequest request) {
        library.handleReturn(studentId, bookId);
        PRINTER.accept(today, request);
    }

    public void open(LocalDate today) {
        library.handleOpen(today);
    }

    public void close(LocalDate today) {
        library.handleClose(today);
    }
}
