import java.util.ListResourceBundle;

public class Questions_en extends ListResourceBundle {
    private Object[][] content = new Object[][] {
            {"Will Will Smith smith?", "Yes, Will Smith will smith."},
            {"What Does Marsellus Wallace Look Like?", "He's black."},
            {"How much is the fish?", "Sunshine in the air!"}
    };

    public Object[][] getContents() {
        return content;
    }
}
