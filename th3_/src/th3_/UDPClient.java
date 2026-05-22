/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th3_;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);

            DatagramSocket clientSocket =
                    new DatagramSocket();

            // IP SERVER
            InetAddress IPAddress =
                    InetAddress.getByName(
                            "192.168.137.189"
                    );

            // nhập N
            int n;

            do {

                System.out.print(
                        "Nhap so phan tu N (>100): "
                );

                n = sc.nextInt();

            } while (n <= 100);

            // sinh mảng ngẫu nhiên
            String s = "";

            System.out.println("\nMang ngau nhien:");

            for (int i = 0; i < n; i++) {

                int x = (int)(Math.random() * 100);

                System.out.print(x + " ");

                s += x + " ";
            }

            // gửi dữ liệu
            byte[] sendData = s.getBytes();

            DatagramPacket sendPacket =
                    new DatagramPacket(
                            sendData,
                            sendData.length,
                            IPAddress,
                            1234
                    );

            clientSocket.send(sendPacket);

            System.out.println(
                    "\n\nDa gui mang sang server"
            );

            // nhận kết quả
            byte[] receiveData = new byte[4096];

            DatagramPacket receivePacket =
                    new DatagramPacket(
                            receiveData,
                            receiveData.length
                    );

            clientSocket.receive(receivePacket);

            String result =
                    new String(
                            receivePacket.getData(),
                            0,
                            receivePacket.getLength()
                    );

            // hiển thị
            System.out.println(
                    "\nCac so nguyen to:"
            );

            System.out.println(result);

            clientSocket.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}