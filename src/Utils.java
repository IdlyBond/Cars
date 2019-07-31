import java.util.Objects;
import java.util.Scanner;

public abstract class Utils {

    public static int printNumberFromTo(int from, int to){
        System.out.println("* Введите число: ");
        while(true) {
            Scanner scr = new Scanner(System.in);
            Integer number = null;
            if (scr.hasNextInt()) number = scr.nextInt();
            if (Objects.nonNull(number) && number >= from && number <= to) return number;
            System.out.println("* Попробуйте еще раз.");
        }
    }

    public static int printNumberFromTo(int from){
        System.out.println("* Введите число: ");
        while(true) {
            Scanner scr = new Scanner(System.in);
            Integer number = null;
            if (scr.hasNextInt()) number = scr.nextInt();
            if (Objects.nonNull(number) && number >= from) return number;
            System.out.println("* Попробуйте еще раз.");
        }
    }

    public static int printNumberFromTo(int from, int to, int and){
        System.out.println("* Введите число: ");
        while(true) {
            Scanner scr = new Scanner(System.in);
            Integer number = null;
            if (scr.hasNextInt()) number = scr.nextInt();
            if (Objects.nonNull(number) && (number >= from && number <= to || number == and)) return number;
            System.out.println("* Попробуйте еще раз.");
        }
    }

    public static String printLine(){
        return new Scanner(System.in).nextLine();
    }

    public static String printLine(String regex){
        while(true) {
            Scanner scr = new Scanner(System.in);
            if (scr.nextLine().trim().matches(regex)) return scr.nextLine();
        }
    }
    public static boolean isZero(String line){
        if(Objects.isNull(line)) return false;
        return line.trim().length() == 1 && line.trim().equals("0");
    }
}
