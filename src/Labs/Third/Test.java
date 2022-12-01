package Labs.Third;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Test {
    public static void main(String[] args) throws IOException {
        FileInputStream f1 = new FileInputStream("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\Third\\Stih.txt");
        FileOutputStream f2 = new FileOutputStream("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\Third\\f2.txt");
        FileOutputStream f3 = new FileOutputStream("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\Third\\f3.txt");
        FileOutputStream f4 = new FileOutputStream("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\Third\\f4.txt");

        byte[] buf = f1.readAllBytes();
        int symbCount = 0;
        int wordCount = 0;

        for (int i = 0; i < buf.length; i++){
            symbCount++;
            if (((char) buf[i] == ' ')){
                wordCount++;
            }
            if ((char) buf[i] == '\n'){
                wordCount++;
                String wordCountLine = String.valueOf(wordCount);
                f3.write(wordCountLine.getBytes());
                f3.write('\n');
                String symbCountLine = String.valueOf(symbCount);
                f2.write(symbCountLine.getBytes());
                f2.write('\n');
                wordCount=0;
                symbCount = 0;
            }
            if ( i == buf.length-1){
                wordCount++;
                String wordCountLine = String.valueOf(wordCount);
                f3.write(wordCountLine.getBytes());
                String symbCountLine = String.valueOf(symbCount);
                f2.write(symbCountLine.getBytes());
            }
        }
        f2.close();
        f3.close();

        FileInputStream fr2 = new FileInputStream("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\Third\\f2.txt");
        FileInputStream fr3 = new FileInputStream("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\Third\\f3.txt");

        char let = ' ';

        for(int i = 0; i < buf.length; i++){
            if ((char) buf[i] == '\n'){
                f4.write(' ');
                while ((let = (char) fr2.read()) !='\n') f4.write(let);
                f4.write(' ');
                while ((let = (char) fr3.read()) !='\n') f4.write(let);
            }
            if(i == buf.length-1){
                f4.write(' ');
                while (fr2.available()!=0) f4.write(fr2.read());
                f4.write(' ');
                while (fr3.available() != 0) f4.write(fr3.read());
                break;
            }
            f4.write(buf[i]);
        }
        f1.close();
        fr2.close();
        fr3.close();
        f4.close();

    }
}
