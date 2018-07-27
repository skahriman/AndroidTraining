package com.example.sefakkahriman.fridaytestprinting2darray;

public class PrintSpiral2DArray {

    public static void main(String [] args) {

        int[][] array = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}};

        for (int i = 0; i<array.length; i++) {
            for (int j = 0; j<array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        int i = array.length;
        int j = array[0].length;

        System.out.println("i: " + i + ", j: " + j);
    }

}
