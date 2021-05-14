import java.util.HashMap;
import java.util.Map;

public class Rim {
    private Map<String, Integer> mapRim = new HashMap<>();
    private Map<Integer, String> mapArab = new HashMap<>();

    private String[] rim = new String[]{"I", "V", "X", "L", "C"};
    private int[] arab = new int[]{1, 5, 10, 50, 100};

    public Rim() {
        for (int i = 0; i < rim.length; i++) {
            mapRim.put(rim[i], arab[i]);
            mapArab.put(arab[i], rim[i]);
        }
    }

    public int rimInArab(String s) {
        if (s.length() == 1) {
            return mapRim.get(s);
        } else {
            String[] arr = s.split("");
            int[] arrInt = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                arrInt[i] = mapRim.get(arr[i]);
            }
            if (arrInt[0] < arrInt[1]) {
                if (arrInt.length > 2) {
                    int result = arrInt[1] - arrInt[0];
                    for (int i = 2; i < arrInt.length; i++) {
                        result = +arrInt[i];
                    }
                    return result;
                } else {
                    return arrInt[1] - arrInt[0];
                }
            } else {
                int result = 0;
                for (int i : arrInt) {
                    result += i;
                }
                return result;
            }
        }
    }

    public String arabInRim(Integer n) {
        if (mapArab.containsKey(n)) {
            return mapArab.get(n);
        }
        StringBuilder sb = new StringBuilder();
        String[] arr = n.toString().split("");
        if (arr.length > 1) {
            sb.append(symbolReturn(Integer.parseInt(arr[0]) * 10));
            sb.append(symbolReturn(Integer.parseInt(arr[1])));
            return sb.toString();
        } else {
            return symbolReturn(n);
        }

    }

    private String symbolReturn(Integer n) {
        StringBuilder sb = new StringBuilder();
        if (mapArab.containsKey(n)) {
            return mapArab.get(n);
        }
        if (n == 0) {
            return "";
        } else if (n < 5) {
            if (n == 4) {
                return "IV";
            } else {
                for (int i = 0; i < n; i++) {
                    sb.append("I");
                }
                return sb.toString();
            }
        } else if (n < 10) {
            if (n == 9) {
                return "IX";
            } else {
                sb.append("V");
                for (int i = 5; i < n; i++) {
                    sb.append("I");
                }
                return sb.toString();
            }
        } else if (n < 40) {
            for (int i = 0; i < n / 10; i++) {
                sb.append("X");
            }
            return sb.toString();
        } else if (n == 40) {
            return "XL";
        } else if (n < 90) {
            sb.append("L");
            for (int i = 5; i < n / 10; i++) {
                sb.append("X");
            }
            return sb.toString();
        } else {
            return "XC";
        }
    }

}
