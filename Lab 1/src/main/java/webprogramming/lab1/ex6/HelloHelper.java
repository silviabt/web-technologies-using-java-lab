package webprogramming.lab1.ex6;

import java.util.Locale;

public class HelloHelper {

    public String getGreeting(Locale locale) {
        String languageTag = locale.toLanguageTag().substring(0,2);

        String greeting;
        switch (languageTag) {
            case "fr":
                greeting = "Bonjour";
                break;
            case "en":
                greeting = "Hello";
                break;
            default:
                greeting = "Buna";
        }

        return greeting;
    }
}
