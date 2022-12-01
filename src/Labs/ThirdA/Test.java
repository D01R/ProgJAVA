package Labs.ThirdA;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        DataInputStream f1 = new DataInputStream(new FileInputStream("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\ThirdA\\Stih.txt"));
        DataOutputStream f2 = new DataOutputStream(new FileOutputStream("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\ThirdA\\f2.txt"));
        DataOutputStream f3 = new DataOutputStream(new FileOutputStream("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\ThirdA\\f3.txt"));
        DataOutputStream f4 = new DataOutputStream(new FileOutputStream("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\ThirdA\\f4.txt"));
        while (f1.available() > 0){
            String f = f1.readLine();
            String symbCount = String.valueOf(f.length());
            String wordCount = String.valueOf((f.length() - f.replace(" ", "").length()+1));
            f2.writeBytes(symbCount);
            f3.writeBytes(wordCount);
            if(f1.available() > 0) {
                f2.writeByte('\n');
                f3.writeByte('\n');
            }

        }
        f1.close();
        f2.close();
        f3.close();
        DataInputStream fr1 = new DataInputStream(new FileInputStream("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\ThirdA\\Stih.txt"));
        DataInputStream fr2 = new DataInputStream(new FileInputStream("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\ThirdA\\f2.txt"));
        DataInputStream fr3 = new DataInputStream(new FileInputStream("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\ThirdA\\f3.txt"));
        while(fr1.available() > 0)
        {
            f4.writeBytes(fr1.readLine()+ " " + fr2.readLine() + " " + fr3.readLine());
            if (fr1.available() > 0)
                f4.write('\n');
        }

        f4.close();
    }
}
