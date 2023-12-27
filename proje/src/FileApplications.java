import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class FileApplications {
    public static FileApplications file = new FileApplications();
    public List<String> readFile(String fileName) {
        List<String> words = new ArrayList<>();
        try {
            words = Files.lines(Paths.get(fileName))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Dosya bulunamadı: " + fileName);
        }
        return words;
    }

    public void addNewWord(String newWord, String fileName) throws IOException{
        FileWriter file = new FileWriter(fileName, true);
        BufferedWriter output = new BufferedWriter(file);
        output.write(newWord);
        output.close();
    }
}