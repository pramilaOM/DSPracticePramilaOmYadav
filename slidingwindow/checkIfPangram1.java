class checkIfPangram1 {
    public static boolean checkIfPangram(String sentence) {
        boolean[] b = new boolean[26];
        for (char c : sentence.toCharArray()) {
            b[c - 'a'] = true;
        }

        for(boolean bol : b){
            if(!bol){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));

    }

}