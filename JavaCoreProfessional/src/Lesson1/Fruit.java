package Lesson1;

public class Fruit {
    private final float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {return this.weight;}
}

class Apple extends Fruit{

    public Apple(){
        super(1.0f);
    }
}

class Orange extends Fruit{

    public Orange(){
        super(1.5f);
    }
}
