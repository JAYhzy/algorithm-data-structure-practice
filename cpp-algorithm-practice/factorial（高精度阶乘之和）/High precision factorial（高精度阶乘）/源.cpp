#include<cstring>
#include<iostream>
#define maxn 3000
int f[maxn];
using namespace std;

int main()
{
    int i, j, n;
    cin >> n;
    memset(f, 0, sizeof(f));//将其中内存置于0
    f[0] = 1;//初始置于1
    for (i = 2; i <= n; i++)
    {
        int jinwei = 0;//定义进位初始为0
        for (j = 0; j < maxn; j++)
        {
            int s = f[j] * i + jinwei;//乘法结果为乘完加之前的进位
            f[j] = s % 10; //（如果相乘不是个位数，则取得个位）
            jinwei = s / 10;//获得进位数
        }
    }
    /*下面这部分为了获取有多少位是有用的*/
    for (j = maxn - 1; j >= 0; j--)
        if (f[j] != 0)
            break;
    for (i = j; i >= 0; i--)
    {
        cout << f[i];
    }
}


