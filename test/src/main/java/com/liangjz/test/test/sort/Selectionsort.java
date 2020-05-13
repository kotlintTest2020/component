package com.liangjz.test.test.sort;

public class Selectionsort {
    public static void main(String[] args) {
        int[] test = {3,31,24,21,12,3,342,9};
        for(int i : selectSort(test)){
            System.out.print(i + ",");
        }

    }
    private static int[] selectSort(int[] tables){
        int minIndex;
        for(int i = 0; i < tables.length -1; i++){
            minIndex = i;
            for(int j = i + 1; j< tables.length; j++){
                if(tables[j] < tables[minIndex]){
                    minIndex = j;
                }
            }
            int tem = tables[minIndex];
            tables[minIndex] = tables[i];
            tables[i] = tem;
        }
        return tables;
    }
}
