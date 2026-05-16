package th2;

import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Producer extends Thread {
    private String name;
    private DataA data;
    private Random rd = new Random();
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public Producer(String name, DataA data) {
        this.name = name;
        this.data = data;
    }

    @Override
    public void run() {
        while (true) { // Chạy vô hạn
            try {
                // Ngủ ngẫu nhiên một khoảng thời gian
                Thread.sleep(rd.nextInt(2000) + 500); 
                
                int value = rd.nextInt(100); // Sinh số ngẫu nhiên 0-99
                String time = sdf.format(new Date());
                
                // Gọi hàm ghi đã được đồng bộ hóa
                data.addData(value, name, time);
                
            } catch (InterruptedException e) {}
        }
    }
}