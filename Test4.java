import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Test4{
    public static void main(String[] args) {
        int n = 20; // количество элементов массива
        int qntZero = 0;
        int qntZeroTemp = 0;
        int max = 0; // максимальный элемент
        int[] arr1; // объявление массива
        int a = 0; //вспомогательная переменная
        int t = 1;

        /**
         * Ввод с клавиатуры значений
         *  для исходного массива
         */
        arr1 = new int[n]; // создание, то есть, выделение памяти для массива на 10 элементов типа int
        // Scanner console = new Scanner(System.in);
        // System.out.println("Введите последовательность из" + n + " символов:");
        // for(int i=0; i<n; i++){
        //     System.out.print("Укажите элемент№ "+(+i+1)+" :");
        //     arr[i] = console.nextInt();
        // }
        int[] arr = {1, 2, 0, 0, 2, 300, 0, 0, 0, 3, 0, 0, 0, 3, 4, 0, 0, 7, 0, 66};
        /**
         * Вывод получившегося массива
         */
        System.out.print("Введенный Массив : {");
        for(int i=0; i<arr.length; i++){
            if(i<arr.length-1){
                System.out.print(arr[i] + ", ");
            }else{
                System.out.println(arr[i] + " }");
            }
        }

        /**
         * Определяем максимальный 
         * элемент массива
         */
        max = arr[0];
        if(max == 0){
            qntZeroTemp++;
        }
        for(int i=1; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }

       /**
        * Определяем максимально возможную 
        * длинну последовательности из нулей
        */
        for(int i =1; i<arr.length; i++){
            if(arr[i] == 0 && arr[i-1]==0){
                qntZeroTemp++;
            }else{
                qntZeroTemp = 1;
            }
            if(qntZeroTemp>qntZero){
                qntZero = qntZeroTemp;
            }
        }
        /**
         * Замена всех входящих,
         *  самых длинных,
         *  послдовательностей из нулей
         *  на максимальное число
         */
        ArrayList<Integer> arr_new = new ArrayList<Integer>();

        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 0){
                a = i+1;
                t = 1;
                for(int j=0; j<qntZero; j++){
                    if(arr[a]==0 && a < arr.length){
                        t++;
                        a++;
                    }
                }
                
                if(t == qntZero){
                    arr_new.add(max);
                    i=i+qntZero-1;
                }else{
                    arr_new.add(arr[i]);
                }
                
            }else{
                arr_new.add(arr[i]);
            }
        }
        System.out.println("Максимальный элемент массива : "+max);
        System.out.println("Наибольшая длинна последовательности из нулей: "+qntZero);

        /**
         * Вывод нового массива
         */
        System.out.print("Новый Массив : {");
        for(int i=0; i<arr_new.size(); i++){
            if(i<arr_new.size()-1){
                System.out.print(arr_new.get(i) + ", ");
            }else{
                System.out.println(arr_new.get(i) + " }");
            }
        }
    }
}