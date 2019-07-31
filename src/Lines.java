public enum Lines {
    NON_CORRECT("* Некорректный ввод. "),
    CHOOSE_LINE ("* Выберите один из пунктов меню:"),
    MAIN_OPTIONS_LINE ("1 - Меню поиска.\n" +
            "2 - Занести в базу данные по новой машине.\n" +
            "3 - Редактирование информации о машине по VIN коду\n" +
            "4 - Удалить машину с базы по VIN коду.\n" +
            "0 - Назад\n" +
            "-1 - Выход из программы."),
    SEARCH_OPTIONS_LINE(" 1 - Поиск по VIN коду машины.\n" +
            " 2 - Поиск по регистрационному номеру машины\n" +
            " 7 - Отобразить список всех машин \n" +
            " 0 - назад."),
    ENTER_VIN_CODE("* Введите VIN код: "),
    ENTER_REG_NUMBER("* Введите регестрационный код: "),
    DEFAULT_VIN_1("HCBUZTH63KLC859BZ"),
    DEFAULT_VIN_2("5CBU54ZTH63KLC855"),
    DEFAULT_VIN_3("MZBU4GBC3KLC859BZ"),
    DEFAULT_VIN_4("BZ5643GBC3KLC59BZ"),
    DEFAULT_REG_NUM_1("AB4654CV"),
    DEFAULT_REG_NUM_2("AC4644BF"),
    DEFAULT_REG_NUM_3("BY5684BF"),
    DEFAULT_REG_NUM_4("CC5674BF"),
    NO_CARS_FOUND("* В базе не существует такой машины. "),
    FOUND_CAR("* Машина была найдена: "),
    ZERO_TO_EXIT("* Для возврата в предыдущее меню введите цифру 0. ")
    ;

    private String line;

    Lines(String line) {
        this.line = line;
    }

    String getLine(){
        return line;
    }

    @Override
    public String toString() {
        return line;
    }
}
