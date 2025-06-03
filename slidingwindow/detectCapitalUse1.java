class detectCapitalUse1 {
    public static boolean detectCapitalUse(String word) {
        int uppercount = 0;

        for(char c : word.toCharArray()){
            if(Character.isUpperCase(c)){
                uppercount++;
            }
        }
        
        return uppercount == word.length() || uppercount == 0 || (uppercount ==1 && Character.isUpperCase(word.charAt(0)));

    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("FlaG"));

    }
}