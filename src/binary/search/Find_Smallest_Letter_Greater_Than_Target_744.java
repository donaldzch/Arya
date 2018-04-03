package binary.search;

public class Find_Smallest_Letter_Greater_Than_Target_744 {

    public char nextGreatestLetter(char[] letters, char target) {
        //hi starts at 'n' rather than the usual 'n - 1'.
        //It is because the terminal condition is 'lo < hi' and if hi starts from 'n - 1',
        //we can never consider value at index 'n - 1'
        int low = 0, high = letters.length;

        //Terminal condition is 'lo < hi', to avoid infinite loop when target is smaller than the first element
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (letters[middle] <= target)
                low = middle + 1;
            else
                high = middle;
        }

        //Because lo can end up pointing to index 'n', in which case we return the first element
        return letters[low % letters.length];
    }
}
