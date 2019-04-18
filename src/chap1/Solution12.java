package chap1;

public class Solution12 {
    public static void main(String[] args) {
        Solution12 a = new Solution12();
        System.out.println(a.intToRoman(9));
    }
    public String intToRoman(int num) {
        int t = num / 1000;
        String str = "";
        for (int i = 0; i < t; i++){
            str += "M";
        }
        num = num % 1000;
        t = num / 100;
        str += getStr1(t);
        num = num % 100;
        t = num / 10;
        str += getStr2(t);
        str += getStr(num % 10);

        return str;
    }

    private String getStr(int num){
        switch (num){
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
        }
        return "";
    }

    String getStr1(int num){
        switch (num){
            case 1:
                return "C";
            case 2:
                return "CC";
            case 3:
                return "CCC";
            case 4:
                return "CD";
            case 5:
                return "D";
            case 6:
                return "DC";
            case 7:
                return "DCC";
            case 8:
                return "DCCC";
            case 9:
                return "CM";
        }
        return "";
    }

   String getStr2(int num){
        switch (num){
            case 1:
                return "X";
            case 2:
                return "XX";
            case 3:
                return "XXX";
            case 4:
                return "XL";
            case 5:
                return "L";
            case 6:
                return "LX";
            case 7:
                return "LXX";
            case 8:
                return "LXXX";
            case 9:
                return "XC";
        }
        return "";
   }
}
