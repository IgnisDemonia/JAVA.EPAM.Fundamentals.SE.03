import java.util.ListResourceBundle;

public class Questions_ru extends ListResourceBundle {
    private Object[][] content = new Object[][] {
            {"Будет ли Уилл Смит ковать?", "Да, Уил Смит будет ковать."},
            {"Как выглядит Марселлас Уолес?", "Он чёрный."},
            {"Почём рыбка?", "Солнечный свет повсюду!"}
    };

    public Object[][] getContents() {
        return content;
    }

}
