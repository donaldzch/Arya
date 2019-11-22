package greedy;

class Lemonade_Change_860 {
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int five = 0, ten = 0;

            for (int bill : bills) {
                if (bill == 5) {
                    five++;
                }
                if (bill == 10) {
                    five--; 
                    ten++;
                }
                if (bill == 20) {
                    if (ten > 0) {
                        ten--;
                        five--;
                    } else {
                        five -= 3;
                    }
                }
                if (five < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}