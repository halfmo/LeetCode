public class ReverseWordsS {
    public String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb,0,sb.length()-1);
        reverseEachWords(sb);
        return sb.toString();
    }
    private StringBuilder removeSpace(String s){//去除多余空格
        int start=0;
        int end = s.length()-1;
        while(s.charAt(start)==' ')start++;
        while(s.charAt(end)==' ')end--;
        StringBuilder sb = new StringBuilder();
        while(start<=end){
            char ca=s.charAt(start);
            if(ca!=' '||sb.charAt(sb.length()-1)!=' '){
                sb.append(ca);
            }
            start++;
        }
        return sb;
    }
    /*
    翻转整个句子
     */
    private void reverseString(StringBuilder sb,int start,int end){
        while(start < end){
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }
    /*
    翻转每个单词
     */
    private void reverseEachWords(StringBuilder sb){
        int start =0;
        int end=1;
        int n = sb.length();
        while(start<n){
            while(end<n&&sb.charAt(end)!=' '){
                end++;
            }
            reverseString(sb,start,end-1);
            start=end+1;
            end=start+1;
        }
    }
}
