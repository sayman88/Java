public class Main {

    public static void main(String[] args) {
        System.out.println("Кошка: ");
        Animal cat = new Cat(400, 0, 2);
        cat.run(200);
        cat.swim(0);
        cat.jump(2);

        System.out.println("Собака: ");
        Animal dog = new Dog(400, 20, 3);
        dog.run(500);
        dog.swim(10);
        dog.jump(3);
    }
}