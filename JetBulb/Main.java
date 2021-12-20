package JetBulb;

public class Main {
    public static void main(String[] args) {
        NotationConverter converter = new NotationConverter();
        try {
            System.out.println("result: " + converter.toArabic("XVIII"));
        } catch (InvalidValueException e){
            e.printStackTrace();
        }
    }
}
