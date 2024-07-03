import com.oocourse.library3.LibraryBookId;
import com.oocourse.library3.LibraryCommand;
import com.oocourse.library3.LibraryReqCmd;
import com.oocourse.library3.LibraryRequest;
import com.oocourse.library3.LibraryQcsCmd;

import java.time.LocalDate;
import java.util.Map;

import static com.oocourse.library3.LibrarySystem.PRINTER;
import static com.oocourse.library3.LibrarySystem.SCANNER;

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
            LibraryCommand command = SCANNER.nextCommand();
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
            } else if (command instanceof LibraryQcsCmd) {
                //查询信用分
                queryCreditScoreRequest(((LibraryQcsCmd) command).getStudentId(), command);
            } else {
                LibraryRequest request = ((LibraryReqCmd) command).getRequest();
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
                    returnRequest(today, studentId, bookId, command);
                } else if (type == LibraryRequest.Type.RENEWED) {
                    renewRequest(today, studentId, bookId, request);
                } else if (type == LibraryRequest.Type.DONATED) {
                    donateRequest(today, bookId, request, studentId);
                }
            }
        }
    }

    public void queryCreditScoreRequest(String studentId, LibraryCommand cmd) {
        int creditScore = library.handleQueryCreditScore(studentId);
        PRINTER.info(cmd, creditScore);
    }

    public void queryRequest(LocalDate today, LibraryBookId bookId) {
        int count = library.handleQuery(bookId);
        PRINTER.info(today, bookId, count);
    }

    public void pickRequest(LocalDate today, String studentId,
                            LibraryBookId bookId, LibraryRequest request) {
        int mark = library.handlePick(studentId, bookId, today);
        if (mark == 0) {
            PRINTER.reject(today, request);
        } else {
            PRINTER.accept(today, request);
        }
    }

    public void orderRequest(LocalDate today, String studentId,
                             LibraryBookId bookId, LibraryRequest request) {
        if (bookId.isFormal()) {
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
        } else {
            PRINTER.reject(today, request);
        }
    }

    public void borrowRequest(LocalDate today, String studentId,
                              LibraryBookId bookId, LibraryRequest request) {
        if (bookId.isFormal()) {
            if (bookId.isTypeA()) {
                PRINTER.reject(today, request);
            } else {
                int mark = library.handleBorrow(studentId, bookId, today);
                if (mark == 0) {
                    PRINTER.reject(today, request);
                } else {
                    PRINTER.accept(today, request);
                }
            }
        } else {
            if (bookId.isTypeAU()) {
                PRINTER.reject(today, request);
            } else {
                int mark = library.handleCornerBorrow(studentId, bookId, today);
                if (mark == 0) {
                    PRINTER.reject(today, request);
                } else {
                    PRINTER.accept(today, request);
                }
            }
        }
    }

    public void returnRequest(LocalDate today, String studentId,
                              LibraryBookId bookId, LibraryCommand cmd) {
        int mark = library.handleReturn(studentId, bookId, today);
        if (mark == 0) {
            PRINTER.accept(cmd, "overdue");
        } else {
            PRINTER.accept(cmd, "not overdue");
        }
    }

    public void renewRequest(LocalDate today, String studentId,
                             LibraryBookId bookId, LibraryRequest request) {
        int mark = library.handleRenew(studentId, bookId, today);
        if (mark == 0) {
            PRINTER.reject(today, request);
        } else {
            PRINTER.accept(today, request);
        }
    }

    public void donateRequest(LocalDate today, LibraryBookId bookId,
                              LibraryRequest request, String studentId) {
        library.handleDonate(studentId, bookId);
        PRINTER.accept(today, request);
    }

    public void open(LocalDate today) {
        library.handleOpen(today);
    }

    public void close(LocalDate today) {
        library.handleClose(today);
    }
}
