public class DoublyLinkedList {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    public static class Node<T>{
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString(){
            return data.toString();
        }
    }

    // check if list is empty
    public boolean isEmpty(){
        return size < 1;
    }

    // size of the list
    public int size(){
        return size;
    }

    // clear the linked list
    public void clear(){
        Node<T> curr = head;

        while(curr != null){
            Node<T> next = curr.next;
            curr.data = null;
            curr.prev = curr.next = null;
            curr = next;
        }

        head = tail = curr = null;
        size = 0;
    }

    public void addLast(T elem){
        if(isEmpty()){
            head = tail = new Node(elem, null, null);
        }else{
            tail.next = new Node(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T elem){
        if(isEmpty()){
            head = tail = new Node(elem, null, null);
        }else{
            head.prev = new Node(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    public void add(T elem){
        addLast(elem);
    }

    public void addAt(T elem, int index){
        if(index == 0){
            addFirst(elem);
            return;
        }

        if(index == size){
            addLast(elem);
            return;
        }

        Node<T> curr = head;
        for(int ind = 0; ind < index - 1; ind++){
            curr = curr.next;
        }
        Node<T> temp = new Node(elem, curr, curr.next);
        curr.next = temp;
        curr.next.prev = temp;

        size++;
    }

    public T peekFirst(){
        if(isEmpty())throw new RuntimeException("Empty list");

        return head.data;
    }

    public T peekLas(){
        if(isEmpty())throw new RuntimeException("Empty List");

        return tail.data;
    }

    public T removeFirst(){
        if(isEmpty())throw new RuntimeException("Empty list");

        T data = head.data;
        head = head.next;
        --size;

        if(isEmpty())tail = null;

        else head.prev = null;

        return data;

    }

    public T removeLast(){
        if(isEmpty())throw new RuntimeException("Empty list");

        T data = tail.data;
        tail = tail.prev;
        --size;

        if(isEmpty()) head = null;
        
        else tail.next = null;

        return data;
    }

    public T removeAt(int index){
        if(index < 0 || index >=size){
            throw new IllegalArgumentException();
        }

        int i;
        Node<T> curr;

        if(index < size/2){
            for(i = 0, curr = head; i != index; i++){
                curr = curr.next;
            }
        }else{
            for(i = size - 1, curr = tail; i != index; i--){
                curr = curr.prev;
            }
        }

        return remove(curr);
    }

    public T remove(Node<T> node){
        if(node.prev == null)return removeFirst();
        if(node.next == null)return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;

        node.data = null;
        node = node.prev = node.next = null;

        --size;
    }

    public int indexOf(Object obj){
        int index = 0;
        Node<T> curr = head;

        if(obj == null){
            for(;curr != null; curr = curr.next, index++){
                if(curr.data == null){
                    return index;
                }
            }
        }else{
            for(;curr != null; curr = curr.next, index++){
                if(obj.equals(curr.data)){
                    return index;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator(){
        return new java.util.Iterator<T>(){
            private Node<T> curr = head;

            @Override
            public boolean hasNext(){
                return curr != null;
            }

            @Override
            public T next(){
                T data = curr.data;
                curr = curr.next;
                return data;
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException(null, null);
            }
        };
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> curr = head;

        while(curr != null){
            sb.append(curr.data);
            if(curr.next != null){
                sb.append(", ");
            }
            curr = curr.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
   
}
