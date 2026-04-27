public class Experiment {
    private Sorter sorter;
    private Searcher searcher;

    public Experiment(Sorter sorter, Searcher searcher) {
        this.sorter = sorter;
        this.searcher = searcher;
    }

    public long measureSortTime(int[] arr, String type) {
        int[] copy = arr.clone();

        long start = System.nanoTime();

        if (type.equalsIgnoreCase("basic")) {
            sorter.basicSort(copy);
        } else if (type.equalsIgnoreCase("advanced")) {
            sorter.advancedSort(copy);
        }

        long end = System.nanoTime();

        return end - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();

        return end - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {
            System.out.println("======================================");
            System.out.println("Array size: " + size);

            int[] randomArray = sorter.generateRandomArray(size);
            int[] sortedArray = randomArray.clone();
            sorter.advancedSort(sortedArray);

            long insertionRandomTime = measureSortTime(randomArray, "basic");
            long quickRandomTime = measureSortTime(randomArray, "advanced");

            long insertionSortedTime = measureSortTime(sortedArray, "basic");
            long quickSortedTime = measureSortTime(sortedArray, "advanced");

            int target = sortedArray[size / 2];
            long binarySearchTime = measureSearchTime(sortedArray, target);
            int foundIndex = searcher.search(sortedArray, target);

            System.out.println("Random array:");
            System.out.print("Data: ");
            sorter.printArray(randomArray);

            System.out.println("Sorted array:");
            System.out.print("Data: ");
            sorter.printArray(sortedArray);

            System.out.println("Insertion Sort on random array: " + insertionRandomTime + " ns");
            System.out.println("Quick Sort on random array: " + quickRandomTime + " ns");
            System.out.println("Insertion Sort on sorted array: " + insertionSortedTime + " ns");
            System.out.println("Quick Sort on sorted array: " + quickSortedTime + " ns");

            System.out.println("Binary Search target: " + target);
            System.out.println("Binary Search found at index: " + foundIndex);
            System.out.println("Binary Search time: " + binarySearchTime + " ns");
            System.out.println();
        }
    }
}
