package core;

import java.util.Arrays;
import java.util.List;

public class Array {
    public static void main(String[] args) {
        int[] n1 = new int[0];
        //boolean[] n2 = new boolean[-200]; //Error at run time when JVM allocate memory for this variable.
//        double[] n3 = new double[2241423798]; //Number too big for integer so at compile-time it will cause error
        char[] ch = new char[20];
        char[] copyFrom = {
                'w', 'e', 'c', 'o', 'm', 'e',
                't', 'o',
                'g', 'p', 'c', 'o', 'd', 'e', 'r'
        };


        char[] copyTo = new char[7];
        System.arraycopy(copyFrom, 0, copyTo, 0, 7);
        System.out.println(copyFrom);
        System.out.println(copyTo);

        someUsefulArraysFunction();
    }

    public static void someUsefulArraysFunction() {
        //Khai báo mảng gồm các phần tử nguyên thủy (primitive)
        int[] intArray = {
                15, 5, 10, 30 ,25
        };

        //toString để in ra chuỗi
        System.out.println(Arrays.toString(intArray));

        //sort
        Arrays.sort(intArray);

        System.out.println("After sort" + Arrays.toString(intArray));

        //Tìm kiếm chỉ số của một giá trị xuất hiện trong mảng
        // MẢng phải được sắp xếp trước khi gọi hàm binarySearch
        int index = Arrays.binarySearch(intArray, 15);
        if(index < 0) {
            System.out.println("Can't find");
        } else {
            System.out.println("Found" + index);
        }

        //Gán 1 giá trị cho tất cả phần từ của mảng
        Arrays.fill(intArray, 15);

        System.out.println("Sau khi fill: " + Arrays.toString(intArray));

        //Khai bao kiểu object:
        Integer[] newInteger = {
                15,5,10,30,25
        };

        //Chuyển qua list
        List<Integer> list = Arrays.asList(newInteger);
        System.out.println("Sau khi chuyển qua list: " + list);


    }
}

//Fixed size (predictable memory usage)	Fixed size (inflexible, needs resizing)
//Constant-time access to elements (O(1))	Inefficient for insertion and deletion
//Efficient memory usage	Memory waste if overallocated
//Homogeneous data type (type safety)	Single type restriction (no mixed types)
//Simple syntax and built-in length property	Lack of utility methods (add/remove)
//Supports multidimensional arrays	Lacks flexibility compared to ArrayList