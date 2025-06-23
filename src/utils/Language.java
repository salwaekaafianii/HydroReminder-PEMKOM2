package utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
    private static ResourceBundle bundle;

    public static void setLanguage(String lang) {
        Locale locale = new Locale(lang);
        bundle = ResourceBundle.getBundle("locale.messages", locale);
    }

    public static String get(String key) {
        if (bundle == null) {
            setLanguage("en");
        }
        return bundle.getString(key);
    }
}
