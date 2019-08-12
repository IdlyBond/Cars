import constants.Fields;
import constants.Lines;

import java.util.*;

public class CarCollector implements Comparable{

    private Map<String, Car> carsList = new HashMap<>();

    public void add(){
        Car car = Car.CREATE_CAR();
        carsList.put(car.getVinCode(), car);
    }

    public void remove(String vin){
        carsList.remove(vin);
    }

    public void change(String vin){
        carsList.get(vin).change();
    }

    public Map<String, Car> search(final String var, Fields type){
        Searcher searcher = new Searcher(carsList);
        return searcher.find(var, type);
    }
    public Map<String, Car> search(final Integer from, final Integer to, Fields type){
        Searcher searcher = new Searcher(carsList);
        return searcher.find(from, to, type);
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("Все машины:\n");
        carsList.forEach((k, v) -> line.append("* \n" + v + "\n"));
        return line.toString();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
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
                50, 2019, 3000);
        this.carsList.put(car1.getVinCode(), car1);
        this.carsList.put(car2.getVinCode(), car2);
        this.carsList.put(car3.getVinCode(), car3);
        this.carsList.put(car4.getVinCode(), car4);
    }
}
