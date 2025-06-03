import java.util.ArrayList;
import java.util.Collections;

public class Factorialsoflargenumbers {
    public static ArrayList<Integer> factorial(int n) {
        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.add(1);

        for (int i = 2; i <= n; i++) {
            calculatefact(resultList, i);
        }
        Collections.reverse(resultList);
        return resultList;

    }

    public static void calculatefact(ArrayList<Integer> n, int p) {

        int carry = 0;
        for (int i = 0; i < n.size(); i++) {
            int digit = n.get(i) * p + carry;
            n.set(i, digit % 10);
            carry = digit / 10;
        }
        while (carry > 0) {
            n.add(carry % 10);
            carry = carry / 10;
        }

    }

    public static void main(String[] args) {
        int nums = 10;
        ArrayList<Integer> output = factorial(nums);
        System.out.println(output);

    }

}
