package th2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataA sharedData = new DataA();

        System.out.print("Nhap so luong luong ghi k: ");
        int k = sc.nextInt();
        System.out.print("Nhap so luong luong doc h: ");
        int h = sc.nextInt();

        // Khởi tạo k luồng Producer
        for (int i = 1; i <= k; i++) {
            new Producer("P" + i, sharedData).start();
        }

        // Khởi tạo h luồng Consumer
        for (int i = 1; i <= h; i++) {
            new Consumer("C" + i, sharedData).start();
        }
    }
}