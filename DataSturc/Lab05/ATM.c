#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int human, money;
} Person;

int compare(const void *a, const void *b) {
    return ((Person *)a)->money - ((Person *)b)->money;
}

int main() {
    int n, x;

    if (scanf("%d %d", &n, &x) != 2) {
        return 1;
    }

    Person people[n];
    for (int i = 0; i < n; i++) {
        if (scanf("%d", &people[i].money) != 1) {
            return 1;
        }
        people[i].human = i + 1;
    }
    qsort(people, n, sizeof(Person), compare);

    int *q = (int *)malloc(n * sizeof(int));
    int q_size = 0;

    for (int i = 0; i < n; i++) {
        if (people[i].money <= x) {
            q[q_size++] = people[i].human;
        }
    }

    for (int i = 0; i < n; i++) {
        if (people[i].money > x) {
            break;
        }
    }

    for (int i = 0; i < q_size; i++) {
        printf("%d ", q[i]);
    }

    for (int i = 0; i < n; i++) {
        if (people[i].money > x) {
            printf("%d ", people[i].human);
        }
    }

    free(q);
    return 0;
}
