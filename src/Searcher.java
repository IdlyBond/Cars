import constants.Fields;
import constants.Lines;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Searcher {

    private Map<String, Car> out = new HashMap<>();
    private Map<String, Car> map;

    public Searcher(Map<String, Car> map) {
        this.map = map;
    }

    public Map<String, Car> find(final String var, Fields type){
        if(Objects.isNull(map) || Objects.isNull(type) || Objects.isNull(var)) return Collections.emptyMap();
        switch (type){
            case VIN_CODE: return searchVin(var);
            case REG_NUM: return searchReg(var);
            case MODEL: return searchModel(var);
            default: return Collections.emptyMap();
        }
    }

    public Map<String, Car> find(final Integer from, final Integer to, Fields type){
        if(Objects.isNull(map) || Objects.isNull(type) || Objects.isNull(from) || Objects.isNull(to)) return Collections.emptyMap();
        switch (type){
            case PRICE: return searchPrice(from, to);
            case PATH: return searchPath(from, to);
            case YEAR: return searchYear(from, to);
            default: return Collections.emptyMap();
        }
    }

    private Map<String, Car> searchVin(String var){
        map.forEach((s, car) -> { if(var.equals(car.getVinCode())){ out.put(car.getVinCode(), car); }});
        return out.isEmpty()? Collections.emptyMap(): out;
    }

    private Map<String, Car> searchReg(String var){
        map.forEach((s, car) -> { if(var.equals(car.getRegNumber())){ out.put(car.getVinCode(), car); }});
        return out.isEmpty()? Collections.emptyMap(): out;
    }

    private Map<String, Car> searchModel(String var){
        map.forEach((s, car) -> { if(var.equals(car.getModel())){ out.put(car.getModel(), car); }});
        return out.isEmpty()? Collections.emptyMap(): out;
    }

    private Map<String, Car> searchPrice(Integer from, Integer to){
        map.forEach((s, car) -> { if(car.getPrice() >= from && car.getPrice() <= to){ out.put(car.getVinCode(), car); }});
        return out.isEmpty()? Collections.emptyMap(): out;
    }

    private Map<String, Car> searchPath(Integer from, Integer to){
        map.forEach((s, car) -> { if(car.getPath() >= from && car.getPath() <= to){ out.put(car.getVinCode(), car); }});
        return out.isEmpty()? Collections.emptyMap(): out;
    }

    private Map<String, Car> searchYear(Integer from, Integer to){
        map.forEach((s, car) -> { if(car.getYear() >= from && car.getYear() <= to){ out.put(car.getVinCode(), car); }});
        return out.isEmpty()? Collections.emptyMap(): out;
    }
}
