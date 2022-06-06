package netDemo;

import java.io.*;
import java.net.Socket;

/**
 * @author liyajun
 * @date 2022/5/30 14:32
 */
public class ClientDemo {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1",5858);
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();
            DataOutputStream ds = new DataOutputStream(out);
            ds.writeUTF("hello server");

            DataInputStream dis = new DataInputStream(in);
            System.out.println(dis.readUTF());

            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
