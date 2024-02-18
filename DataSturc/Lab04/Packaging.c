#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 10010

typedef struct stack {
    int top;
    int* items;
} Stack;

int isStackEmpty(Stack* stack) {
    return stack->top == -1;
}

void push(Stack* stack, int item) {
    stack->items[++stack->top] = item;
}

int pop(Stack* stack) {
    if (isStackEmpty(stack)) {
        exit(1);
    }

    return stack->items[stack->top--];
}

int peek(Stack* stack) {
    if (isStackEmpty(stack)) {
        exit(1);
    }

    return stack->items[stack->top];
}

int calculatePackingCost(int costA, int costB, int costC, char items[MAX_SIZE]) {
    Stack* stack = (Stack*)malloc(sizeof(Stack));
    stack->top = -1;
    stack->items = (int*)calloc(MAX_SIZE, sizeof(int));

    for (size_t i = 0; items[i] != '\0'; i++) {
        char ch = items[i];

        if (ch == '[' || ch == '(' || ch == '{') {
            push(stack, -1);
        } else if (ch == ']' || ch == ')' || ch == '}') {
            int groupCost = 0;
            while (peek(stack) != -1) {
                groupCost += pop(stack);
            }
            pop(stack);

            char openingBracket = (ch == ']') ? '[' : (ch == ')') ? '(' : '{';
            switch (openingBracket) {
                case '[':
                    groupCost += groupCost * 0.1;
                    break;
                case '(':
                    groupCost += groupCost * 0.07;
                    break;
                case '{':
                    groupCost += groupCost * 0.05;
                    break;
            }

            push(stack, groupCost);
        } else {
            switch (ch) {
                case 'A':
                    push(stack, costA);
                    break;
                case 'B':
                    push(stack, costB);
                    break;
                case 'C':
                    push(stack, costC);
                    break;
            }
        }
    }

    int totalCost = 0;
    while (!isStackEmpty(stack)) {
        totalCost += pop(stack);
    }
    free(stack->items);
    free(stack);

    return totalCost;
}

int main() {
    int costA, costB, costC;
    scanf("%d %d %d", &costA, &costB, &costC);

    char items[MAX_SIZE];
    scanf("%s", items);

    int totalCost = calculatePackingCost(costA, costB, costC, items);
    printf("%d", totalCost);

    return 0;
}
