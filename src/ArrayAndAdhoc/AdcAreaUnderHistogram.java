package ArrayAndAdhoc;

import java.util.Stack;

public class AdcAreaUnderHistogram {
    // The main function to find the maximum rectangular area under given
    // histogram with n bars
    static long getMaxArea(long hist[], int n)
    {
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> s = new Stack<>();

        long max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        long area_with_top; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i = 0;
        while (i < n)
        {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || hist[s.peek()] <= hist[i])
                s.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else
            {
                tp = s.peek();  // store the top index
                s.pop();  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!s.empty())
        {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;

    }
    static long findMaxPossibleArea1(long[] heights, int l, int r) {

        if (heights == null || heights.length == 0 || l > r || (r - l + 1) > heights.length ) {
            return 0;
        }
        int[] leftSmall = new int[heights.length];
        int[] rightSmall = new int[heights.length];

        leftSmall[l] = l-1;
        for (int i = l+1; i <= r; i++) {
            int p = i - 1;
            while (p >= l && heights[p] >= heights[i]) {
                p = leftSmall[p];
            }
            leftSmall[i] = p;
        }
        rightSmall[r] = r+1;
        for (int i = r-1; i >= l; i--) {
            int p = i + 1;
            while (p <= r && heights[p] >= heights[i]) {
                p = rightSmall[p];
            }
            rightSmall[i] = p;
        }

        long maxArea = 0;
        for (int i = l; i <= r; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightSmall[i] - leftSmall[i] - 1));
        }
        return maxArea;
    }

    static long findMaxPossibleArea(long[] heights) {
        long max_area =-1;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < heights.length){
            if(stack.empty()||heights[stack.peek()]<=heights[i]){
                stack.push(i++);
            }
            else{
                int top = stack.peek();
                stack.pop();
                max_area = Math.max(max_area, heights[top] * (stack.empty() ? i : i - stack.peek() - 1));
            }
        }
        while(!stack.empty()){
            int top = stack.peek();
            stack.pop();
            max_area = Math.max(max_area, heights[top] * (stack.empty() ? i : i - stack.peek() - 1));
        }
        return max_area;
    }

    // Driver program to test above function
    public static void main(String[] args)
    {
        long hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
        System.out.println("Maximum area is " + findMaxPossibleArea1(hist, 0,6));
        System.out.println("Maximum area is " + findMaxPossibleArea(hist));
    }
}
