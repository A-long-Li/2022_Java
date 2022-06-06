package netDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liyajun
 * @date 2022/5/30 14:32
 */
public class serverDemo {
    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(5858);

            while(true){
                Socket accept = ss.accept();
                System.out.println(accept.getPort());

                InputStream in = accept.getInputStream();
                OutputStream out = accept.getOutputStream();

                DataOutputStream ds = new DataOutputStream(out);
                ds.writeUTF("hello client");

                DataInputStream dis = new DataInputStream(in);
                System.out.println(dis.readUTF());
                in.close();
                out.close();
                accept.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
