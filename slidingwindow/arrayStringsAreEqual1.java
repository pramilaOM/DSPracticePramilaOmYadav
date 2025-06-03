class arrayStringsAreEqual1 {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = "";
        String s2 = "";
        for (String s : word1) {
            s1 += s;
        }
        for (String second : word2) {
            s2 += second;
        }
        if (s1.equals(s2)) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        String[] word1 = { "abc", "d", "defg" };
        String[] word2 = { "abcddefg" };
        System.out.print(arrayStringsAreEqual(word1, word2));

    }
}