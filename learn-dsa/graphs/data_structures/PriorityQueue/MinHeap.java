public class MinHeap {
    int[] minHeap;
    int capacity; // total size of the heap
    int size; // actual number of elements in the heap

    public MinHeap(int capacity){
        this.capacity = capacity;
        minHeap = new int[capacity+1];

        // not using 0-th element in the array
        minHeap[0] = 0;
    }

    // add an element
    public void add(int element){
        size++;

        if(size > capacity){
            System.out.println("Heap capacity exceeded!");
            size--;
            return;
        }

        minHeap[size] = element;
        int index = size;

        int parent = index / 2;
        
        // heapify - keep exchanging curr node's value with parent's until min heap property is satisfied
        while(minHeap[index] < minHeap[parent] && index > 1){
            // exchange current node value with parent's
            int temp = minHeap[index];
            minHeap[index] = minHeap[parent];
            minHeap[parent] = temp;
            index = parent;
            parent = index / 2;
        }
    }

    // get the top element of the heap
    public int peek(){
        return minHeap[1];
    }

    public boolean isEmpty(){
        return size < 1;
    }

    // delete the top element of the heap
    public int pop(){
        if(isEmpty()){
            System.out.println("Heap is empty");
            return Integer.MAX_VALUE;
        }else{
            int topElement = minHeap[1];
            minHeap[1] = minHeap[size--];

            int index = 1;

            // heapify - to restore min heap property
            while(index <= size / 2){
                int leftChild = index * 2;
                int rightChild = index * 2 + 1;

                if(minHeap[index] > minHeap[leftChild] || minHeap[index] > minHeap[rightChild]){
                    if(minHeap[index] > minHeap[leftChild]){
                        int temp = minHeap[leftChild];
                        minHeap[leftChild] = minHeap[index];
                        minHeap[index] = temp;
                        index = leftChild;
                    }else{
                        int temp = minHeap[rightChild];
                        minHeap[rightChild] = minHeap[index];
                        minHeap[index] = temp;
                        index = rightChild;
                    }
                }else{
                    break;
                }
            }
            return topElement;
        }
    }

    public int size(){
        return size;
    }

    public String toString(){
        if(isEmpty()){
            return "Heap is empty!";
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for(int i = 1; i <= size; i++){
                sb.append(minHeap[i]);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append(']');
            return sb.toString();
        }
    }

    public static void main(String[] args){
        MinHeap minHeap = new MinHeap(3);
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(2);

        System.out.println(minHeap.toString());
        System.out.println(minHeap.peek());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.toString());
        minHeap.add(4);
        minHeap.add(5);
        System.out.println(minHeap.toString());
    }

}
