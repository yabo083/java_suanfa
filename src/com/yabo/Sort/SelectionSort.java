package com.yabo.Sort;

import com.yabo.LinearSearch.ArrayGenerator;

public class SelectionSort {
    
    private SelectionSort(){}
    
    public static <E extends Comparable<E>>void sort(E[] arr){
        
        // arr[0...i) 是有序的; arr[i...n) 是有序的
        for (int i = 0; i < arr.length;i++){
            // 选择 arr[i...n)中的最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length;j++){
                if(arr[j].compareTo(arr[minIndex])<0){
                    minIndex = j;
                }

            }
            swap(arr, i ,minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args){
        int[] dataSize = { 1000,10000, 100000, };
        for (int n:dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr);
        }


//        Student[] students = {
//                new Student("Ming",18, 98),
//                new Student("huo" ,10,95),
//                new Student("Liu" ,90, 77),
//                new Student("ff0" ,25, 87),
//                new Student("小刻", 17, 99),
//        };
//        SelectionSort.sort(students);
//        for (Student student: students){
//            System.out.print(student+" ");
//        }
//        System.out.println();
    }
}
