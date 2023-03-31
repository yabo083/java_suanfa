package com.yabo.Sort;

import com.yabo.LinearSearch.ArrayGenerator;

import java.util.Arrays;

public class InsertionSort {

    private InsertionSort(){}

    //一种另类的插入排序法, 跟网上一般方法不太一样。
    public static <E extends Comparable<E>> void sort(E[] arr){

        for (int i= 0; i< arr.length ; i ++){
            for (int j=i;j-1>=0;j--){
                if (arr[j].compareTo(arr[j-1]) < 0){
                    swap(arr, j, j-1);
                }else {
                    break;
                }
            }
            //上面的方法的等价写法, 性能略好, 速度略快。
            //for (int j=i; j-1>=0 && arr[j].compareTo(arr[j-1]) < 0;j --){
            //    swap(arr, j, j-1);
            }
        }
    private static <E> void swap(E[] arr, int i, int j) {

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static <E extends Comparable<E>> void sort2(E[] arr){

        for (int i=0;i<arr.length;i++){
            E t = arr[i];
            int j;
            for (j=i; j-1>=0 && t.compareTo(arr[j-1])<0;j--){
                arr[j] = arr[j-1];
            }
            arr[j]=t;
        }
    }


    public static void main(String[] args){
        int[] dataSize = { 10000, 100000, };
        for (int n:dataSize) {
            System.out.println("Random Array : ");

            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);

            SortingHelper.sortTest("SelectionSort", arr);
            SortingHelper.sortTest("InsertionSort2", arr2);

            System.out.println();

            System.out.println("Ordered Array : ");

            arr = ArrayGenerator.generaOrderedArray(n);
            arr2 = Arrays.copyOf(arr, arr.length);

            SortingHelper.sortTest("SelectionSort", arr);
            SortingHelper.sortTest("InsertionSort2", arr2);

//        }
//        Integer[] data = {2,3,7,9,6,4,5};
//        InsertionSort.sort(data);
//        for (Integer a:data) {
//            System.out.print(a + " ");
        }
}

}
