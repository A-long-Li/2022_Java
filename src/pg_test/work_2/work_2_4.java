package pg_test.work_2;

import java.io.*;

/**
 * @author liyajun
 * @date 2022/5/9 15:12
 */
public class work_2_4 {
    public static void main(String[] args) throws IOException {
        FileReader fk = new FileReader("D:\\dest.txt");
        BufferedReader bf = new BufferedReader(fk);
        while (bf.ready()){
            System.out.println(bf.readLine());
        }
        bf.close();
    }

}

