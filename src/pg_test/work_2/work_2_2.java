package pg_test.work_2;

import java.io.*;

/**
 * @author liyajun
 * @date 2022/5/9 15:04
 */
public class work_2_2 {
    public static void main(String[] args) throws IOException {
        File f = new File("D:\\dest.txt");
        DataOutputStream op = null;
        DataInputStream ip = null;
        try {
             op = new DataOutputStream(new FileOutputStream(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
             ip = new DataInputStream(new FileInputStream(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        op.writeInt(101);
        op.writeLong(123456);
        op.writeFloat((float) 3.1415926);

        System.out.println(ip.readInt());
        System.out.println(ip.readLong());
        System.out.println(ip.readFloat());
    }
}
