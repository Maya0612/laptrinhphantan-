package th2;

import java.util.ArrayList;

public class DataA {
    // 1. Khai báo danh sách A kiểu số nguyên, khởi tạo rỗng
    public ArrayList<Integer> A = new ArrayList<>();
    // Giới hạn kho chứa (N > 100)
    public int limit = 110;

    // 2. Phương thức GHI dữ liệu (dùng cho Producer)
    public synchronized void addData(int value, String producerName, String time) {
        // Nếu kho đầy, bắt Producer dừng lại đợi
        while (A.size() >= limit) {
            try {
                wait(); 
            } catch (InterruptedException e) {}
        }
        
        // Ghi dữ liệu vào mảng
        A.add(value);
        System.out.println(producerName + ": <" + value + "> - <" + time + ">");
        
        // Thông báo cho các luồng đang đợi (Consumer) biết là đã có hàng
        notifyAll();
    }

    // 3. Phương thức ĐỌC dữ liệu (dùng cho Consumer)
    public synchronized int readData() {
        // Nếu kho rỗng, bắt Consumer dừng lại đợi
        while (A.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        
        // Đọc giá trị cuối cùng (theo yêu cầu ĐỌC và KHÔNG XÓA)
        int value = A.get(A.size() - 1);
        
        // Thông báo cho Producer biết là vừa có thao tác trên mảng
        notifyAll();
        return value;
    }
}