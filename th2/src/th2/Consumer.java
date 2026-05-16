package th2;

import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Consumer extends Thread {
    private String name;
    private DataA data;
    private Random rd = new Random();
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public Consumer(String name, DataA data) {
        this.name = name;
        this.data = data;
    }

    @Override
    public void run() {
        while (true) { // Chạy vô hạn
            try {
                Thread.sleep(rd.nextInt(3000) + 1000); 
                
                // Gọi hàm đọc từ kho A
                int value = data.readData();
                
                // Nhiệm vụ tự định nghĩa: Kiểm tra số chẵn hay lẻ
                String result = (value % 2 == 0) ? "So Chan" : "So Le";
                String time = sdf.format(new Date());
                
                System.out.println(name + ": <" + value + "> - <" + result + "> - <" + time + ">");
                
            } catch (InterruptedException e) {}
        }
    }
}