#include <stdio.h>

void arr_out(int a[8])//输出函数
{
    int i = 0;
    for (i = 0; i < 8; i++)
    {
        printf("%d ", a[i]);
    }
    printf("\n");
}

void arr_sort(int* p, int n)
{
    int i, j;
    int min = 0;
    for (i = 0; i < n - 1; i++)//排序次数
    {
        min = i;
        for (j = i + 1; j < n; j++)
        {
            if (p[j] < p[min])
            {
                min = j;//记录交换的元素下标值
            }
        }
        if (i != min)
        {
            int temp = p[i];
            p[i] = p[min];
            p[min] = temp;
        }
    }
}

int main()
{
    int a[8] = { 0 };
    int i = 0;
    for (i = 0; i < 8; i++)
    {
        scanf_s("%d", &a[i]);
    }

    arr_sort(a, 8);//排序函数
    arr_out(a);//输出函数

    return 0;
}