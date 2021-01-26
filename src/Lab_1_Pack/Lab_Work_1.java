package Lab_1_Pack;

import java.lang.reflect.Array;
import java.util.*;

public class Lab_Work_1 {


    //Находит общие элементы двух диапазонов
    public String first_task(int []arr_1,int []arr_2)   {
        // т.к. 1 массив имеет меньшее кол-во эл,
        // то каждый эл будет проходить по всем эл 2-го массива
        int arr_3[]=new int[arr_1.length];
        for(int i=0;i< arr_1.length;i++) //используем цикл3/
        {
            for (int j=0;j< arr_2.length;j++)//используем встроенный цикл
            {
                if(arr_1[i]==arr_2[j]) // сравниваем эл 1-го и 2-го массивов
                    arr_3= arr_1; // выводим если результат true
            }
        }
        return Arrays.toString(arr_3);
    }

    //Удаляет выбранный по индексу элемент
    public int[] second_task(int []arr,int del_num) {
        int []arr_1 = new int[arr.length-1]; // создаем новый массив
       // Scanner scan = new Scanner(System.in); // для ввода числового значения
        System.out.println("Enter your number to delete");
        //int del_num = scan.nextInt(); // номер индекса для удаления
        for(int i=0,k=0;i< arr.length;i++) // цикл
        {
            if(i!=del_num) { // если индекс не выбранный
                arr_1[k]=arr[i];k++; // переписываем значение в новый массив
                // k = для счета индексов нового массива
            }
        }

            return arr_1;
    }

    //Сравнение 2-х массивов по составу
    public void third_task(int []arr_1,int []arr_2)   {

        // изначальная проверка на сходство по кол-ву
        if(arr_1.length!=arr_2.length)
        {
            System.out.println("It's not equal arrays");
        }// если проверка успешна
        else{
            // сортировка двух массивов бабл сортировкой
            // в таком случае массивы будут иметь одинаковые последовательности чисел
            for (int i = 0; i< arr_1.length; i++) { // начало роботы алгоритма
                for (int j =0;j<arr_1.length-1;j++)
                {
                    if (arr_1[j] > arr_1[j+1]) // сортировка 1-го массива
                    {
                        int tmp = arr_1[j];
                        arr_1[j] = arr_1[j + 1];
                        arr_1[j + 1] = tmp;
                    }
                    if (arr_2[j] > arr_2[j+1]) // сортировка 2-го массива
                    {
                        int tmp = arr_2[j];
                        arr_2[j] = arr_2[j + 1];
                        arr_2[j + 1] = tmp;
                    }
                }
            }
            if(Arrays.equals(arr_1,arr_2)) // если после сортировки массивы одинаковые
            {
                System.out.println("It's equal arrays");
            }
            else // в противном случае
            {
                System.out.println("It's not equal arrays");
            }

        }


    }

    //Найти в составе строки палиндром
    public String fourth_task(String srF) {

        StringBuilder stB = new StringBuilder();
        String strS = "";
        for (int i = 0; i < srF.length() - 1; i++) {

            int st = i - 1, end = i + 1;
            //цикл если проверка на одинаковых символа подряд
            while (srF.charAt(i) == srF.charAt(end)&&end < srF.length()) {
                end++;// если предыдущий символ такой же
            }
            i = end - 1; //присваивание новго значения

            //цикл проверки на зеркальность части строки
            while (st >= 0 && end < srF.length()) {
                if (srF.charAt(st) == srF.charAt(end)) {
                    st--;
                    end++;
                } else
                    {
                    break;
                }
            }
            //после последнего цикла, если растояние между 2 переменными больше 3
            // вставляем строку в билдер
            if (end - st >= 3) {
                stB.append(srF.substring(st+1,end));
            }
            // проверка на равенство и запись в строку из билдера
            if(strS.length()< stB.length()&&stB.toString().equals(stB.reverse().toString()))
            {
                strS = stB.toString();
            }

        }

        return strS;

    }

    //конвертирует из 10 в 2 сист исчисл
    public String fifth_task(int n) {
    //Створіть метод, який приймає параметр
    //int та конвертує його з десяткової у двійкову систему обчислення
    //та повертає у вигляді String.


        Vector<Integer> vec = new Vector<Integer>(); // список
        while (n > 0) { // пока число больше чем 0
            vec.add(0,  n % 2); // получаем остаток от деления sum
                                              // от того числа, в системе которого
                                             // хотим получить ответ
            n = n / 2; // сокращаем начальное число в 2 раза для новой иттерации
        }
        return(Arrays.toString(vec.toArray()));
        }



    public static void main(String[] args) {
        Lab_Work_1 t = new Lab_Work_1();
        int []arr_1 = {5,6,7,9,10,11};
        int arr_2[]={18,17,16,15,14,13,12,11,10,9};
        String st = "airia";
        int arr_3[] = {4,7,1};
        int arr_4[] = {1,4,7};

        // System.out.println(t.first_task(arr_1,arr_2));
        //System.out.println(t.second_task(arr_2,2));
         t.third_task(arr_3,arr_4);
        //System.out.println(t.fourth_task(st));
        //System.out.println(t.fifth_task(2));

        System.out.println(Arrays.equals(arr_3,arr_4));



    }

}
