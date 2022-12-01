package Labs.ThirdA;

import java.io.*;

public class Test2 {
    public static void main(String[] args) throws IOException {
        FileReader f1 = new FileReader("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\ThirdA\\Stih.txt");
        FileWriter f2 = new FileWriter("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\ThirdA\\f2.txt");
        FileWriter f3 = new FileWriter("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\ThirdA\\f3.txt");
        FileWriter f4 = new FileWriter("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\ThirdA\\f4.txt");

        int symbCount = 0;
        int wordCount = 0;
        String stih = "";

        while (f1.ready()) {
            char letter = (char) f1.read();
            stih += String.valueOf(letter);
            symbCount++;
            if(letter == ' ')
                wordCount++;
            if (letter == '\n'){
                wordCount++;
                f3.write(" " + String.valueOf(wordCount)+'\n');
                f2.write(" " + String.valueOf(symbCount)+'\n');
                wordCount=0;
                symbCount = 0;
            }
            if(!f1.ready()){
                wordCount++;
                f3.write(String.valueOf(wordCount));
                f2.write(String.valueOf(symbCount));
            }
        }
        char[] buf = stih.toCharArray();

        f2.close();
        f3.close();

        FileReader fr2 = new FileReader("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\ThirdA\\f2.txt");
        FileReader fr3 = new FileReader("F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\ThirdA\\f3.txt");

        char let = ' ';

        for(int i = 0; i < buf.length; i++){
            if (buf[i] == '\n'){
                while ((let = (char) fr2.read()) !='\n') f4.write(let);
                f4.write(' ');
                while ((let = (char) fr3.read()) !='\n') f4.write(let);
            }
            if(i == buf.length-1){
                while (fr2.ready()) f4.write(fr2.read());
                f4.write(' ');
                while (fr3.ready()) f4.write(fr3.read());
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
