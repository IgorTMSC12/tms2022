package task2;

import java.io.Serializable;


public class GenericClass<T extends Comparable<String>, V extends Animal & Serializable, K extends Number> {
    private T t;
    private V v;
    private K k;

    GenericClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    public void info() {
        System.out.println("Имя класса t: " + t.getClass().getName());
        System.out.println("Имя класса v: " + v.getClass().getName());
        System.out.println("Имя класса k: " + k.getClass().getName());
    }
}
