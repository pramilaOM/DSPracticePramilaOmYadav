public class compress2 {

    public static int compress(char[] chars) {
        int i = 0;
        int j = 0;

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;
            while (i < chars.length && currentChar == chars[i]) {
                i++;
                count++;

            }

            chars[j++] = currentChar;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[j++] = c;
                }
            }

        }

        return j;
    }

    public static void main(String[] args) {
        char[] chars = { 'a','b','b','b','b','b','b','b','b','b','b','b','b' };

        System.out.print(compress(chars));
    }
}
