import Constants.Lines;

public class Menu {

    private CarCollector carCollector;

    public Menu() {
        this.carCollector = new CarCollector();
    }

    public void mainMenu(){
        while(true){
            System.out.println(Lines.CHOOSE_LINE);
            System.out.println(Lines.MAIN_OPTIONS_LINE);
            switch (Utils.printNumberFromTo(-1, 4)){
                case 1:
                    searchMenu();
                    break;
                case 2:
                    addCar();
                    break;
                case 3:
                    changeParameterByVIN();
                    break;
                case 4:
                    deleteByVIN();
                    break;
                case 0:
                    break;
                case -1:
                    return;
            }
        }
    }

    private void searchMenu(){
        while(true) {
            System.out.println(Lines.CHOOSE_LINE);
            System.out.println(Lines.SEARCH_OPTIONS_LINE);
            switch (Utils.printNumberFromTo(0, 2, 7)) {
                case 1:
                    findByVIN();
                    break;
                case 2:
                    findByREG();
                    break;
                case 7:
                    showAllCars();
                    break;
                case 0:
                    return;
            }
        }
    }

    private String enterVIN(){
        System.out.println(Lines.ENTER_VIN_CODE);
        System.out.println(Lines.ZERO_TO_EXIT);
        return Utils.printLine();
    }

    private String enterREG(){
        System.out.println(Lines.ENTER_REG_NUMBER);
        System.out.println(Lines.ZERO_TO_EXIT);
        return Utils.printLine();
    }

    private void findByVIN(){
        while(true){
            String line = enterVIN();
            if(Utils.isZero(line)) return;
            if(Cars.checkVinCode(line)){
                carCollector.findByVIN(line);
            }
        }
    }

    private void findByREG(){
        while(true){
            String line = enterREG();
            if(Utils.isZero(line)) return;
            if(Cars.checkRegNumber(line)){
                carCollector.findByREG(line);
            }
        }
    }

    private void showAllCars(){
        System.out.println(carCollector);
    }

    private void addCar(){
        carCollector.addCar();
    }

    private void changeParameterByVIN(){
        while(true){
            String line = enterREG();
            if(Utils.isZero(line)) return;
            if(Cars.checkVinCode(line)){
                carCollector.changeByVIN(line);
            }
        }
    }

    private void deleteByVIN(){
        while(true){
            String line = enterVIN();
            if(Utils.isZero(line)) return;
            if(Cars.checkVinCode(line)){
                carCollector.deleteByVIN(line);
            }
        }
    }
}
