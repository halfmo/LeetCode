public class isPalindromeS {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber){
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x==revertedNumber /10;
//        String str = Integer.toString(x);
//        String str1 = "";
//        for (int i = str.length()-1; i >= 0; i--){
//            str1+=str.charAt(i);
//        }
//        if (str1.equals(str)){
//            return true;
//        }
//        return false;
    }
}
