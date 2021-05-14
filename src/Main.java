import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Rim rim = new Rim();
        Scanner scanner = new Scanner(System.in);
        String input;
        String regArab = "^1(0)|[1-9]";
        String regRim = "^I{1,3}|^I(X|V)|^X|^V(I){0,3}";

        while (true) {
            input = scanner.nextLine();
            String[] arr = input.split(" ");
            if (arr[0].matches(regArab) && arr[2].matches(regArab)) {
                System.out.println(calcArab(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2])));
            } else if (arr[0].matches(regRim) && arr[2].matches(regRim)) {
                int i = rim.rimInArab(arr[0]);
                int j = rim.rimInArab(arr[2]);
                System.out.println(rim.arabInRim(calcArab(i, arr[1], j)));
            } else {
                throw new IOException("Число не из диапозана");
            }

        }
    }


    private static int calcArab(int i, String act, int j) {
        int result = 0;
        switch (act) {
            case "+":
                result = i + j;
                break;
            case "-":
                result = i - j;
                break;
            case "*":
                result = i * j;
                break;
            case "/":
                result = i / j;
                break;
        }
        return result;
    }
}
