package com.yabo.BinarySearch;

public class BinarySearch {

    private BinarySearch(){}

    //非递归实现二分查找法
    public static <E extends Comparable<E>> int search(E[] data, E target){
        int l = 0, r = data.length - 1;

        while (l <= r){
            int mid = l + (r-l)/2;

            if(data[mid].compareTo(target) == 0){
                return mid;
            }

            if(data[mid].compareTo(target) < 0){
                l = mid + 1;
            }else {
                r = mid - 1;
            }

        }
        return -1;
    }

    //递归实现二分查找法
    public static <E extends Comparable<E>> int searchR(E[] data, E target){
        return searchR(data, 0,data.length-1,target);
    }

    private static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {

        if(l > r) return -1;

        int mid = l + (r - 1) / 2;

        if(data[mid].compareTo(target) == 0)
            return mid;

        if(data[mid].compareTo(target) < 0)
            return searchR(data, mid + 1, r, target);

        return searchR(data, l, r, target);

    }

    // > target 的最小值索引
    public static <E extends Comparable<E>> int upper(E[] data, E target){

        int l = 0, r = data.length;

        // 在 data[l, r]中寻找解
        while (l < r){
             int mid =  l+(r-l)/2;
             if(data[mid].compareTo(target)<= 0){
                 l = mid + 1;
             }else {
                 r = mid;
             }
        }
        return l;
    }

    // > target , 返回最小值索引
    // == target, 返回最大索引
    public static <E extends Comparable<E>> int upper_ceil(E[] data, E target){

        int u = upper(data, target);
        if (u-1>=0 && data[u-1].compareTo(target) == 0 ) {
            return u - 1;
        }
        return u;
    }

    // >= target 的最小值索引
    public static <E extends Comparable<E>> int lower_ceil(E[] data, E target){
        int l = 0, r= data.length;

        //在 data[l, r] 中寻找解
        while (l<r){

            int mid = l + (r - l)/2;
            if(data[mid].compareTo(target) < 0){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }

    // < target 的最大值索引
    public static <E extends Comparable<E>> int lower (E[] data, E target){

        int l= -1, r = data.length -1;

        //在data[l, r]中寻找解
        while(l < r) {
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) < 0)
                l = mid;
            else
                r = mid - 1;
        }
        return l;
    }

    // < target ，返回最大值索引
    // == target，返回最小索引
   public static <E extends Comparable<E>> int lower_floor(E[] data, E target) {

        int l = lower(data, target);
        if(l + 1 < data.length && data[l+1].compareTo(target)==0)
            return l+1;
        return l;
   }

   // <= target 最大索引
   public static <E extends Comparable<E>> int upper_floor(E[] data, E target){

        int l = -1, r = data.length-1;

        //在 data[l,r] 中寻找解
       while (l < r){
           int mid = l + (r - l + 1)/ 2 ;
           if(data[mid].compareTo(target) <= 0)
               l = mid;
           else
               r = mid -1;
       }
       return l;
   }

    public static void main(String[] args) {


        /*System.out.println("特性：目标不存在时，会返回大于目标的最小元素的第一顺位索引，不可能等于目标值");
        for(int i = 0; i <=6; i ++)
            System.out.print(BinarySearch.upper(arr, i) + " ");
        System.out.println();

        System.out.println("无重复元素且目标存在时，效果等同于普通的2分查找法；目标不存在时，同下");

        System.out.println("特性：目标不存在时，会返回大于目标的最小元素的非第一顺位索引，可能等于目标值的索引");
        for(int i = 0; i <= 6; i ++)
            System.out.print(BinarySearch.upper_ceil(arr, i) + " ");
        System.out.println();

        System.out.println("特性：目标不存在时，会返回大于目标的最小元素的第一顺位索引，可能等于目标值的索引");
        for(int i = 0; i <= 6; i ++)
            System.out.print(BinarySearch.lower_ceil(arr, i) + " ");
        System.out.println();*/
        Integer[] arr = {1,2,3};

        System.out.println("找的是<target的最大索引");
        for(int i = 0; i <= 3; i ++)
            System.out.print(BinarySearch.lower(arr, i) + " ");
        System.out.println();

        System.out.println("无重复元素且目标存在时，效果等同于普通的2分查找法；目标不存在时，同下");

        System.out.println("当< target时，找<target的最大索引\n当==target时，找==target的最小索引");
        for(int i = 0; i <= 3; i ++)
            System.out.print(BinarySearch.lower_floor(arr, i) + " ");
        System.out.println();

        System.out.println("找的是<= target的最大索引");
        for(int i = 0; i <= 3; i ++)
            System.out.print(BinarySearch.upper_floor(arr, i) + " ");
        System.out.println();
    }




}
