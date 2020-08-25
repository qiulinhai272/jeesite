package src.itheima03;

public class Zi extends Fu {
    public void method(){
        System.out.println("Zi中method（）方法被调用");
    }
    public void show(){
        super.show();
        System.out.println("Zi中方法被调用");
    }
}
