# Ads_assignment3

**Analysis**

Quick Sort was faster than Insertion Sort, especially on medium and large arrays, because it has better average complexity (O(n log n) vs O(n²)).
As array size increases, Insertion Sort slows down significantly, while Quick Sort scales much better.
On sorted arrays, Insertion Sort performs much faster (close to O(n)), because fewer shifts are needed.
The results match expected Big-O behavior.
Binary Search is very efficient (O(log n)), but only works correctly on a sorted array, since it relies on order to reduce the search space.

**Reflection**

This assignment helped me understand how theoretical complexity affects real performance. I saw that simple algorithms can be inefficient on large data, while more advanced algorithms perform better. I also learned the importance of sorting before using Binary Search.


**Algorithm Explanations**

Insertion Sort: builds a sorted part of the array by inserting each element into its correct position.
Complexity: Best O(n), Average/Worst O(n²).

Quick Sort: uses a pivot to divide the array into smaller and larger parts, then sorts recursively.
Complexity: Average O(n log n), Worst O(n²).

Binary Search: finds an element by repeatedly checking the middle of a sorted array.
Complexity: O(log n). Requires sorted data.

