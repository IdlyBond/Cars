import java.util.Objects;

public class Car {
    private String vinCode;
    private String regNumber;

    // Изменить на private
    public Car(String vinCode, String regNumber) {
        if(checkVinCode(vinCode)) this.vinCode = vinCode;
        if(checkRegNumber(regNumber)) this.regNumber = regNumber;
    }

    public static Car CREATE_CAR(){
        Car car = new Car(null, null);
        car.changeParameters();
        return car;
    }

    public void changeParameters(){
        System.out.println(Lines.ENTER_VIN_CODE);
        setVinCode();
        System.out.println(Lines.ENTER_REG_NUMBER);
        setRegNumber();
    }

    public static boolean checkVinCode(String line){
        if(Objects.isNull(line)) return false;
        return line.trim().length() == 17 && line.trim().matches("[0-9A-HJ-NPR-Z]+");
    }

    public static boolean checkRegNumber(String line){
        if(Objects.isNull(line)) return false;
        return line.trim().length() == 8 && line.trim().matches("^[A-C][A-Z]\\d{4}[A-C][A-Z]$");
    }

    public String getVinCode() {
        return vinCode;
    }

    public String getRegNumber() {
        return regNumber;
    }

    private void setVinCode() {
        while(true) {
            String line = Utils.printLine();
            if(checkVinCode(line)) {
                this.vinCode = line.trim();
                break;
            }
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private void setRegNumber() {
        while(true) {
            String line = Utils.printLine();
            if(checkRegNumber(line)) {
                this.regNumber = line.trim();
                break;
            }
            System.out.println(Lines.NON_CORRECT);
        }
    }

    @Override
    public String toString() {
        if(Objects.isNull(vinCode) || Objects.isNull(regNumber)) return  null;
        return "VIN: " + vinCode + "\n" +
        "Регистрационный номер: " + regNumber + "\n";
    }
}
