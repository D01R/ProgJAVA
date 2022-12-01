package Labs.Second;
import java.util.Scanner;
public class ScannerInput {
    static String inputLine(){
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        return line;
    }
    static int inputNumber(){
        Scanner scan = new Scanner(System.in);
        int num;
        try {
            num = scan.nextInt();
        }
        catch (Exception exception){
            System.out.println("Неверно введено число, попробуйте ещё раз");
            return ScannerInput.inputNumber();
        }
        return num;
    }
}