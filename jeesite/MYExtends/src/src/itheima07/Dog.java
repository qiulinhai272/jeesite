package src.itheima07;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    public void view(){
        System.out.println("看门");
    }
}
