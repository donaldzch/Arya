package string.operation; 

class Defanging_an_IP_Address_1108 {

    class Solution {
        public String defangIPaddr(String address) {
            StringBuilder sb = new StringBuilder();
            char[] chars = address.toCharArray();
            for(int i = 0; i < chars.length; i++) {
                if (chars[i] == '.') {
                    sb.append("[.]");
                } else {
                    sb.append(chars[i]);
                }
            }
            return sb.toString();
        }
    }

}