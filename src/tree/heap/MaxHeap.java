package tree.heap;

/**
 * 最大堆
 */
public class MaxHeap<E extends Comparable<E>> {

    public Array<E> data;

    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(Array<E> arr){
        data = arr;
    }

    //大小
    public int size(){
        return data.getSize();
    }

    //返回堆是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回index的父节点索引
    public int parent(int index) {
        if(index<0 || index >= data.getSize())
            throw new IllegalArgumentException("index is out of range");
        return (index-1)/2;
    }

    //返回index的左孩子节点的索引
    public int leftChild(int index) {
        if(index<0 || index >= data.getSize())
            throw new IllegalArgumentException("index is out of range");
        return index*2 + 1;
    }

    //返回index的右孩子节点的索引
    public int rightChild(int index) {
        if(index<0 || index >= data.getSize())
            throw new IllegalArgumentException("index is out of range");
        return index*2 + 2;
    }
    //相对中添加元素
    public void add(E e){
        data.addLast(e);
        try {
            siftUp(data.getSize()-1);
        } catch (IllegalArgumentException e1) {
            e1.printStackTrace();
        }
    }

    //上浮siftUp
    private void siftUp(int index) {
        int parentIndex = parent(index);
        while(index>=0 && data.get(index).compareTo(data.get(parentIndex))>0){
            swap(index, parent(index));
            siftUp(parent(index));
        }
    }

    //取出最大元素
    public E findMax() {
        if(data.getSize()<=0)
            throw new IllegalArgumentException("heap is empty");
        return data.get(0);
    }

    //释放最大元素
    public E extractMax() {
        E max = findMax();
        //最后一个元素赋值给堆顶元素
        swap(0, data.getSize()-1);
        //移除最后一个元素
        data.removeLast();
        //保持堆得属性，进行下沉操作
        siftDown(0);
        return max;
    }

    //下沉操作
    public void siftDown(int index){
        while(leftChild(index) < data.getSize()){
            int j = leftChild(index);
            //右节点也存在
            if(j+1 < data.getSize()
                    && data.get(j).compareTo(data.get(j+1))<0){
                j = rightChild(index);
            }
            if(data.get(index).compareTo(data.get(j))<0){
                swap(index, j);
                index = j;
            }
        }
    }

    //swap交换元素
    private void swap(int a, int b){
        E temp = data.get(a);
        data.set(a, data.get(b));
        data.set(b, temp);
    }

    //打印输出
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("最大堆：[");
        for(int i = 0 ; i < data.getSize() ; i ++){
            res.append(data.get(i));
            if(i != data.getSize() - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args){
        Integer[] arr = {62, 41, 30, 28, 13, 19, 17, 15, 16, 22};
        MaxHeap<Integer> heap = new MaxHeap<>();
        for(int i=0; i<arr.length; i++){
            heap.add(arr[i]);
        }
        heap.add(52);

        for(int i=0; i<heap.size(); i++){
            int val = heap.extractMax();
            System.out.println(val);
        }
    }
}
