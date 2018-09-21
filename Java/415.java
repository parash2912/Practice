class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.isEmpty()) {
            return num2;
        }
        if(num2 == null || num2.isEmpty()) {
            return num1;
        }
        int off = 1;
        int carry = 0;
        StringBuilder ret = new StringBuilder();
        while(off <= num1.length() || off <= num2.length()){
            int curr = 0;
            try{
                if(off > num1.length()) {
                    if(carry != 0) {
                        int dig = Integer.parseInt(""+num2.charAt(num2.length() - off));
                        curr = dig + carry;
                    } else {
                        ret.insert(0,num2.substring(0,num2.length() - off + 1));
                        return ret.toString();
                    }
                } else if(off > num2.length()) {
                    if(carry != 0) {
                        int dig = Integer.parseInt(""+num1.charAt(num1.length() - off));
                        curr = dig + carry;    
                    } else {
                        ret.insert(0,num1.substring(0,num1.length() - off + 1));
                        return ret.toString();
                    }
                } else {
                    int dig1 = Integer.parseInt(""+num1.charAt(num1.length() - off));
                    int dig2 = Integer.parseInt(""+num2.charAt(num2.length() - off));
                    curr = dig1 + dig2 + carry;
                }
            } catch(NumberFormatException e) {
                return ""+0;
            }
            carry = curr/10;
            curr = curr%10;
            ret.insert(0,Integer.toString(curr));
            off++;
        }
        if(carry != 0) {
            ret.insert(0,Integer.toString(carry));
        }
        return ret.toString();
    }
}
