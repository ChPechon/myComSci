package etc;

// อธิบายโปรแกรมแบบคร่าว ๆ คือจะสร้างคลาสสัตว์ต่าง ๆ โดย extends มาจากตัว Animal

@FunctionalInterface // ถ้าให้สัตว์ตัวนั้นเป็นสัตว์เลี้ยงก็ให้ใช้ตัวนี้ด้วย
interface Pet {
    public String getOwner();
}

abstract class Animal {
    private int age;
    public String name;
    /* (Encapsulation)
    ตั้งตัวแปรให้ access เหมาะสมกับงาน เช่น age เพื่อกันงงเพราะมี age หลายตัวแปร (Index)
    ก็เลยตั้ง private เอาไว้เพื่อบอกว่าเป็น age ของคลาสนี้เท่านั้นนะ ส่วน name เรา
    อยากให้ access ตัว name ได้เลยจึงใช้ public */
    
    Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public abstract void saySomething();
    public abstract void move(int quantity);
    /* (Abstraction)
    บางที่ Method ในชื่อเดียวกันแต่ทำคำสั่งไม่เหมือนกัน แล้วแต่คลาสที่จะเอาไป implements
    เราเลยใช้ abstract แล้วละส่วน body เอาไว้ให้ไปเขียนเพิ่มเอาเอง */

    public int getAge() {
        return (age); // (Encapsulation) เราสามารถควบคุมตัวแปร private ว่าให้ใช้หรือไม่ให้ใช้ได้
    }
}

class Bird extends Animal { 
    /* (Inheritance) 
    หลักการว่า SubClass มีคุณสมบัติที่สืบทอดมาจาก SuperClass อย่างในตัวอย่างนี้
    Bird สืบทอด Animal มา ก็จะมีรายละเอียดเหมือนใน Animal และเขียนเพิ่มเติมต่อได้
    */

    Bird(int age, String name) {
        super(age, name); // (Inheritance) คำสั่งใช้ Constructer ของ SuperClass
    }

    @Override // (Abstraction) Override Abstract Method
    public void saySomething() {
        System.out.println("chirp");
    }
    
    @Override // (Abstraction) Override Abstract Method
    public void move(int quantity) {
        for (int i = 0; i < quantity; i++)
            System.out.println("fly..");
    }
}

class Cat extends Animal implements Pet {
    /* (Polymorphism)
    หลักการเขียน SuperClass เพื่อเอาไป implements ให้กับหลาย ๆ SubClass
    ตัวอย่างเช่น Cat, Bird ต่างก็ implements มาจาก Animal */
    private String owner;

    Cat(int age, String name, String owner) {
        super(age, name);
        this.owner = owner;
    }

    @Override
    public void saySomething() { // (Abstraction) Override Abstract Method
        System.out.println("Meowww");
    }

    @Override
    public void move(int quantity) { // (Abstraction) Override Abstract Method
        for (int i = 0; i < quantity; i++)
            System.out.println("walk..");
    }

    @Override
    public String getOwner() { // (Abstraction) Override Interface Method
        return (owner);
    }
}

class OOPConcept {
    public static void main(String[] args) {
        Animal Cat = new Cat(15,"Tom" , "Pechon");
        Animal Bird = new Bird(4, "Twitty");

        System.out.println(Cat.name + " " + Cat.getAge() + " " + ((Pet) Cat).getOwner());
        System.out.println(Bird.name + " " + Bird.getAge());
        // (Encapsulation) สังเกตว่า name จะ access ได้เลยส่วน age จะต้องใช้ผ่าน public method ที่เราเขียนให้

        Cat.move(5);
        Bird.move(3);
        /* (Polymorphism, Abstraction) 
        ถึงแม้จะเป็นคำสั่ง move เหมือนกัน แต่นกก็ต้องบิน แมวก็ต้องเดิน 
        เราจึงให้ method ชื่อว่า move เป็น Abstract ไปแล้วให้แต่ละ
        SubClass Override กันเอาเอง*/
    }
}
