public class ReverseStrS {
    public String reverseStr(String s, int k) {
        StringBuffer res = new StringBuffer();
        int length = s.length();
        int start = 0;
        while (start<length){
            StringBuffer temp = new StringBuffer();
            int firstk = (start+k >length)? length: start+k;
            int secondk = (start+(2*k) > length) ? length:start+(2*k);
            temp.append(s.substring(start,firstk));
            res.append(temp.reverse());
            if(firstk<secondk){
                res.append(s.substring(firstk,secondk));
            }
            start+=(2*k);

        }
        return res.toString();
    }
}
