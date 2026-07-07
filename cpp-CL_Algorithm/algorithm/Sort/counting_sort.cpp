#include<iostream>
#include<vector>
using namespace  std;
// Created by Administrator on 2023/8/1.
//
/* 计数排序 */
// 简单实现，无法用于排序对象
void countingSortNaive(vector<int> &nums) {
    // 1. 统计数组最大元素 m
    int m = 0;
    for (int num : nums) {
        m = max(m, num);
    }
    // 2. 统计各数字的出现次数
    // counter[num] 代表 num 的出现次数
    vector<int> counter(m + 1, 0);
    for (int num : nums) {
        counter[num]++;
    }
    // 3. 遍历 counter ，将各元素填入原数组 nums
    int i = 0;
    for (int num = 0; num < m + 1; num++) {
        for (int j = 0; j < counter[num]; j++, i++) {
            nums[i] = num;
        }
    }
    auto it = nums.begin();
    for (it; it != nums.end(); it++) cout << *it << " ";
    cout << endl;
}
int main() {
    int n[] = {3,1,7,5,2,4,9,6};
    vector<int> nums1(n,n+8);
    countingSortNaive(nums1);
    return 0;
}