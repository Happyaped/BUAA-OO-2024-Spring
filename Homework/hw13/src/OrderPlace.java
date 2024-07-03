import com.oocourse.library1.LibraryBookId;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrderPlace {
    private ArrayList<Request> orderList;//代表了在预约处的书
    private ArrayList<Request> toBeOrderList;//代表了在下一次整理的时候放在预约处的书

    public OrderPlace() {
        orderList = new ArrayList<>();
        toBeOrderList = new ArrayList<>();
    }

    public void addToBeOrderList(String studentId, LocalDate today, LibraryBookId bookId) {
        Request temRequest = new Request(today, studentId, bookId);
        toBeOrderList.add(temRequest);
    }

    public boolean checkHasReserved(String studentId, LibraryBookId bookId) {
        for (int i = 0; i < orderList.size(); i++) {
            Request request = orderList.get(i);
            if (request.getBookId().equals(bookId) && studentId.equals(request.getStudentId())) {
                return true;
            }
        }
        return false;
    }

    public void pickBook(String studentId, LibraryBookId bookId) {
        int mark = 0;
        for (int i = 0; i < orderList.size(); i++) {
            Request request = orderList.get(i);
            if (request.getBookId().equals(bookId) && studentId.equals(request.getStudentId())) {
                mark = i;
                break;
            }
        }
        orderList.remove(mark);
    }

    public ArrayList<Request> toBooKShelf(LocalDate today) {
        ArrayList<Request> tem1 = new ArrayList<>();//保存到期的
        ArrayList<Request> tem2 = new ArrayList<>();//保存没到期的
        for (int i = 0; i < orderList.size(); i++) {
            Request request = orderList.get(i);
            if (today.compareTo(request.getDate()) >= 0) {
                tem1.add(request);
            } else {
                tem2.add(request);
            }
        }
        orderList = tem2;
        return tem1;
    }

    public ArrayList<Request> getToBeOrderList() {
        return toBeOrderList;
    }

    public void finishTran() {
        toBeOrderList.clear();
    }

    public void addOrderList(LocalDate today, String studentId, LibraryBookId bookId) {
        Request request = new Request(today.plusDays(5), studentId, bookId);
        orderList.add(request);
    }
}
