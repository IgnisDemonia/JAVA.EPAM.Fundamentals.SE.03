import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class HtmlAnalyser {
    private StringBuilder sentencesWithRefsImg = new StringBuilder();
    private StringBuilder sequentialRefsImg = new StringBuilder();

    public StringBuilder getSentencesWithRefToImg() {
        return sentencesWithRefsImg;
    }

    public StringBuilder getSequentialRefsImg() {
        return sequentialRefsImg;
    }

    public boolean isRefsSequential() {
        String[] lines = sequentialRefsImg.toString().split("\n");
        for (int i = 0; i < lines.length; i++) {
            if ((lines[i].compareTo(lines[i + 1]) < 0)) {
                return true;
            }
        }
        return false;
    }

    public void analyse() {
        Pattern patternForSentences = Pattern.compile("<div>(.+[Рр]ис\\. \\d+.+)</div>");
        Pattern patternForRefs = Pattern.compile("([Рр]ис\\. \\d+)");
        String readedLine;
        Matcher matcher;

        String approachToFile = "C:\\Users\\Skobelsky\\Desktop\\Java.SE.03.Information handling_task_attachment.html";
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(approachToFile), "Windows-1251"))) {
            while ((readedLine = br.readLine()) != null) {
                matcher = patternForSentences.matcher(readedLine);
                if (matcher.matches()) {
                    sentencesWithRefsImg.append(matcher.group(1)).append("\n");
                    matcher = patternForRefs.matcher(readedLine);
                    while (matcher.find()) {
                        sequentialRefsImg.append(matcher.group(1)).append("\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
