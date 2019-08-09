import constants.Lines;
import utils.Utils;

import java.util.Objects;

public class Cars {

    public static boolean checkVinCode(String line){
        return Objects.nonNull(line);
    }

    public static boolean checkYear(int year){
        return year >= 1900 && year <= 2020;
    }

    public static boolean checkRegNumber(String line){
        if(Objects.isNull(line)) return false;
        return line.trim().length() == 8 && line.trim().matches("^[A-C][A-Z]\\d{4}[A-C][A-Z]$");
    }

    public static boolean checkModel(String line){
        if(Objects.isNull(line)) return false;
        return line.trim().length() != 0;
    }

    public static boolean checkPrice(int num){
        return Utils.moreThanNull(num);
    }

    public static boolean checkPath(int num){
        return Utils.moreThanNull(num);
    }

    public static void isExist(Object car){
        if(Objects.isNull(car)){
            System.out.println(Lines.NO_CARS_FOUND);
        }
        else {
            System.out.println(Lines.FOUND_CAR);
            System.out.println(car);
        }
    }
}
