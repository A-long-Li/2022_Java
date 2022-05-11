package experiment.nine;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author liyajun
 * @date 2022/5/11 14:33
 */
public class clientCode {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getLocalHost(),9090);
        OutputStreamWriter sOuter = new OutputStreamWriter(s.getOutputStream());
        BufferedReader sReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.println("guess game start");
        System.out.println("please enter a num");
        while((line = kReader.readLine()) != null){
            sOuter.write(line+"\n");
            sOuter.flush();
            line = sReader.readLine();
            System.out.println(line);
            sOuter.flush();
        }

    }
}
