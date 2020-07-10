package com.vivekasu;

public class AddBinary {

    public String addBinary(String a, String b) {

        int alen = a.length()-1;
        int blen = b.length()-1;
        int carry = 0, sum = 0;
        StringBuilder ans = new StringBuilder();

        while(alen>=0 || blen>=0){

            sum=carry;
            if(alen>=0)
                sum+=a.charAt(alen)-'0';
            if(blen>=0)
                sum+=b.charAt(blen)-'0';

            ans.append(sum%2);
            carry = sum/2;
            alen--;
            blen--;
        }

        if(carry>0)
            ans.append(carry);

        return ans.reverse().toString();

    }

}
