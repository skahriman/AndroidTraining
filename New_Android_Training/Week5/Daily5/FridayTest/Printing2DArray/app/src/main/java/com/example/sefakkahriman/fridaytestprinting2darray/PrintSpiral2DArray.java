package com.example.sefakkahriman.fridaytestprinting2darray;

public class PrintSpiral2DArray {


    public static void printCircle(String[][] array) {


        int i = array.length;
        int j = array[0].length;

        int start_i_index = 0;
        int end_i_index = array.length-1;

        int start_j_index = 0;
        int end_j_index = array[0].length-1;
        int k, l, m, n;

        int numberOfElements = i*j;
        int counter = 0;

        while (counter != numberOfElements) {
            for (k = start_i_index; k <= end_i_index; k++) {
                System.out.print(start_j_index + "" + k + " ");
                counter++;
            }

            for (l = start_j_index+1; l <= end_i_index; l++) {
                System.out.print(l + "" + end_i_index + " ");
                counter++;
            }

            for (m = end_i_index-1; m >= start_i_index; m--) {
                System.out.print(end_j_index + "" + m + " ");
                counter++;
            }

            for (n = end_j_index-1; n >= start_j_index+1; n--) {
                System.out.print(n + "" + start_j_index + " ");
                counter++;
            }

            start_i_index++;
            start_j_index++;
            end_i_index--;
            end_j_index--;

        }

    }

    public static void main(String [] args) {

        String [][] array = {
                {"00", "01", "02", "03"},
                {"10", "11", "12", "13"},
                {"20", "21", "22", "23"},
                {"30", "31", "32", "33"}};

        printCircle(array);


    }

}












