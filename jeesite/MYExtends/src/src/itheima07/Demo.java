package src.itheima07;

public class Demo {
    public static void main(String[] args) {
        Cat c1 = new Cat();
        c1.setName("加菲猫");
        c1.setAge(5);
        System.out.println(c1.getName()+","+c1.getAge());
        c1.catchMouse();
    }
}
