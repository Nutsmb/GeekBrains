package Lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> content = new ArrayList<T>();

    public Box(){
    }

    public float getWeight(){
        float result = 0;

        for (T example: content) {
            result += example.getWeight();
        }
        return result;
    }

    public void put(T _something){
        content.add(_something);
    }

    public boolean compare(Box<?> box){
        boolean result = false;

        if (this.getWeight() == box.getWeight()){
            result = true;
        }
        return result;
    }

    public void pourBox(Box<T> from){
        this.content.addAll(from.content);
        from.content.removeAll(from.content);
    }
}
