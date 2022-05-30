package DataStructures;

public class ArrayList<T> {

    public int size;
    public int capacity;
    Object arrayList[];

    ArrayList(){
        this.size = 1;
        this.capacity = 0;
        this.arrayList = new Object[size];
    }

    //overloading constructor for setting specific sized arrayLists
    ArrayList(int size){
        this.size = size;
        this.capacity = 0;
        this.arrayList = new Object[size];
    }

    public void add(T element){
        this.arrayList[capacity] = element;
        capacity++;
        // System.out.println("Capacity is: "+ capacity);
        // System.out.println("s is: "+ size);
        if(capacity >= size){
            size *= 2;
            Object tempArray[] = new Object[size];
            System.out.println("increased array size to: " + size);
            for(int i = 0; i < this.arrayList.length; i++) {
                tempArray[i] = this.arrayList[i];
                System.out.println("copying: " + this.arrayList[i]);
            }
            this.arrayList = tempArray;
            System.out.println("finished copying");
        }

    }
    public int currentCapacity(){
        return this.capacity;
    }

    public T get(int i ){
        return (T) arrayList[i];
    }
    
    public boolean isEmpty(){
        return capacity == 0;
    }

    public void set(int i, Object o){
        if(i <= this.size)
            this.arrayList[i] = o;
        else
            System.out.println("Out of bound exception");
    }
    public int size(){
        return size;
    }

    
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1); //increase
        al.set(0, 5);
        al.add(2); // increase
        //cannot add strings to Integer type
        // al.add("Test"); 
        // al.add(null); //increase

        for(int i = 0; i < al.currentCapacity(); i++) System.out.println(al.get(i));
    }
}