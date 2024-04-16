package org.example.dsa;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayMain {

    public ArrayMain() throws URISyntaxException {
    }

    public static void main(String[] args) {
        System.out.println("TYY");




    }


    // System.out.println(findFrequency(new int[]{10,10,10,23,23,4,5}));
    // need linear time
    // find frequency in sorted array
    private static Map<Integer, Integer> findFrequency(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();

          if(arr.length>0){
              int frequency = 1; int element = arr[0];
              for(int i=1; i<arr.length; i++){
                  if(arr[i]==element){
                      frequency++;
                  }else{
                      map.put(element, frequency);
                      element = arr[i];
                      frequency = 1;
                  }
              }
          }

        return map;
    }

    // System.out.println(findMaximumDifference(new int[]{2,3,10,6,4,8,1})); --> 8
    // Maximum difference in a array between two elements such that j>i
    private static int findMaximumDifference(int[] arr){
        int max = -1;
        if(arr.length>1){
            max = arr[1]-arr[0];
            for(int i=0; i<arr.length; i++){

                for(int j=i+1; j<arr.length; j++){
                    if(arr[j]-arr[i]>max){
                        max = arr[j]-arr[i];
                    }
                }
            }
        }
        return max;
    }


    // Elements to right should be small, then that element is leader.
    // System.out.println(findLeaderInArray(new int[]{1,3,40,22,3,10,6,5,2,3}));
    private static ArrayList<Integer> findLeaderInArray(int[] arr){
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean flag;
        for(int i=0; i<arr.length; i++){
            flag = false;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]>=arr[i]){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                arrayList.add(arr[i]);
            }
        }

        return arrayList;
    }


    /*
    DYNAMIC PRIMITIVE ARRAY
    -----------------------
        int[] arr = new int[]{};
        //arr[0] = 1; // Exception
        System.out.println(arr.length); 0
    System.out.println(arr[2]); // Exception

     */


    /*
    DEFAULT VALUES TO PRIMITIVE ARRAY
    ---------------------------------
    int[] arr = new int[5];
        arr[0] = 1; // arr.length = 5
        System.out.println(arr[2]); // 0

     */

    /*
    StackTraceElement[] stackTraceElems = Thread.currentThread().getStackTrace();
        for (int i=0; i<stackTraceElems.length; i++){
            System.out.println(stackTraceElems[i]+"--------"+i);
        }

    java.base/java.lang.Thread.getStackTrace(Thread.java:1619)--------0
    org.example.dsa.ArrayMain.main(ArrayMain.java:17)--------1
     */

    /*
    SOLUTION 2:   (BETTER THAN 1)

    int d=2;
        int N=5;
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(reverseArray(arr, 0, d-1)));
        System.out.println(Arrays.toString(reverseArray(arr, d, N-1)));
        System.out.println(Arrays.toString(reverseArray(arr, 0, N-1)));
     */

    // System.out.println(Arrays.toString(leftRotateDTimes(new int[]{1,2, 3, 4, 5}, 8)));
    /*
    If 'd' is greater than 'N', then 'd-N'
     */
    private static int[] leftRotateDTimes(int[] arr, int d){
        int N = arr.length;
        if(N>1 && d>0 && N!=d){
            if (d>N){
                d = d-N;
            }
            for(int i=0; i<d; i++){
                leftRotateArraysByOne(arr);
            }
        }
        return arr;
    }

    // System.out.println(Arrays.toString(leftRotateArraysByOne(new int[]{1,2, 3, 4, 5})));
    private static int[] leftRotateArraysByOne(int[] arr){
        /*
        1. Make temp = first element ---> arr[0]
        2. In loop from 1 to <N, move element to previous position ---> arr[0] = arr[1], arr[1] = arr[2], ... arr[i-1] = arr[i]
        3. After loop, assign last element = temp -->
         */
        int N = arr.length;
        if(N>1){
            int temp = arr[0];
            for(int i=1; i<N; i++){
                arr[i-1] = arr[i];
            }
            arr[N-1] = temp;
        }
        return arr;
    }

    /*
    maintain 'count' of non-zero elements.
    if a[0] is non-zero, count = 1;
    if a[1] is non-zero, count = 2;
    if a[2] is zero,
    if a[3] is non-zero, swap temp=a[count]; a[count]=a[3]; a[3]=temp; count = 3;
     */
    //moveZerosToEnd(new int[]{0, 10,0,01,12,0, 12});
    private static int[] moveZerosToEnd(int[] arr){
        int size = arr.length;
        if(size>0) {
            int count = 0;
            int temp;
            for (int i = 0; i < size; i++) {
                if(arr[i]!=0){
                    if(i!=(count-1)){
                        // swap
                        temp = arr[count];
                        arr[count] = arr[i];
                        arr[i] = temp;
                    }
                    count++;
                }
            }
            for(int i=0; i<size; i++){
                System.out.print(arr[i]+" ");
            }
        }
        return arr;
    }

    // removeDuplicates(new int[]{});
    private static int[] removeDuplicates(int[] arr){
        int size = arr.length;
        int res = 1;
        if(size>0){
            for(int i=1; i<size; i++){
                if(arr[i]!=arr[res-1]){
                    arr[res] = arr[i];
                    res++;
                }
            }
            for(int i=0; i<res; i++){
                System.out.print(arr[i]+" ");
            }
        }
        return arr;
    }

    URI uri = new URI("sdfsdf");

    private static int[] reverseArray(int[] arr, int low, int high){
        int temp;
        while(low<high){
            temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return arr;
    }

    // reverseArray(new int[]{10,4,2,10, 15});
    private static int[] reverseArray(int[] arr){
        int size = arr.length;
        if(size>1) {
            int low = 0;
            int high = size-1;
            int temp;
            while(low<high){
                temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
        return arr;
    }

    // System.out.println(getIndexOfSecondLargestArray(new int[]{123, 122}));
    private static int getIndexOfSecondLargestArray(int[] arr){
        int largestElementIndex = -1;
        int secondLargestElementIndex = -1;

        if(arr.length>1){
            int largestElement;
            int secondLargestElement = 0;

            if(arr[0]>arr[1]){
                largestElement = arr[0];
                largestElementIndex = 0;
                secondLargestElement = arr[1];
                secondLargestElementIndex = 1;
            }else if(arr[1]>arr[0]){
                largestElement = arr[1];
                secondLargestElement = arr[0];
                largestElementIndex = 1;
                secondLargestElementIndex = 0;
            }else{
                largestElement = arr[0];
                largestElementIndex = 0;
            }

            if(arr.length>2){
                for(int i=2; i<arr.length; i++){
                    if(arr[i]>largestElement){
                        secondLargestElement = largestElement;
                        secondLargestElementIndex = largestElementIndex;
                        largestElement = arr[i];
                        largestElementIndex = i;
                    }else if(arr[i]>secondLargestElement && arr[i]!=largestElement){
                        secondLargestElement = arr[i];
                        secondLargestElementIndex = i;
                    }
                }
            }
        }
        return secondLargestElementIndex;
    }

    // System.out.println(getIndexOfLargestArray(new int[]{12, 123, 23, 220}));
    private static int getIndexOfLargestArray(int[] arr){
        int largestElementIndex = -1;
        int largestElement = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]>largestElement){
                largestElement = arr[i];
                largestElementIndex = i;
            }
        }
        return largestElementIndex;
    }
}
