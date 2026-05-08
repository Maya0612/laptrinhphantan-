package th1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ThucHanh1 {
    public static void main(String[] args) {
        // Khai báo cấu trúc dữ liệu A 
        int N = 10; 
        ArrayList<Integer> A = new ArrayList<>();
        Random rd = new Random(); // sinh số ngẫu nhiên
        
        for (int i = 0; i < N; i++) {
            A.add(rd.nextInt(100)); // Sinh số từ 0 đến 999 rồi đưa vào A
        }
        
        System.out.println("Da khoi tao mang A thanh cong.");
        System.out.print("Cac phan tu trong mang A: ");
        for (int i=0; i<A.size(); i++) {
            
            System.out.print("A[" + i + "] = " + A.get(i));
            System.out.println();
        }
           System.out.println();
        // --- Nhập số luồng k và chia việc  ---
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap k (k > 1): ");
        int k = sc.nextInt();
        
        // Tạo mảng để chứa k đối tượng luồng
        MyThread[] threads = new MyThread[k];
        int range = N / k; // Tính độ dài đoạn mảng mỗi luồng xử lý

        for (int i = 0; i < k; i++) {
            int start = i * range;
            // Nếu là luồng cuối cùng, nó sẽ lấy đến tận phần tử cuối của mảng (N)
            int end = (i == k - 1) ? N : (i + 1) * range;
            
            // Tạo luồng mới với tên T1, T2... và truyền đoạn mảng tương ứng
            threads[i] = new MyThread("T" + (i + 1), A, start, end);
           
            // Kích hoạt luồng chạy (gọi hàm run() ở MyThread)
            threads[i].start(); 
        }

        // --- Sử dụng JOIN 
        try {
            for (int i = 0; i < k; i++) {
                // Luồng chính (main) sẽ đợi cho đến khi luồng i làm xong mới chạy tiếp
                threads[i].join(); 
            }
        } catch (InterruptedException e) {
            System.out.println("Loi luong bi ngat");
        }

       
        int tongSoNguyenTo = 0;
        for (int i = 0; i < k; i++) {
            // Lấy biến count từ mỗi luồng đã hoàn thành cộng dồn lại
            tongSoNguyenTo += threads[i].getCount();
        }
        
    
        System.out.println("Ket luan: Tim thay " + tongSoNguyenTo + " so nguyen to.");
    }
}
//A.set(N - 1, 9); 