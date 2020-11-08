package sort;

import java.util.*;

public class SortByBits {
   static public int[] sortByBits(int[] arr) {
        if(arr.length == 0) {
            return new int[0];
        }

        List<Integer> resultInt = new LinkedList<Integer>();
        HashMap<Integer, LinkedList<Integer>> hashMap = new HashMap<Integer, LinkedList<Integer>>();
        List<Integer> sortList = new LinkedList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int num = 0;
            while (temp != 0) {
                num += temp%2;
                temp /= 2;
            }
            LinkedList<Integer> list = hashMap.get(num);
            if (list == null) {
                list = new LinkedList<Integer>();
                hashMap.put(num, list);
                sortList.add(num);
            }
            list.add(arr[i]);
        }
        Collections.sort(sortList);
        for (Integer tempInt : sortList) {
            List<Integer> list = hashMap.get(tempInt);
            Collections.sort(list);
            resultInt.addAll(list);
        }
        int[] numResult = new int[resultInt.size()];
        for (int i = 0; i < resultInt.size(); i++) {
            numResult[i] = resultInt.get(i);
        }
        return numResult;
    }

    public static void main(String[] args) {
        int[] tempList=  new int[]{0,1,2,3,4,5,6,7,8};
        sortByBits(tempList);
    }
}
