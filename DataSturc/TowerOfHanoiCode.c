#include <stdio.h>

void updateTowers(int n, char from_rod, char to_rod, char aux_rod, int *A, int *B, int *C) {
    if (from_rod == 'A') *A = n;
    else if (from_rod == 'B') *B = n;
    else if (from_rod == 'C') *C = n;

    if (to_rod == 'A') *A = n - 1;
    else if (to_rod == 'B') *B = n - 1;
    else if (to_rod == 'C') *C = n - 1;
}

void printTowers(int A, int B, int C) {
    printf("tower A: ");
    for (int i = 1; i <= A; i++) {
        printf("%d ", i);
    }
    printf("\n");
    
    printf("tower B: ");
    for (int i = 1; i <= B; i++) {
        printf("%d ", i);
    }
    printf("\n");
    
    printf("tower C: ");
    for (int i = 1; i <= C; i++) {
        printf("%d ", i);
    }
    printf("\n");
}

void move(int disk, char from_rod, char to_rod, char aux_rod) {
    printf("move#%d: move(%d, %c, %c, %c)\n", disk, disk, from_rod, to_rod, aux_rod);
}

void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod, int *A, int *B, int *C) {
    if (n == 0) {
        return;
    }
    towerOfHanoi(n - 1, from_rod, aux_rod, to_rod, A, B, C);
    move(n, from_rod, to_rod, aux_rod);
    updateTowers(n, from_rod, to_rod, aux_rod, A, B, C);
    printTowers(*A, *B, *C);
    towerOfHanoi(n - 1, aux_rod, to_rod, from_rod, A, B, C);
}

int main() {
    int N = 0;
    printf("Input: ");
    scanf("%d", &N);
    int A = N, B = 0, C = 0; // Initialize towers A with all disks, and B and C as empty
    printf("Output:\n");
    printf("Start\n");
    printTowers(A, B, C);
    towerOfHanoi(N, 'A', 'C', 'B', &A, &B, &C);
    printf("Done\n");
    printf("All steps: %d\n", (1 << N) - 1);
    return 0;
}