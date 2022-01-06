import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OptimisticListV<T> {
    /**
     * First list entry
     */
    private Node head;

    /**
     * Version number (removed items)
     */
    private int vr;

    /**
     * Version for added items
     */
    private ArrayList<Integer> va;
    private Integer vi;

    /**
     * Constructor
     */
    public OptimisticListV() {
        this.head  = new Node(Integer.MIN_VALUE);
        this.head.next = new Node(Integer.MAX_VALUE);
        this.vr = 0;
        this.va = new ArrayList<>();
        this.vi = Integer.valueOf(0);
    }
    /**
     * Add an element.
     * @param item element to add
     * @return true iff element was not there already
     */
    public boolean add(T item) {
        int key = item.hashCode();
        while (true) {
            Node pred = this.head;
            Node current = pred.next;
            while (current.key < key) {
                pred = current; current = current.next;
            }
            pred.lock(); current.lock();
            try {
                if (validate(pred, current)) {
                    if (current.key == key) {
                        // present
                        return false;
                    } else {
                        // not present
                        Node entry = new Node(item);
                        entry.next = current;
                        this.vi = this.vi + Integer.valueOf(1);
                        this.va.add(vi);
                        pred.next = entry;
                        return true;
                    }
                }
            } finally {
                // always unlock
                pred.unlock(); current.unlock();
            }
        }
    }

    /**
     * Remove an element.
     * @param item element to remove
     * @return true iff element was present
     */
    public boolean remove(T item) {
        int key = item.hashCode();
        int nr = 0;

        while (true) {
            Node pred = this.head;
            Node current = pred.next;

            while (current.key < key) {
                pred = current;
                current = current.next;
                nr++;
            }

            nr++;
            System.out.println("Nr: " + nr);
            pred.lock(); current.lock();

            try {
                if (validateV(Integer.valueOf(nr), Integer.valueOf((nr + 1)))) {
                    if (current.key == key) {
                        // present in list
                        pred.next = current.next;
                        this.vr += 1;
                        this.va.remove(Integer.valueOf(nr));
                        return true;
                    } else {
                        // not present in list
                        return false;
                    }
                }
            } finally {
                // always unlock
                pred.unlock(); current.unlock();
            }
        }
    }

    private boolean validateV(Integer nodeV, Integer nextV) {
        if (this.va.contains(nodeV) && this.va.indexOf(nodeV) + 1 == this.va.indexOf(nextV))
            return true;
        return false;
    }

    /**
     * Test whether element is present
     * @param item element to test
     * @return true iff element is present
     */
    public boolean contains(T item) {
        int key = item.hashCode();
        while (true) {
            Node pred = this.head;
            // sentinel node;
            Node current = pred.next;
            while (current.key < key) {
                pred = current; current = current.next;
            }
            try {
                pred.lock(); current.lock();
                if (validate(pred, current)) {
                    return (current.key == key);
                }
            } finally {
                // always unlock
                pred.unlock(); current.unlock();
            }
        }
    }

    /**
     * Check that prev and current are still in list and adjacent
     * @param pred predecessor node
     * @param current current node
     * @return whether predecessor and current have changed
     */
    private boolean validate(Node pred, Node current) {
        Node entry = head;
        while (entry.key <= pred.key) {
            if (entry == pred)
                return pred.next == current;
            entry = entry.next;
        }
        return false;
    }

    public void print() {
        Node first = head;
        System.out.print("List: ");

        while (first != null) {
            System.out.println(first.item);
            first = first.next;
        }

        System.out.print("Version: ");
        int i;
        for (i = 0; i < this.va.size(); i++) {
            System.out.println(this.va.get(i));
        }
    }


    /**
     * list node
     */
    private class Node {
        /**
         * actual item
         */
        T item;
        /**
         * item's hash code
         */
        int key;
        /**
         * next node in list
         */
        Node next;
        /**
         * Synchronizes node.
         */
        Lock lock;
        /**
         * Constructor for usual node
         * @param item element in list
         */
        Node(T item) {
            this.item = item;
            this.key = item.hashCode();
            lock = new ReentrantLock();
        }
        /**
         * Constructor for sentinel node
         * @param key should be min or max int value
         */
        Node(int key) {
            this.key = key;
            lock = new ReentrantLock();
        }
        /**
         * Lock entry
         */
        void lock() {lock.lock();}
        /**
         * Unlock entry
         */
        void unlock() {lock.unlock();}
    }
}