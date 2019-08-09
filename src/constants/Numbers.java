package constants;

public enum Numbers {
    MIN_YEAR_CAR(1900),
    MAX_YEAR_CAR(2020),;


    private int number;

    public int getNumber(){
        return number;
    }

    Numbers(int number) {
        this.number = number;
    }
}
