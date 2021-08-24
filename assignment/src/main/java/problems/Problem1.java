package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Takes a list and finds pairs that sum up to k.
 */
public class Problem1 {
    public int findSums(int k, int[] arr) {
        HashMap<Integer,Integer> complements = new HashMap<>();
        int complement;
        int complement_count;
        int res = 0;

        for (int i : arr) {
            complement = k - i;
            complement_count = complements.getOrDefault(complement, 0);
            res += complement_count;
            complements.merge(i, 1, Integer::sum);
        }

        return res;
    }

    public static void main(String[] args) {
        Problem1 p1 = new Problem1();
        Scanner scn = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        int k = scn.nextInt();
        while(scn.hasNext()){
            arr.add(scn.nextInt());
        }

        int[] array = new int[arr.size()]; //Convert arrayList to primitive array
        for(int i = 0; i<arr.size(); i++) array[i] = arr.get(i);
        System.out.println(p1.findSums(k, array));
    }
}
