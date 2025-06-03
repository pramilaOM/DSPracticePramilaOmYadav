class checkIfPangram2 {
    public static int isPanagram(String S) {
        boolean[] b = new boolean[26];
        for (char c : S.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                b[c - 'a'] = true;
            } else if (c >= 'A' && c <= 'Z') {
                b[c - 'A'] = true;
            }

        }

        for (boolean bol : b) {
            if (!bol) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        String sentence = "geeksFORgeeks";
        int result = isPanagram(sentence);
        System.out.println(result);

    }

}