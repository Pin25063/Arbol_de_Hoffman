public class MinHeap {
    private Node[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new Node[capacity];
    }

    private int getPadre(int i) {
        return (i - 1) / 2;
    }

    private int getHijoIzq(int i) {
        return (2 * i) + 1;
    }

    private int getHijoDer(int i) {
        return (2 * i) + 2;
    }

    private boolean tienePadre(int i) {
        return i > 0;
    }

    private boolean tieneHijoIzq(int i) {
        return getHijoIzq(i) < size;
    }

    private boolean tieneHijoDer(int i) {
        return getHijoDer(i) < size;
    }

    private void intercambiar(int indice1, int indice2) {
        Node temporal = heap[indice1];
        heap[indice1] = heap[indice2];
        heap[indice2] = temporal;
    }

    public void insert(Node node) {
        if (size >= capacity) {
            throw new IllegalStateException("El heap está lleno");
        }
        heap[size] = node;
        size++;
        heapifyUp(size - 1);
    }

    private void heapifyUp(int i) {
        while (tienePadre(i) && heap[getPadre(i)].frequency > heap[i].frequency) {
            intercambiar(getPadre(i), i);
            i = getPadre(i);
        }
    }

    public Node extractMin() {
        if (size == 0) {
            throw new IllegalStateException("El heap está vacío");
        }
        Node minimo = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        heapifyDown(0);
        return minimo;
    }

    private void heapifyDown(int i) {
        while (tieneHijoIzq(i)) {
            int indiceMenor = getHijoIzq(i);

            if (tieneHijoDer(i) && heap[getHijoDer(i)].frequency < heap[indiceMenor].frequency) {
                indiceMenor = getHijoDer(i);
            }

            if (heap[i].frequency <= heap[indiceMenor].frequency) {
                break;
            }

            intercambiar(i, indiceMenor);
            i = indiceMenor;
        }
    }

    public Node peek() {
        if (size == 0) {
            throw new IllegalStateException("El heap está vacío");
        }
        return heap[0];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}