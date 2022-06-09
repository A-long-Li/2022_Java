package experiment.nine;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author liyajun
 * @date 2022/5/11 14:33
 */
public class clientCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Socket mySocket = null;
        DataInputStream inData = null;
        DataOutputStream outData = null;
        ReadNumber readNumber = null;
        Thread thread;
        try {
            mySocket = new Socket();
            readNumber = new ReadNumber();
            thread = new Thread(readNumber);
            System.out.print("输入服务器的IP：");
            String ip = sc.nextLine();
            System.out.print("输入端口号：");
            int port = sc.nextInt();

            if (!mySocket.isConnected()) {
                InetAddress address = InetAddress.getByName(ip);
                InetSocketAddress socketAddress = new InetSocketAddress(
                        address, port);
                mySocket.connect(socketAddress);
                InputStream in = mySocket.getInputStream();
                OutputStream out = mySocket.getOutputStream();
                inData = new DataInputStream(in);
                outData = new DataOutputStream(out);
                readNumber.setDataInputStream(inData);
                readNumber.setDataOutputStream(outData);
                thread.start();
            }
        } catch (Exception e) {
            System.out.println("服务器已断开");
        }
    }
}

class ReadNumber implements Runnable {
    Scanner sc = new Scanner(System.in);
    DataInputStream in;
    DataOutputStream out;

    public void setDataInputStream(DataInputStream in) {
        this.in = in;
    }

    public void setDataOutputStream(DataOutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            out.writeUTF("Y");
            while (true) {
                String str = in.readUTF();
                System.out.println(str);
                if (!str.startsWith("询问")) {
                    if (str.startsWith("猜对了")) continue;
                    System.out.println("好的，我输入猜测：");
                    int myGuess = sc.nextInt();
                    String enter = sc.nextLine();//去除多余的回车符
                    out.writeInt(myGuess);
                } else {
                    System.out.println("好的，我输入Y或者N：");
                    String myAnswer = sc.nextLine();
                    out.writeUTF(myAnswer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器已断开");
        }
    }
}