package ArrayAndAdhoc;

public class LongestMountain {
    static int longestMountain(int[] a) {
        int incr = -1,
                decr = -1,
                mountSize = 0;

        // If the size of array is less
        // than 3, the array won't show
        // mountain like behaviour
        if (a.length < 3) {
            return 0;
        }

        for (int index = 0; index < a.length - 1; index++) {

            if (a[index + 1] > a[index]) {

                // When a new mountain sub-array
                // is found, there is a need to
                // set the variables decr, incr to -1
                // in order to help calculate the
                // length of new mountain sub-array
                if (decr != -1) {
                    decr = -1;
                    incr = -1;
                }

                // incr marks the starting index of a
                // new mountain sub-array. So set the
                // value of incr to current index i.
                if (incr == -1) {
                    incr = index;
                }
            }
            else {

                // Checks if next element is
                // less than current element
                if (a[index + 1] < a[index]) {

                    // Checks if starting element exists
                    // or not, if the starting element
                    // of the mountain sub-array exists
                    // then the index of ending element
                    // is stored in decr
                    if (incr != -1) {
                        decr = index + 1;
                    }

                    // This condition checks if both
                    // starting index and ending index
                    // exists or not, if yes, the
                    // length is calculated.
                    if (decr != -1 && incr != -1) {

                        // mountSize holds the lenght of the
                        // longest mountain sub-array.
                        // If the current length is
                        // greater than the
                        // calculated length, then
                        // value of d is updated.
                        if (mountSize < decr - incr + 1) {
                            mountSize = decr - incr + 1;
                        }
                    }
                }

                // ignore if there is no
                // increase or decrease in
                // the value of the next element
                else {
                    decr = -1;
                    incr = -1;
                }
            }
        }

        // Checks and calculates
        // the length if last element
        // of the array is the last
        // element of a mountain sub-array
        if (decr != -1 && incr != -1) {
            if (mountSize < decr - incr + 1) {
                mountSize = decr - incr + 1;
            }
        }
        return mountSize;
    }
    public static void main(String args[]) {
        int[]  d = { 1, 3, 1, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5 };
        System.out.println(longestMountain(d));
    }
}
