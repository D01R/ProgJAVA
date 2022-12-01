package Labs.Second;

import java.io.IOException;

public class Input {
    static String inputLine(){
        try{
            byte name[] = new byte[100];
            System.in.read(name);
            return new String(name).trim();
        }catch (IOException ioException) {
            System.out.println("������� ������� ������, ���������� ��� ���");
            return Input.inputLine();
        }
    }

    static int inputNumber(){
        try{
            byte numPas[] = new byte[100];
            System.in.read(numPas);
            return Integer.parseInt(new String(numPas).trim());
        }
        catch (NumberFormatException numberFormatException){
            numberFormatException.printStackTrace();
            System.out.println("������� ������� �����, ���������� ��� ���");
            return Input.inputNumber();

        } catch (IOException e) {
            System.out.println("������� ������� �����, ���������� ��� ���");
            return Input.inputNumber();
        }
    }
}
