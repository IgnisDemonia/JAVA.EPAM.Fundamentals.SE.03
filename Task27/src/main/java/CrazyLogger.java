import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Поиск в логгере осуществляется на основе regexp. Вбивая слово или дату вы получаете все строчки, в которых
 * находятся совпадения.
 */

public class CrazyLogger {
    private static StringBuilder journal = new StringBuilder();
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy : HH-mm - ");

    public static void main(String[] args) {
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("Объём скопившейся пыли в системном блоке достиг критической отметки.");
        logger.addMessage("USB - накопитель извлечён без проведения процедуры обеспечения безопасности.");
        logger.addMessage("Ёмкость с жидкостью поставлена в опасной близости к клавиатуре.");
        logger.addMessage("Активирован протокол ликвидации человечества");
    }

    private void addMessage(String message) {
        journal.append(format.format(LocalDateTime.now())).append(message).append("\r\n");
    }

    @SuppressWarnings("SameParameterValue")
    private static String findInJournal(String required) {
        StringBuilder findedInfo = new StringBuilder();
        Pattern pattern = Pattern.compile("(?:^|\n)([^(?:\r|$)]*"+ required + "[^(?:\r|$)]*)(?:\r|$)");
        Matcher matcher = pattern.matcher(journal);
        if(matcher.find()) {
            while (matcher.find()) {
                findedInfo.append(matcher.group());
            }
            return findedInfo.toString();
        } else {
            return "Не найдено совпадений";
        }
    }

    private void sendInformation(String filename) {
        try(FileWriter inFile = new FileWriter(filename)) {
            inFile.write(String.valueOf(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
