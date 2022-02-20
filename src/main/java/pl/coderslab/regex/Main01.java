package pl.coderslab.regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main01 {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("\\w+@\\w+\\.[a-z]{2,3}");

    public static void main(String[] args) {
        String badEmail = "123@123";
        String goodEmail = "abc@abc.pl";

        System.out.println("verifyEmail1(badEmail) = " + verifyEmail1(badEmail));
        System.out.println("verifyEmail1(goodEmail) = " + verifyEmail1(goodEmail));

        System.out.println("verifyEmail2(badEmail) = " + verifyEmail2(badEmail));
        System.out.println("verifyEmail2(goodEmail) = " + verifyEmail2(goodEmail));

        System.out.println("verifyEmail3(badEmail) = " + verifyEmail3(badEmail));
        System.out.println("verifyEmail3(goodEmail) = " + verifyEmail3(goodEmail));

        System.out.println("verifyEmail4(badEmail) = " + verifyEmail4(badEmail));
        System.out.println("verifyEmail4(goodEmail) = " + verifyEmail4(goodEmail));
    }

    public static boolean verifyEmail1(String text) {
        return text.matches("\\w+@\\w+\\.[a-z]{2,3}");
    }

    public static boolean verifyEmail2(String text) {
        return Pattern.matches("\\w+@\\w+\\.[a-z]{2,3}", text);
    }

    public static boolean verifyEmail3(String text) {
        Pattern emailPattern = Pattern.compile("\\w+@\\w+\\.[a-z]{2,3}");
        Matcher matcher = emailPattern.matcher(text);
        return matcher.matches();
    }

    public static boolean verifyEmail4(String text) {
        Matcher matcher = EMAIL_PATTERN.matcher(text);
        return matcher.matches();
    }


}
