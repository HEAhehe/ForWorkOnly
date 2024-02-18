#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 1000

typedef struct {
    int data[MAX_SIZE];
    int front, rear;
} Queue;

void initializeQueue(Queue *queue) {
    queue->front = -1;
    queue->rear = -1;
}

int isFull(Queue *queue) {
    return (queue->rear + 1) % MAX_SIZE == queue->front;
}

int isEmpty(Queue *queue) {
    return queue->front == -1;
}

void enqueue(Queue *queue, int value) {
    if (isFull(queue)) {
        printf("Queue is full\n");
        return;
    }

    if (isEmpty(queue))
        queue->front = queue->rear = 0;
    else
        queue->rear = (queue->rear + 1) % MAX_SIZE;

    queue->data[queue->rear] = value;
}

void dequeue(Queue *queue) {
    if (isEmpty(queue)) {
        printf("EMPTY\n");
        return;
    }

    if (queue->front == queue->rear)
        queue->front = queue->rear = -1;
    else
        queue->front = (queue->front + 1) % MAX_SIZE;
}

void front(Queue *queue) {
    if (isEmpty(queue)) {
        printf("EMPTY\n");
        return;
    }

    printf("%d\n", queue->data[queue->front]);
}

int size(Queue *queue) {
    if (isEmpty(queue))
        return 0;
    else if (queue->front <= queue->rear)
        return queue->rear - queue->front + 1;
    else
        return MAX_SIZE - queue->front + queue->rear + 1;
}

int main() {
    Queue queue;
    initializeQueue(&queue);

    int N, command, value;
    scanf("%d", &N);

    for (int i = 0; i < N; i++) {
        scanf("%d", &command);
        switch (command) {
            case 1:
                scanf("%d", &value);
                enqueue(&queue, value);
                break;
            case 2:
                dequeue(&queue);
                break;
            case 3:
                front(&queue);
                break;
            case 4:
                printf("%d\n", size(&queue));
                break;
        }
    }

    return 0;
}
