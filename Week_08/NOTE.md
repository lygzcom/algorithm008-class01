 

```Java

public class Sort {
    public static void main(String[] args) throws InterruptedException {
        int[] checkNums = {8, 0, 1, 2, 3, 5, 4, 6, 7, -1, 9, 10, 11};
        int[] timekNums = new int[1000000];
        Random random = new Random();//默认构造方法
        for (int i = 0; i < 1000000; i++) {
            timekNums[i] = random.nextInt(1000000);
        }
        long startTime = System.currentTimeMillis();
        Arrays.sort(timekNums);
        //quickSort(timekNums, 0, timekNums.length - 1);
        //myQuickSort(timekNums, 0, timekNums.length - 1);
        // System.out.println(Arrays.toString(timekNums));
        long endtime = System.currentTimeMillis();
        System.out.println(endtime - startTime + "ms");

    }

    /**
     * 冒泡排序：稳定排序
     * <p>
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 针对所有的未操作过的元素重复以上的步骤，直到没有任何一对数字需要比较。
     * 时间复杂度：O(n^2)，最优时间复杂度：O(n)，平均时间复杂度：O(n^2)
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0, len = arr.length;
        //每次排序好一个元素，只需要len-1次排序
        for (int i = 0; i < len - 1; i++) {
            //只需要排序前面部分的元素，后面的(i+1)个元素已经排好序了
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }
    }

    /**
     * 选择排序：不稳定
     * <p>
     * 首先在未排序序列中找到最小元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾。
     * 时间复杂度：O(n^2)，最优时间复杂度：O(n^2),平均时间复杂度：O(n^2)
     */
    public static void selectionSort(int[] arr) {
        int temp = 0, minIndex = 0, len = arr.length;
        //每次排序好一个元素，只需要len-1次排序
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            //索引i之前已经排好序
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
     * <p>
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * <p>
     * 时间复杂度：O(n^2)，最优时间复杂度：O(nlogN),平均时间复杂度：O(nlogN)
     * 稳定性：不稳定
     */
    public static void myQuickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= arr.length || endIndex <= startIndex) return;
        int pivot = startIndex;
        int temp = 0, left = startIndex, right = endIndex;
        while (left < right) {
            //必须右指针先走
            //找到第一个小于基准数的位置
            while (right > left && arr[right] >= arr[pivot]) {
                right--;
            }
            //找到第一个大于基准数的位置
            while (left < right && arr[left] <= arr[pivot]) {
                left++;
            }
            //交互大数小数的位置
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

        }
        //指针相遇 交互基准数和当前位置
        temp = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = temp;
        //递归排序 基准数左侧
        myQuickSort(arr, startIndex, left - 1);
        //递归排序 基准数右侧
        myQuickSort(arr, left + 1, endIndex);

    }

    /**
     * 其他优秀快排实现
     *
     * @param array
     * @param begin
     * @param end
     */
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    static int partition(int[] a, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
    }

    /**
     * 堆排序，建立堆，利用堆的性质对元素排序
     * 稳定性：不稳定
     * 时间复杂度：O(nlogN)，最优时间复杂度：O(nlogN)，平均时间复杂度：O(nlogN)
     *
     * @param array
     */
    public static void heapSort(int[] array) {
        if (array.length == 0) return;
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(array, length, i);
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }

    /**
     * 归并排序 递归思想
     * 归并排序是建立在归并操作上的一种有效的排序算法。
     * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
     * 若将两个有序表合并成一个有序表，称为2-路归并。
     * 把长度为n的输入序列分成两个长度为n/2的子序列；
     * 对这两个子序列分别采用归并排序；
     * 将两个排序好的子序列合并成一个最终的排序序列。
     *
     * @param array
     * @param left
     * @param right
     */
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1; // (left + right) / 2
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

}

```

