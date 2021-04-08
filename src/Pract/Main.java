package Pract;

import java.util.Arrays;
import java.util.function.Predicate;

class Main {


    public String arrMethod(int []arr_1, int []arr_2)   {

       int []ar1 = arr_1;
       int []ar2 = arr_2;
       int []ar3 = new int[arr_1.length];

       Arrays.sort(arr_1);
       Arrays.sort(arr_2);

       for(int i =0;i<arr_1.length;i++){
            if(arr_1[i]==arr_2[i])
            {
               ar3[i] = arr_1[i];
            }
       }
       return Arrays.toString(ar3);
    }

    public static void main(String[] args) {

        Main main = new Main();
        int []arr1 = {1,2,3,4,5,11};
        int []arr2 = {4,11,3,5,1,2};

        System.out.println(main.arrMethod(arr1,arr2));

    }





}
