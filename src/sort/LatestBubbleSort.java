package sort;

import tree.heap.Array;

public class LatestBubbleSort<E extends Comparable<E>> {

    private Array<E> data;

    public void sort(){
        for(int i=0; i < data.getSize(); i++){
            for(int j=0; j < data.getSize()-i; i++){
                if(data.get(j).compareTo(data.get(j+1))<0){
                    E temp = data.get(j);
                    data.set(j, data.get(j+1));
                    data.set(j+1, temp);
                }
            }
        }
    }

    public static void main(String[] args){
        LatestBubbleSort latestBubbleSort = new LatestBubbleSort();

    }
}
