package com.example.demo.text;

import java.util.Arrays;

public class ArithmeticDemo {


    /**
     * 1-100递归加法
     */

    public static int sum(int num) {

        if (num == 1) {
            return 1;
        } else {

            return num + sum(num - 1);
        }
    }

    /**
     * 冒泡排序
     *
     * @param numbers
     */

    public static void sort(int[] numbers) {


        int size = numbers.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }

        }
        System.out.println();
        System.out.println("排序后的数组为：" + Arrays.toString(numbers));

    }

    public static void quickSort(int[] arr, int low, int high) {

        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;

        temp = arr[low];
        //如果左边小于右边
        while (i < j) {

            while (temp <= arr[j] && i < j) {
                j--;
            }

            while (temp >= arr[i] && i < j) {
                i++;
            }

            if (i < j) {
                t = arr[i];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);

        quickSort(arr, j + 1, high);


    }

    public static void Arraysort(int[] numbers) {


        for (int i = 0; i < numbers.length; i++) {
            Arrays.sort(numbers);
        }
        System.out.println("排序后的数组为：" + Arrays.toString(numbers));
    }


    public static void main(String[] args) {
        int[] numbers = {2, 1, 5, 8, 3, 5, 9, 15};
//      quickSort(numbers,0,numbers.length-1);
//        for (int i = 0; i <numbers.length; i++) {
//            System.out.println("排序后的数组为："+numbers[i]);
//        }
        // sort(numbers);

        Arraysort(numbers);
    }
}
