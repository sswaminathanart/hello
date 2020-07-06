package StringExamples;

public class ReverseOrderingOfWords {
    static String reverse_ordering_of_words(String s) {
        /*
         * Write your code here.
         */
        char[] charArr = s.toCharArray();
        reverse(charArr, 0, charArr.length - 1);

        int i = 0;
        int st, end;
        while (true) {

            while (i < charArr.length && charArr[i] == ' ') {
                i++;
            }
            st = i;
            while (i < charArr.length && charArr[i] != ' ') {
                i++;
            }
            end = i - 1;
            if (end > st) {
                reverse(charArr, st, end);
            }
            if (i >= charArr.length) {
                break;
            }
        }
        return new String(charArr);
    }

    static void reverse(char[] charArr, int left, int right) {
        char tmp;
        while (left < right) {
            tmp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = tmp;
            left++;
            right--;
        }
    }
    public static void main(String args[]) {
        System.out.println(reverse_ordering_of_words(" I will do it."));
    }

}
