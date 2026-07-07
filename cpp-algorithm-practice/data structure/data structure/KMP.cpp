#include <iostream>
#include <string> 
#include <vector>
using namespace std;
vector<int>nex;//nex数组即next数组，因为c++存在同名情况，所以用nex表示 
void get_next(string ss)//获取next数组的函数 
{
	/*i指向已匹配字符串的下一个位置
	j指向最长公共前后缀的下一个位置 */
	int i, j;
	nex.resize(ss.length());//数组设置为字符串ss的大小 
	nex[0] = -1;//子串第一个位置前不存在已匹配的前后缀，所以置为-1 
	nex[1] = 0;//子串第二个位置前也不存在公共前后缀，但是置为0，方便后续操作 
	i = 2;
	j = 0;
	while (i < ss.length())
	{
		if (ss[i - 1] == ss[j])//相等则加1 
		{
			nex[i] = nex[i - 1] + 1;
			j++;
		}
		else
		{
			while (ss[i - 1] != ss[j] && j > 0)//不相等则回溯 
				j = nex[j];
			nex[i] = j;
		}
		i++;
	}
}
int main()
{
	string s, ss;
	int i, j, len_s, len_ss;
	cout << "enter the string:";
	cin >> s;
	cout << "enter the string:";
	cin >> ss;
	get_next(ss);
	i = j = 0;
	len_s = s.length();
	len_ss = ss.length();
	while (i < len_s && j < len_ss)
	{
		if (s[i] == ss[j] || j == -1)//j为-1时或字符匹配时的情况 
		{
			i++;
			j++;
		}
		else
			j = nex[j];//不匹配时则查询next数组 
	}
	if (j == ss.length())//此情况则说明匹配成功 
		cout << i - len_ss + 1;//输出子串在主串中的位置 
	else
		cout << "Not found";//匹配失败，找不到 
	return 0;
}