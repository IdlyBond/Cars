import constants.Fields;
import constants.Lines;

import java.util.*;

public class CarCollector {

    private Map<String, Car> carsList = new HashMap<>();
    private Searcher searcher = new Searcher(carsList);

    public void addCar(){
        Car car = Car.CREATE_CAR();
        carsList.put(car.getVinCode(), car);
    }

    public Map<String, Car> search(final String var, Fields type){
        return searcher.find(var, type);
    }
    public Map<String, Car> search(final Integer from, final Integer to, Fields type){
        return searcher.find(from, to, type);
    }

    private Car searchByVIN(String vin){
        return carsList.getOrDefault(vin, null);
    }

    private Car searchByREG(String reg){
        for(Iterator iterator = carsList.values().iterator(); iterator.hasNext();){
            Car car = (Car)iterator.next();
            if(reg.equals(car.getRegNumber())) return car;
        }
        return null;
    }

    public void findByVIN(String vin){
        Cars.isExist(searchByVIN(vin));
    }

    public void findByREG(String reg){
        Cars.isExist(searchByREG(reg));
    }

    public void deleteByVIN(String vin){
        carsList.remove(vin);
    }

    public void changeByVIN(String vin){
        carsList.get(vin).change();
    }

    public CarCollector() {
        //Машины по умолчанию, для наглядности
        Car car1 = new Car(Lines.DEFAULT_VIN_1.getLine(), Lines.DEFAULT_REG_NUM_1.getLine(), Lines.DEFAULT_MODEL_1.getLine(),
                500, 2000, 1000);
        Car car2 = new Car(Lines.DEFAULT_VIN_2.getLine(), Lines.DEFAULT_REG_NUM_2.getLine(), Lines.DEFAULT_MODEL_2.getLine(),
                600, 2006, 1300);
        Car car3 = new Car(Lines.DEFAULT_VIN_3.getLine(), Lines.DEFAULT_REG_NUM_3.getLine(), Lines.DEFAULT_MODEL_3.getLine(),
                1500, 1995, 500);
        Car car4 = new Car(Lines.DEFAULT_VIN_4.getLine(), Lines.DEFAULT_REG_NUM_4.getLine(), Lines.DEFAULT_MODEL_4.getLine(),
                0, 2019, 3000);
        this.carsList.put(car1.getVinCode(), car1);
        this.carsList.put(car2.getVinCode(), car2);
        this.carsList.put(car3.getVinCode(), car3);
        this.carsList.put(car4.getVinCode(), car4);
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("Все машины:\n");
        carsList.forEach((k, v) -> line.append("* \n" + v + "\n"));
        return line.toString();
    }

    public static void main(String[] args) {
        CarCollector carCollector = new CarCollector();
        System.out.println(carCollector.search(Lines.DEFAULT_VIN_2.getLine(), Fields.VIN_CODE).values());
        System.out.println(carCollector.search(Lines.DEFAULT_REG_NUM_2.getLine(), Fields.REG_NUM).values());
        System.out.println(carCollector.search(Lines.DEFAULT_REG_NUM_2.getLine(), Fields.REG_NUM).values());
    }
}
