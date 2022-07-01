package Chapter3;
import java.util.EmptyStackException;
import java.util.LinkedList;

import Generic.TESTSUIT;

// import Chapter2.LinkedLists.DllNode;
// import Chapter2.LinkedLists.DoublyLinkedList ;


public class AnimalShelter{

    /*
    Chapter: 3, Question: . 
    An animal shelter, which holds only dogs and cats, operates on a strictly first in first out
    basis. People must adopt either the oldest based on arrival time of all animals at the shelter,
    or they can select whether they would prefer a dog or a cat and will recieve the oldest animal of that type. 
    They cannot select which specific animal they would like. Create the data structures to maintain this system and implement operations such as enqueue,
    dequeueAny, dequeueCat, dequeueDog. You may use the built-in LinkedList data structure.

    Hints: 22 56 63
    */
    public int order;
    public class Dog extends AnimalShelter{
        public Dog(String name) { super(name); };
    } 

    public class Cat extends AnimalShelter{
        public Cat(String name) { super(name); };
    } 
    
    public static LinkedList<Dog> dogs = new LinkedList<Dog>();
    public static LinkedList<Cat> cats = new LinkedList<Cat>();

    protected String name;
    public AnimalShelter(String n) {name = n;}
    public void setOrder(int o){ order = o;}
    public int getOrder(){ return order; }
    public boolean isOlderThan(AnimalShelter animal){ return this.order < animal.order; }

    //Runtime: O(n) removal O(1) insertion
    public AnimalShelter dequeueAny(){
       if(dogs.isEmpty()){
            return dequeueCat();
       } else if(cats.isEmpty()){
            return dequeueDog();
       } else if(cats.isEmpty() && dogs.isEmpty()){
            throw new EmptyStackException();
       }
       
       Dog dog = dogs.peek();
       Cat cat = cats.peek();

       if(dog.isOlderThan(cat)){
        return dequeueDog();
       } else {
        return dequeueCat();
       }
    }

    public static Cat dequeueCat(){
        if(cats.isEmpty()) throw new EmptyStackException();
        return cats.poll();
    }

    public Dog dequeueDog(){
        if(dogs.isEmpty()) throw new EmptyStackException();
        return dogs.poll();
    }

    public void enqueue(AnimalShelter animal){
        animal.setOrder(order);
        order++;
        if(animal instanceof Dog) 
            dogs.addLast((Dog) animal);
        else
            cats.addLast((Cat) animal);
    }

    public static void main(String[] args){ 
        AnimalShelter animals = new AnimalShelter("A");

        animals.enqueue(animals.new Cat("Azula"));
        animals.enqueue(animals.new Cat("Cheeto"));
        animals.enqueue(animals.new Dog("Roberto"));
        animals.enqueue(animals.new Dog("Simba"));
        System.out.println(animals.dequeueAny().name);
        System.out.println(animals.dequeueDog().name);
        System.out.println(animals.dequeueDog().name);
        System.out.println(animals.dequeueAny().name);

    }
}
    /*


    Questions:
        1. Are we able to use any other data structure besides linkedlist?

    Ideas:
        1. use removeLast/addLast

    Edge Cases:
        1. empty List
    
    Pros vs. Cons in solutons:
        1.
    
    Learned: Different solution, ideas:
        1. Need oop refresher
    
    Mistakes:
        1.

    */
