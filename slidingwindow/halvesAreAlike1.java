import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class halvesAreAlike1 {
    public static boolean halvesAreAlike(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            if(isVowel(s.charAt(i))) count++;
            if(isVowel(s.charAt(i+n/2))) count--;
        }
        return count == 0;

    }

    static Set<Character> allVowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static boolean isVowel(char c) {

        return allVowel.contains(c);

    }

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("textbook"));
        System.out.println(halvesAreAlike("book"));
    }
}