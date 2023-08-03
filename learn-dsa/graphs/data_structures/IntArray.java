/* Integer dynamic array */
public class IntArray implements Iterable<Integer>{

    private static final int DEFAULT_CAP = 1 << 3; // 1*(2^3) = 8 as the default capacity of the array

    public int[] arr;
    public int len = 0; // actual length of the array
    private int capacity = 0; // total capacity of the array

    // Initialize the array with a default capacity
    public IntArray(){
        this(DEFAULT_CAP);
    }

    // Initialize the array with a certain capacity
    public IntArray(int capacity){
        if(capacity < 0) throw new IllegalArgumentException("Illegal Capacity: "+capacity);
        this.capacity = capacity;
        arr = new int[capacity];
    }

    //Given an array make it a dynamic array
    public IntArray(int[] array){
        if(array == null) throw new IllegalArgumentException("Array cannot be null");
        arr = java.util.Arrays.copyOf(array, array.length);
        capacity = array.length;
        len = array.length;
    }

    // return the size of the array
    public int size(){
        return len;
    }

    // return true/false on whether the array is empty
    public boolean isEmpty(){
        return len == 0;
    }

    // get element at an index
    public int get(int index){
        return arr[index];
    }

    // set an element at an index
    public void set(int index, int elem){
        arr[index] = elem;
    }

    // add an element to the dynamic array
    public void add(int elem){
        if(len + 1 >= capacity){
            if(capacity == 0)capacity = 1;
            else capacity *= 2; // double the size
            arr = java.util.Arrays.copyOf(arr,capacity);
        }
        arr[len++] = elem;
    }
    
    // remove element at an index
    public void removeAt(int rm_index){
        System.arraycopy(arr, rm_index + 1, arr, rm_index, len-rm_index-1);
        --len;
        --capacity;
    }

    // search and remove an element
    public boolean remove(int elem){
        for(int i = 0; i < len; i++){
            if(arr[i] == elem){
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    //reverse array
    public void reverse(){
        for(int i = 0; i < len / 2;i++){
            int tmp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = tmp;
        }
    }

    // sort array
    public void sort(){
        java.util.Arrays.sort(arr,0,len);
    }

    public int binarySearch(int key){
        int index = java.util.Arrays.binarySearch(arr,0,len,key);
        return index;
    }

    @Override
    public java.util.Iterator<Integer> iterator(){
        return new java.util.Iterator<Integer>(){
            int index = 0; //maintain a local index for this iterator

            public boolean hasNext(){
                return index < len;
            }

            public Integer next(){
                return arr[index++];
            }

            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString(){
        if(len == 0) return "[]";
        else{
            StringBuilder sb = new StringBuilder(len).append("[");
            for(int i = 0; i < len - 1; i++)sb.append(arr[i] + ", ");
            return sb.append(arr[len - 1] + "]").toString();
        }
    }

    public static void main(String[] args){
        IntArray ar = new IntArray(50);
        ar.add(3);
        ar.add(7);
        ar.add(6);
        ar.add(-2);

        ar.sort();
        System.out.println(ar);
    }
}
