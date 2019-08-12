import constants.Fields;
import constants.Lines;
import utils.Utils;
import java.util.Objects;

public class EnterFields {

    public static Object enter(Fields type){
        if(Objects.isNull(type)) return null;
        switch (type){
            case VIN_CODE: return vin();
            case REG_NUM: return reg();
            case MODEL: return model();
            case PRICE: return price();
            case PATH: return path();
            case YEAR: return year();
            default: return null;
        }
    }

    private static String vin(){
        while(true) {
            System.out.println(Lines.ENTER_VIN_CODE);
            String line = Utils.printLine();
            if(Cars.checkVinCode(line) || Utils.isZero(line)) return line;
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private static String reg(){
        while(true) {
            System.out.println(Lines.ENTER_REG_NUMBER);
            String line = Utils.printLine();
            if(Cars.checkRegNumber(line) || Utils.isZero(line)) return line;
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private static String model(){
        while(true) {
            System.out.println(Lines.ENTER_MODEL);
            String line = Utils.printLine();
            if(Cars.checkModel(line) || Utils.isZero(line)) return line;
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private static Integer path(){
        while(true) {
            System.out.println(Lines.ENTER_PATH);
            int number = Utils.printNumber();
            if(Cars.checkPath(number)) return number;
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private static Integer year(){
        while(true) {
            System.out.println(Lines.ENTER_YEAR);
            int number = Utils.printNumber();
            if(Cars.checkYear(number) || number == 0) return number;
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private static Integer price(){
        while(true) {
            System.out.println(Lines.ENTER_PRICE);
            int number = Utils.printNumber();
            if(Cars.checkPrice(number) || number == 0) return number;
            System.out.println(Lines.NON_CORRECT);
        }
    }

}
