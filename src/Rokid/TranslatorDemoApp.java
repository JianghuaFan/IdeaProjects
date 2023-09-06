package Rokid;

public class TranslatorDemoApp {
    public static String getYn(String input){
        return input.split("\\$")[0];
    }
    public static String getIn(String input){
        return input.split("\\$")[1];
    }

    public static void main(String[] args) {
        String scannedData = "CHÀO$Hai";
        // Process the input based on the selected language
        String processedOutput = "";
        System.out.println("Vietnamese: " + getYn(scannedData));
        System.out.println("Indonesian: " + getIn(scannedData));
    }
}
