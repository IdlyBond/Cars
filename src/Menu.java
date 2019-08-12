import constants.Fields;
import constants.Lines;
import utils.Utils;

public class Menu {

    private CarCollector carCollector = new CarCollector();

    public void mainMenu(){
        while(true){
            System.out.println(Lines.CHOOSE_LINE);
            System.out.println(Lines.MAIN_OPTIONS_LINE);
            switch (Utils.printNumberFromTo(-1, 4)){
                case 1:
                    searchMenu();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    change();
                    break;
                case 4:
                    delete();
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
            switch (Utils.printNumberFromTo(0, 7)) {
                case 1:
                    find(Fields.VIN_CODE);
                    break;
                case 2:
                    find(Fields.REG_NUM);
                    break;
                case 3:
                    find(Fields.MODEL);
                    break;
                case 4:
                    find(Fields.PATH);
                    break;
                case 5:
                    find(Fields.YEAR);
                    break;
                case 6:
                    find(Fields.PRICE);
                    break;
                case 7:
                    printCars();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void printCars(){
        System.out.println(carCollector);
    }

    private void add(){
        carCollector.add();
    }

    private void change(){
        while(true){
            System.out.println(Lines.ZERO_TO_EXIT);
            String line = (String)EnterFields.enter(Fields.VIN_CODE);
            if(Utils.isZero(line)) return;
            carCollector.change(line);
        }
    }

    private void delete(){
        while(true){
            System.out.println(Lines.ZERO_TO_EXIT);
            String line = (String)EnterFields.enter(Fields.VIN_CODE);
            if(Utils.isZero(line)) return;
            carCollector.remove(line);
        }
    }

    private void find(Fields type){
        while(true) {
            System.out.println(Lines.ZERO_TO_EXIT);
            if(type == Fields.VIN_CODE || type == Fields.REG_NUM || type == Fields.MODEL){
                String var = (String)EnterFields.enter(type);
                if (Utils.isZero(var)) return;
                Cars.isExist(carCollector.search(var, type));
            }
            else{
                int from = Integer.parseInt(EnterFields.enter(type).toString());
                if (from == 0) return;
                int to = Integer.parseInt(EnterFields.enter(type).toString());
                System.out.println(">=" + from + "&" + "<=" + to);
                Cars.isExist(carCollector.search(from, to, type));
            }
        }
    }

    @Override
    public String toString() {
        return carCollector.toString();
    }
}
