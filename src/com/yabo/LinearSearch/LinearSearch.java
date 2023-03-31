package com.yabo.LinearSearch;

public class LinearSearch {

    private LinearSearch(){}

    public static <E> int search(E[] data, E target){
        for (int i= 0;i<data.length; i++){
            if(data[i].equals(target) ){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        Integer[] data = {1, 2,3,1,46,4,6,4,5};
//        int target = 4;
//        System.out.println(LinearSearch.search(data, target));
//
//        Integer[] data1 = {1, 2,3,1,46,4,6,4,5};
//        int target1 = 55;
//        System.out.println(LinearSearch.search(data1, target1));
//
//        Student[] data2 = {
//                new Student("wang", 15, 98),
//                new Student("li", 18, 99),
//                new Student("zhang", 27, 19),
//                new Student("de", 58, 99),
//                new Student("cv", 19, 78),
//        };
//        Student target = new Student("zhang", 27, 19);
//        System.out.println(LinearSearch.search(data2,target));

        int[] dataSize  ={100000 ,1000000,10000000};
        for (int n:dataSize) {

            Integer[] data = ArrayGenerator.generaOrderedArray(n);

            long startTime =System.nanoTime();
            for (int k = 0;k<100; k++){
                LinearSearch.search(data, n);
            }
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", 100 runs :" + time +" s");

        }
    }
}
