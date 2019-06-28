package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 */
public class BubbleSort<E extends Comparable<E>> {

    public void sort(E[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=arr.length-1; j>=i; j--){
                if(arr[i].compareTo(arr[j])>0 ){
                    E temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("第"+i+"次排序结果"+ Arrays.toString(arr));
        }
    }

    public static void main(String[] args){
        Integer[] obj = new Integer[10];
        for(int i = 0; i<10; i++){
            obj[i] = new Random().nextInt(100);
        }
        BubbleSort<Integer> bubbleSort = new BubbleSort();
        bubbleSort.sort(obj);
    }
}
