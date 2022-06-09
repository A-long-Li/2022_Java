package experiment.nine;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @author liyajun
 * @date 2022/5/11 14:33
 */
public class serverCode {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket you = null;
        while (true) {
            try {
                server = new ServerSocket(5333);
            } catch (IOException e) {
                System.out.println("正在监听");
            }
            try {
                you = server.accept();
                System.out.println("客户的地址：" + you.getInetAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (you != null) {
                new ServerThread(you).start();
            }
        }
    }
}

class ServerThread extends Thread {
    Socket socket;
    DataInputStream in = null;
    DataOutputStream out = null;

    ServerThread(Socket t) {
        socket = t;
        try {
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {
                String str = in.readUTF();
                boolean boo = str.startsWith("Y") || str.startsWith("y");
                if (boo) {
                    out.writeUTF("给你一个1-100的随机数，猜猜它是多少？");
                    Random ran = new Random();
                    int realNumber = ran.nextInt(100) + 1;
                    handleClientGuess(realNumber);
                    out.writeUTF("询问：想继续玩输入Y，否则输入N：");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleClientGuess(int realNumber) {
        while (true) {
            try {
                int clientGuess = in.readInt();
                System.out.println(clientGuess);
                if (clientGuess > realNumber)
                    out.writeUTF("猜大了");
                else if (clientGuess < realNumber)
                    out.writeUTF("猜小了");
                else {
                    out.writeUTF("猜对了！");
                    break;
                }
            } catch (IOException e) {
                System.out.println("客户离开");
                return;
            }
        }
    }
}