#include <stdio.h>

void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int binarySearch(int arr[], int left, int right, int target, int *numComparisons) {
    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            (*numComparisons)++;
            return mid;
        }

        if (arr[mid] < target) {
            (*numComparisons)++;
            left = mid + 1;
        } else {
            (*numComparisons)++;
            right = mid - 1;
        }
    }
    return -1;
}

int main() {
    int data[] = {1, 15, 5, 7, 10, 9, 10, 3, 45, 155, 56, 18, 88, 23, 99, 111, 100};
    int n = sizeof(data) / sizeof(data[0]);
    int target1 = 5;
    int target2 = 90;
    int comparisons1 = 0;
    int comparisons2 = 0;

    printf("Original Data: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", data[i]);
    }
    printf("\n");

    bubbleSort(data, n);

    printf("Sorted Data: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", data[i]);
    }
    printf("\n");

    int index1 = binarySearch(data, 0, n - 1, target1, &comparisons1);
    int index2 = binarySearch(data, 0, n - 1, target2, &comparisons2);

    if (index1 != -1) {
        printf("%d found at index %d after %d comparisons\n", target1, index1, comparisons1);
    } else {
        printf("%d not found\n", target1);
    }

    if (index2 != -1) {
        printf("%d found at index %d after %d comparisons\n", target2, index2, comparisons2);
    } else {
        printf("%d not found\n", target2);
    }

    return 0;
}
