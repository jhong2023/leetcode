package tree;

public class MaxKNumbers {
    
    class MinHeap{
        int[] heap;
        int size;
        int capacity;
        public MinHeap(int capacity) {
            this.capacity = capacity;
            heap = new int[capacity];
        }
        
        void addValue(int val) {
            if (size < capacity) {
                size++;
                heap[size-1] = val;
                adjustUp(size - 1);
            } else if (heap[0] < val) {
                heap[0] = val;
                adjustDown(0);
            }
        }

        private void adjustUp(int i) {
            while (i > 0) {
                int parent = (i-1) / 2;
                if (heap[parent] > heap[i]) {
                    int tmp = heap[parent];
                    heap[parent] = heap[i];
                    heap[i] = tmp;
                } else {
                    break;
                }
                i = parent;
            }
        }

        private void adjustDown(int i) {
            int left = 2*i + 1;
            if (left >= size) {
                return;
            }
            
            int right = left + 1;
            int smaller;
            if (right < size) {
                smaller = heap[left] < heap[right] ? left : right;
            } else {
                smaller = left;
            }
            
            if (heap[i] > heap[smaller]) {
                int tmp = heap[i];
                heap[i] = heap[smaller];
                heap[smaller] = tmp;
                adjustDown(smaller);
            }
        }
        
    }
    
    int[] getMaxKNumbers(int input[], int k) {
        MinHeap heap = new MinHeap(k);
        for (int val : input) {
            heap.addValue(val);
        }
        
        for (int i = 0; i < heap.size; i++) {
            System.out.print(heap.heap[i] + ", ");
        }
        System.out.println();
        return heap.heap;
    }

    public static void main(String[] args) {
        MaxKNumbers m = new MaxKNumbers();
        int[] a = {1,7,8,3,4,5,6,9,10,2,3,11};
        for (int i = 0; i < a.length;i++) {
            m.getMaxKNumbers(a, i + 1);
        }
    }

}
