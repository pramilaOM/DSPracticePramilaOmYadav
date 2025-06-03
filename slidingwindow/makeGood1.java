class makeGood1 {
    public static String makeGood(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            int len = result.length();
            if (len > 0 && Math.abs(result.charAt(len - 1) - c) == 32) {
                result.deleteCharAt(len - 1);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

    }

}