import java.util.*;


public class Mapping {
	
    public String fromTurkish(String translate, List<String> lines) {
        Map<String, String[]> TRdictionary = new HashMap<>();
        lines.forEach(line -> {
            String[] words = line.split("/"); 
            String word = words[0]; 
            String[] request = word.split(","); 
            for (int i = 0; i < request.length; i++) {
                request[i] = request[i].trim();
            }
            String[] translations = words[1].split(",");

            for(String s : request){ 
                if (TRdictionary.containsKey(s)) {
                    String[] existingTranslations = TRdictionary.get(s); 
                    String[] newTranslations = new String[existingTranslations.length + translations.length];
                    System.arraycopy(existingTranslations, 0, newTranslations, 0, existingTranslations.length); 
                    System.arraycopy(translations, 0, newTranslations, existingTranslations.length, translations.length);
                    TRdictionary.put(s, newTranslations);
                } else {
                    TRdictionary.put(s, translations);
                }
            }
        });
        String[] translationsList = TRdictionary.getOrDefault(translate, new String[0]);
        String translations = String.join(",", translationsList);

        return translations;
    }

    public String fromEnglish(String translate, List<String> lines) {
        Map<String, String[]> ENGdictionary = new HashMap<>();
        lines.forEach(line -> {
            String[] words = line.split("/");
            String[] translations = words[1].split(",");
            String word = words[0]; 
            if (ENGdictionary.containsKey(word)) {
                String[] existingTranslations = ENGdictionary.get(word);
                String[] newTranslations = new String[existingTranslations.length + translations.length];
                System.arraycopy(existingTranslations, 0, newTranslations, 0, existingTranslations.length);
                System.arraycopy(translations, 0, newTranslations, existingTranslations.length, translations.length);
                ENGdictionary.put(word, newTranslations);
            } else {
                ENGdictionary.put(word, translations);
            }

        });
        String[] translationsList = ENGdictionary.getOrDefault(translate, new String[0]);
        String translations = String.join(",", translationsList);
        return translations;
    }
}