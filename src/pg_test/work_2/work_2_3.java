package pg_test.work_2;

import java.io.*;

/**
 * @author liyajun
 * @date 2022/5/9 15:24
 */
public class work_2_3 {
    public static void main(String[] args) throws IOException {
        File ff = new File("D:\\out.txt");
        DataOutputStream op = null;
        try {
            op = new DataOutputStream(new FileOutputStream(ff));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileReader f = new FileReader("{your project}");
        BufferedReader bf=  new BufferedReader(f);
        int cnt = 1;
        while(bf.ready()){
            //read
            String s =  bf.readLine();
            System.out.println(cnt + s);
            op.writeBytes(cnt + s + "\t\n");
            cnt++;
        }
    }
}
