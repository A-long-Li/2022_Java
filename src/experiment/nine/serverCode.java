package experiment.nine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @author liyajun
 * @date 2022/5/11 14:33
 */
public class serverCode {
    public static void main(String[] args) throws IOException {
        Random r = new Random();
        int ans = r.nextInt(1000)+1;
        System.out.println("需要猜的数为" + ans);
        ServerSocket ss = new ServerSocket(9090);
        Socket s = ss.accept();
        BufferedReader sReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        OutputStreamWriter sOuter = new OutputStreamWriter(s.getOutputStream());
       // BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = sReader.readLine()) != null) {
            System.out.println("猜的是" + line);
            int res = Integer.parseInt(line);
            if(ans == res){
                sOuter.write("u are right!! \t continue ??? -> enter y to continue \t\n");
                sOuter.flush();
                line = sReader.readLine();
                if(line.startsWith("y") || line.startsWith("Y")) {
                    sOuter.write("let's go \t please enter a num\t\n");
                    sOuter.flush();
                    ans = r.nextInt(1000)+1;
                    System.out.println("要猜的是"+ans);
                } else {
                    sOuter.write("please enter any key to exit\t\n");
                    sOuter.flush();
                    s.close();
                    ss.close();
                }
            } else {
                if(ans > res) {
                    sOuter.write("too small plz try again \t\n");
                } else {
                    sOuter.write("too big plz try again \t\n");
                }
                sOuter.flush();
            }
        }
        ss.close();
    }
}
