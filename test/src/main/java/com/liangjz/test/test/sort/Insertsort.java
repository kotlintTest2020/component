package com.liangjz.test.test.sort;

public class Insertsort {
    public static void main(String[] args) {
        int[] test = {155,7,12,12,323,51,41,21,8,32};
        for(int i : sort(test)){
            System.out.print(i + ",");
        }
    }
    private static int[] sort(int[] tables){
        for(int i = 0; i < tables.length -1; i++){
            for(int j = i + 1; j > 0 && tables[j] < tables[j-1]; j--){
                int tem = tables[j];
                tables[j] = tables[j-1];
                tables[j-1] = tem;
            }
        }
        return tables;
    }
}
