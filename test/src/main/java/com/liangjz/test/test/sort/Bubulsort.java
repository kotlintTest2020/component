package com.liangjz.test.test.sort;

public class Bubulsort {

    public static void main(String[] args) {
        int[] test = {23,1,2,43,231,4,3443,22};
        for (int i : sort(test))
        System.out.print(i + ",");
    }
    private static int[] sort(int[] tables){
        for(int i = 0; i < tables.length; i++){
            for(int j = 0; j < tables.length -1 -i; j++){
                if(tables[j] > tables[j+1]){
                    int tem = tables[j+1];
                    tables[j+1] = tables[j];
                    tables[j] = tem;
                }
            }
        }
        return tables;
    }
}
