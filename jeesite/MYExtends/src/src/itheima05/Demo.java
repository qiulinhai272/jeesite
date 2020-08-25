package src.itheima05;

public class Demo {
    public static void main(String[] args) {
        //创建老师类测试
        Teacher t1 = new Teacher();
        t1.setName("qiulinhai");
        t1.setAge(30);
        System.out.println(t1.getName()+","+t1.getAge());
        t1.teach();

        Teacher t2 = new Teacher("qiulinhi",25);
        System.out.println(t2.getName()+","+t2.getAge());
        t2.teach();
    }
}
