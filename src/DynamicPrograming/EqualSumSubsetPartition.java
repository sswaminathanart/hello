package DynamicPrograming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSumSubsetPartition {
    public static List<Boolean> equalSubSetSumPartition(List<Integer> s) {
        int sum = 0;
        for (int x : s) {
            sum += x;
        }
        if (sum % 2 != 0) {
            return Collections.emptyList();
        }
        Map<Integer, Integer> sumToIndex = createSumToIndexMapping(s);
        int halfSum = sum / 2;
        if (!sumToIndex.containsKey(halfSum)) {
            return Collections.emptyList();
        }
        Map<Integer, Integer> frequencies = new HashMap<>();
        int count = 0;
        while (count == 0 || halfSum != 0) {
            count++;
            int val = sumToIndex.get(halfSum);
            int freq = frequencies.getOrDefault(val, 0);
            frequencies.put(val, freq + 1);
            halfSum -= val;
        }
        if (count == s.size()) {
            return Collections.emptyList();
        }
        return createResult(s, frequencies);
    }

    private static Map<Integer, Integer> createSumToIndexMapping(List<Integer> s) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        for (int x : s) {
            Map<Integer, Integer> newSumToIndex = new HashMap<>();
            for (Integer key : sumToIndex.keySet()) {
                int newKey = x + key;
                if (!sumToIndex.containsKey(newKey)) {
                    newSumToIndex.put(newKey, x);
                }
            }
            sumToIndex.putAll(newSumToIndex);
            if (!sumToIndex.containsKey(x)) {
                sumToIndex.put(x, x);
            }
        }
        return sumToIndex;
    }

    private static List<Boolean> createResult(List<Integer> s, Map<Integer, Integer> frequencies) {
        List<Boolean> result = new ArrayList<>(s.size());
        for (Integer x : s) {
            Integer val = frequencies.get(x);
            if (val != null && val > 0) {
                result.add(true);
                frequencies.put(x, val - 1);
            } else {
                result.add(false);
            }
        }
        return result;
    }
    public static void main(String args[]) {
        List<Integer> s = new ArrayList<>();
        s.add(10);
        s.add(-3);
        s.add(7);
        s.add(3);
        s.add(2);
        s.add(1);
        List<Boolean> result = equalSubSetSumPartition(s);
        for(boolean b : result) {
            System.out.println(b);
        }
        List<Integer> s1 = new ArrayList<>();
        s1.add(1);
        s1.add(0);
        s1.add(-1);
        List<Boolean> result1 = equalSubSetSumPartition(s1);
        for(boolean b : result1) {
            System.out.println(b);
        }
    }
}
