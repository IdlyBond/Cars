import java.util.*;

public class CarCollector {

    private ArrayList<Car> carsList = new ArrayList<>();

    public void addCar(){
        carsList.add(Car.CREATE_CAR());
        Set<Car> set = new HashSet<>(carsList);
        carsList.clear();
        carsList.addAll(set);
    }

    private int searchByVIN(String searchVIN){
        for (int i = 0; i < carsList.size(); i++){
            String thisVIN = carsList.get(i).getVinCode();
            if(Objects.isNull(thisVIN)) break;
            if(thisVIN.equals(searchVIN) && Objects.nonNull(carsList.get(i).toString())){
                return i;
            }
        }
        return -1;
    }

    private int searchByREG(String searchREG){
        for (int i = 0; i < carsList.size(); i++){
            String thisREG = carsList.get(i).getRegNumber();
            if(Objects.isNull(thisREG)) break;
            if(thisREG.equals(searchREG) && Objects.nonNull(carsList.get(i).toString())){
                return i;
            }
        }
        return -1;
    }

    public void findByVIN(String vin){
        sayIfExists(searchByVIN(vin));
    }

    public void findByREG(String reg){
        sayIfExists(searchByREG(reg));
    }

    private void sayIfExists(int index){
        if(index == -1){
            System.out.println(Lines.NO_CARS_FOUND);
        }
        else {
            System.out.println(Lines.FOUND_CAR);
            System.out.println(carsList.get(index));
        }
    }

    public void deleteByVIN(String vin){
        carsList.remove(searchByVIN(vin));
    }

    public void changeParametersByVIN(String vin){
        carsList.get(searchByVIN(vin)).changeParameters();
    }

    public CarCollector() {
        //Манины по умолчанию, для наглядности
        Car car1 = new Car(Lines.DEFAULT_VIN_1.getLine(), Lines.DEFAULT_REG_NUM_1.getLine());
        Car car2 = new Car(Lines.DEFAULT_VIN_2.getLine(), Lines.DEFAULT_REG_NUM_2.getLine());
        Car car3 = new Car(Lines.DEFAULT_VIN_3.getLine(), Lines.DEFAULT_REG_NUM_3.getLine());
        Car car4 = new Car(Lines.DEFAULT_VIN_4.getLine(), Lines.DEFAULT_REG_NUM_4.getLine());
        this.carsList.add(car1);
        this.carsList.add(car2);
        this.carsList.add(car3);
        this.carsList.add(car4);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarCollector that = (CarCollector) o;
        return Objects.equals(carsList, that.carsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carsList);
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("Все машины:\n");
        for (int i = 0; i < carsList.size(); i++){
            line.append((i + 1) + ":\n " + carsList.get(i) + "\n");
        }
        return line.toString();
    }
}
