package th1;

import java.util.ArrayList;

public class MyThread extends Thread { 

    private ArrayList<Integer> A;
    private int start;
    private int end;
    private String threadName;
    private int count = 0;

    // HÀM KHỞI TẠO 
    public MyThread(String name, ArrayList<Integer> data, int start, int end) {
        this.threadName = name;
        this.A = data;
        this.start = start;
        this.end = end;
    }

    // HÀM KIỂM TRA SNT
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //HÀM CHẠY ĐA LUỒNG
    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            int value = A.get(i);
            if (isPrime(value)) {
                count++;
                System.out.println(threadName + ": " + value + " : " + System.currentTimeMillis());
            }
        }
    }

    // HÀM LẤY KẾT QUẢ
    public int getCount() {
        return count;
    }

} 