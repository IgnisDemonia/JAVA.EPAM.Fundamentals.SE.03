import java.util.*;

public class Launcher {
    private static ResourceBundle r;
    public static void main(String[] args) {
        r = ResourceBundle.getBundle("Questions", new Locale("ru"));
        printNumbersOfQuestions();

        System.out.println(r.getString(getKeyByIndex(2)));

    }

    private static String getKeyByIndex(int index) {
        List<String> keysList= new ArrayList<>(r.keySet());
        return keysList.get(index);
    }

    private static void printNumbersOfQuestions(){
        int position = 0;
        for (String key : r.keySet()) {
            System.out.printf("%d. %s\n", position++, key);
        }
    }
}
