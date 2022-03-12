package task3;

public class MinMax<T extends Number & Comparable> {
    private T[] count;

    public MinMax(T[] count) {
        this.count = count;
    }

    public T MaxCount() {
        T result = count[0];
        for (int i = 0; i < count.length; i++) {
            if (count[i].compareTo(result) > 0) {   //еле еле что то получилось
                result = count[i];
            }
        }
        return result;
    }

    public T MinCount() {
        T result = count[0];
        for (int i = 0; i < count.length; i++) {
            if (count[i].compareTo(result) < 0) {
                result = count[i];
            }
        }
        return result;
    }

    public void MinMaxInfo() {
        System.out.println("Максимальный элемент: " + MaxCount());
        System.out.println("Минимальный элемент " + MinCount());
    }
}
