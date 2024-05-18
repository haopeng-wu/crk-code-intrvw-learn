import java.util.LinkedList;

public class AnimalShelter {
    private LinkedList<Animal> dogs = null;
    private LinkedList<Animal> cats = null;

    class Animal
    {
        Animal(String animal)
        {
            this.name = animal;
            order += 1;
        }
        int getOrder()
        {
            return order;
        }
        public String name;
        static private int order = 0;
    }

    AnimalShelter()
    {
        dogs = new LinkedList<Animal>();
        cats = new LinkedList<Animal>();
    }

    void enqueue(String animal)
    {
        if (animal == "Dog") dogs.addFirst(new Animal(animal));
        if (animal == "Cat") cats.addFirst(new Animal(animal));
    }

    String dequeueAny()
    {
        if (dogs.isEmpty())
        {
            return cats.removeLast().name;
        }
        if (cats.isEmpty())
        {
            return dogs.removeLast().name;
        }
        if (dogs.getLast().getOrder() < cats.getLast().getOrder())
        {
            return dogs.removeLast().name;
        }
        else
        {
            return cats.removeLast().name;
        }
    }

    String dequeueDog()
    {
        return dogs.removeLast().name;
    }

    String dequeueCat()
    {
        return cats.removeLast().name;
    }

    public static void main(String args[])
    {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue("Dog");
        shelter.enqueue("Cat");
        shelter.enqueue("Cat");
        shelter.enqueue("Dog");
        shelter.enqueue("Cat");
        shelter.enqueue("Dog");
        shelter.enqueue("Dog");

        System.out.println(shelter.dequeueCat());
        System.out.println(shelter.dequeueCat());
        System.out.println(shelter.dequeueCat());

        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());

    }
}
