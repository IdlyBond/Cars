import Constants.Lines;

import java.util.Objects;

public class Car {
    private String vinCode;
    private String regNumber;
    private String model;
    private int path;
    private int year;
    private int price;

    // Изменить на private
    public Car(String vinCode, String regNumber, String model, int path, int year, int price) {
        if(Cars.checkVinCode(vinCode)) this.vinCode = vinCode;
        if(Cars.checkRegNumber(regNumber)) this.regNumber = regNumber;
        if(Cars.checkModel(model))this.model = model;
        if(Cars.checkPath(path)) this.path = path;
        if(Cars.checkYear(year))this.year = year;
        if(Cars.checkPrice(price))this.price = price;
    }

    public static Car CREATE_CAR(){
        Car car = new Car(null, null, null, 0, 0, 0);
        car.changeAll();
        return car;
    }

    public void change(){
        while(true){
            System.out.print(Lines.WHAT_TO_CHANGE);
            System.out.println(Lines.ZERO_TO_EXIT);
            System.out.println(Lines.CHANGE_OPTIONS);
            int number = Utils.printNumberFromTo(0, 7);
            if(number == 0) return;
            change(number);
        }
    }

    private void change(int number){
        switch (number){
            case 1:
                System.out.println(Lines.ENTER_VIN_CODE);
                setVinCode();
                break;
            case 2:
                System.out.println(Lines.ENTER_REG_NUMBER);
                setRegNumber();
                break;
            case 3:
                System.out.println(Lines.ENTER_MODEL);
                setModel();
                break;
            case 4:
                System.out.println(Lines.ENTER_PATH);
                setPath();
                break;
            case 5:
                System.out.println(Lines.ENTER_YEAR);
                setYear();
                break;
            case 6:
                System.out.println(Lines.ENTER_PRICE);
                setPrice();
                break;
            case 7:
                changeAll();
                break;
        }
    }

    private void changeAll(){
        System.out.println(Lines.ENTER_VIN_CODE);
        setVinCode();
        System.out.println(Lines.ENTER_REG_NUMBER);
        setRegNumber();
        System.out.println(Lines.ENTER_MODEL);
        setModel();
        System.out.println(Lines.ENTER_PATH);
        setPath();
        System.out.println(Lines.ENTER_YEAR);
        setYear();
        System.out.println(Lines.ENTER_PRICE);
        setPrice();
    }

    public String getVinCode() {
        return vinCode;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getModel() {
        return model;
    }

    public int getPath() {
        return path;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    private void setVinCode() {
        while(true) {
            String vin = Utils.printLine();
            if(Cars.checkVinCode(vin)) {
                this.vinCode = vin.trim();
                break;
            }
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private void setRegNumber() {
        while(true) {
            String reg = Utils.printLine();
            if(Cars.checkRegNumber(reg)) {
                this.regNumber = reg.trim();
                break;
            }
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private void setModel() {
        while(true) {
            String model = Utils.printLine();
            if(Cars.checkModel(model)) {
                this.model = model;
                break;
            }
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private void setYear() {
        while(true) {
            int year = Utils.printNumber();
            if(Cars.checkYear(year)) {
                this.year = year;
                break;
            }
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private void setPrice() {
        while(true) {
            int price = Utils.printNumber();
            if(Cars.checkPrice(price)) {
                this.price = price;
                break;
            }
            System.out.println(Lines.NON_CORRECT);
        }
    }

    private void setPath() {
        while(true) {
            int path = Utils.printNumber();
            if(Cars.checkPath(path)) {
                this.path = path;
                break;
            }
            System.out.println(Lines.NON_CORRECT);
        }
    }

    @Override
    public String toString() {
        if(Objects.isNull(vinCode) || Objects.isNull(regNumber)) return  null;
        return "VIN: " + vinCode + "\n" +
        "Регистрационный номер: " + regNumber + "\n" +
        "Модель: " + model + "\n" +
        "Пробег: " + path + "\n" +
        "Год выпуска: " + year + "г.\n" +
        "Цена: " + price + "$\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return path == car.path &&
                year == car.year &&
                price == car.price &&
                Objects.equals(vinCode, car.vinCode) &&
                Objects.equals(regNumber, car.regNumber) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vinCode, regNumber, model, path, year, price);
    }
}
