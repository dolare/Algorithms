#include <vector>
#include <unordered_map>
#include <iostream>
using namespace std;
class Solution {
public:
	vector<int> sl;
	vector<int> twoSum(vector<int> &num, int target) {
		unordered_map<int, int> mapping;
		vector<int> result;
		for (int i = 0; i < num.size(); i++) {
			mapping[num[i]] = i;
		}
		for (int i = 0; i < num.size(); i++) {
			const int gap = target - num[i];
			if (mapping.find(gap) != mapping.end() && mapping[gap] > i) {
				result.push_back(i + 1);
				result.push_back(mapping[gap] + 1);
				break;
			}
		}
		return result;
	}
public:
	Solution(vector<int> &num, int target){
		this->sl = twoSum(num, target);
	}

};

int main(){
	vector<int> v = { 1, 2, 3, 4 };
	Solution s(v, 4);
	for (int i = 0; i < s.sl.size(); ++i){
		cout << s.sl[i] << " "<<endl;
	}
	// new Solution().twoSum({ 1, 2, 4, 9 }, 6);
	 return 0;
}