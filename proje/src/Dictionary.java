import java.io.IOException;
import java.util.List;
import java.util.Scanner;
public class Dictionary {

    private final String turkish = "assets/tureng.txt";
    public String english = "assets/engtur.txt";

    public void deneme() throws IOException {

        Mapping mapping = new Mapping();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            List<String> getTurkishWords = FileApplications.file.readFile(turkish);
            List<String> getEnglishWords = FileApplications.file.readFile(english);
            System.out.println("Kullanmak istediğiniz sözlük için aşağıdaki seçeneklerden devam ediniz:");
            System.out.println("1 - Türkçe-İngilizce çeviri yap");
            System.out.println("2 - İngilizce-Türkçe çeviri yap");
            System.out.println("3 - Yeni Kelime Ekle");
            System.out.println("0 - Çıkış yap");

            int choice = scanner.nextInt();
            scanner.nextLine();

                 if (choice == 1) {
                     while (true) {
                         System.out.println("#### Türkçe-İngilizce Sözlük ####");
                         System.out.print("Kelime : ");
                         String turkishWord = scanner.nextLine();
                         String english = mapping.fromTurkish(turkishWord,getTurkishWords);
                         if (turkishWord.equals("0")) {
                             break;
                         } else if (english != null) {
                             System.out.println("İngilizce Karşılığı : " + english);
                         } else {
                             System.out.println("Kelime bulunamadı.");
                         }
                     }
                 } 
                 else if (choice == 2) {
                     while (true) {
                         System.out.println("#### İngilizce-Türkçe Sözlük ####");
                         System.out.print("Kelime : ");
                         String englishWord = scanner.nextLine();
                         String turkish = mapping.fromEnglish(englishWord,getEnglishWords);
                         if (englishWord.equals("0")) {
                             break;
                         }
                         else if (turkish != null){
                             System.out.println("Türkçe Karşılığı : " + turkish);
                         }else {
                             System.out.println("Kelime bulunamadı.");
                         }
                     }
                 }
                 else if (choice == 3) {
                     while (true) {
                         System.out.println("#### Yeni Kelime Ekle ####");
                         System.out.print("Eklemek istediğiniz kelime türkçe ise 1'e ingilizce ise 2'ye, menüden çıkmak için ise 0'a basınız... ");
                         int newChoice = scanner.nextInt();
                         scanner.nextLine();                         
                         if(newChoice==1){
                             System.out.print("Eklemek istediğiniz türkçe kelime:");
                             String trWord = scanner.nextLine();
                             System.out.print("Eklemek istediğiniz kelimenin ingilizce karşılığı:");
                             String trEngWord = scanner.nextLine();
                             FileApplications.file.addNewWord('\n'+trWord+"/"+trEngWord,turkish);
                             System.out.println(trWord+" sözlüğe eklendi.");
                         } 
                         else if(newChoice==2){
                             System.out.print("Eklemek istediğiniz ingilizce kelime:");
                             String engWord = scanner.nextLine();
                             System.out.print("Eklemek istediğiniz kelimenin türkçe karşılığı:");
                             String engTWord = scanner.nextLine();
                             FileApplications.file.addNewWord('\n'+engWord+'/'+engTWord, english);
                             System.out.println(engWord+" sözlüğe eklendi.");
                         } 
                         else if(newChoice==0){
                             break;
                         } else{
                             System.out.println("Geçersiz bir tuşa basıldı.");
                         }}
                 }
                 else if (choice == 0) {
                     break;
                 }else{
                     System.out.println("Geçersiz bir tuşa basıldı.");
                 }
             }
            scanner.close();
        }
    }