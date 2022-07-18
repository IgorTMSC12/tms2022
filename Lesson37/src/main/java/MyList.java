import java.util.NoSuchElementException;

public class MyList<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public int size() {
        return size;
    }

    public MyList() {
    }

    public void add(E e) {
        addLast(e);
    }

    public void addLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public void addFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    public void remove(Object o) {
        if (o == null) {
            for (Node<E> a = first; a != null; a = a.next) {
                if (a.item == null) {
                    unlink(a);
                }
            }
        } else {
            for (Node<E> a = first; a != null; a = a.next) {
                if (o.equals(a.item)) {
                    unlink(a);
                }
            }
        }
    }

    public void removeFirst() {
        final Node<E> a = first;
        Node<E> next = a.next;
        a.item = null;
        a.next = null;
        if (a == null) {
            throw new NoSuchElementException();
        }
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
    }

    public void removeLast() {
        Node<E> a = last;
        if (a == null) {
            throw new NoSuchElementException();
        }
        Node<E> prev = a.prev;
        a.item = null;
        a.prev = null;
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;
    }

    public void removeByIndex(int index) {
        remove(getElementByIndex(index));
    }

    public E getElementByIndex(int index) {
        Node<E> element = first;
        for (int i = 0; i < index; i++) {
            element = element.getNext();
        }
        return element.getItem();
    }

    public E getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    public E getLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return last.item;
    }

    private E unlink(Node<E> a) {
        final E element = a.item;
        final Node<E> next = a.next;
        final Node<E> prev = a.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            a.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            a.next = null;
        }
        a.item = null;
        size--;
        return element;
    }

    public void clear() {
        for (Node<E> a = first; a != null; ) {
            Node<E> next = a.next;
            a.next = null;
            a.prev = null;
            a.item = null;
            a = next;
        }
        size = 0;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        public E getItem() {
            return item;
        }

        public Node<E> getNext() {
            return next;
        }
    }
}
