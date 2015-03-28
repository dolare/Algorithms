#include "vector"
#include "iostream"
using namespace std;

 
class MaxHeap{
private:
	vector<int> items;

public:
	int size();
	void softDown();
	void softUp();
	void insert(const int& item);
	int peekMax();
	void removeMax();
	void toString();
	//void toString_Queue();
	bool isEmpty();

};

bool MaxHeap::isEmpty(){
	return items.empty();
}

void MaxHeap::toString(){
	for (int i = 0; i < items.size(); i++){
		cout << items[i] << " ";
	}
	cout << endl;
}


int MaxHeap::size(){
	return items.size();
}

 
void MaxHeap::softUp(){
	int k = items.size() - 1;
	while (k > 0){
		int p = (k - 1) / 2;
		int child = items[k];
		int parent = items[p];
		if (child > parent){
			items[k] = parent;
			items[p] = child;
			k = p;
		}else break;
	}
}

 
void MaxHeap::softDown(){
	int parent = 0;
	int child1 = parent * 2 + 1;

	while (child1 < items.size()){
		int max = child1;
		int child2 = child1 + 1;
		if (child2 < items.size()){
			if (items[child2] > items[child1]){
				max = child2;
			}
		}
		
		if (items[parent] < items[max]){
			int temp = items[parent];
			items[parent] = items[max];
			items[max] = temp;
			parent = max;
			child1 = 2 * parent + 1;
		}else break;
	}
}

 
void MaxHeap::insert(const int& item){
	items.push_back(item);
	softUp();
}

 
int MaxHeap::peekMax(){
	return items[0];
}

 
void MaxHeap::removeMax(){
	if (items.size() == 0){
		throw new exception();
	}
	items[0] = items.back();
	items.pop_back();
	softDown();
}


int main(){

	MaxHeap maxHeap;
	for (int i = 0; i <= 10; i++){
		maxHeap.insert(i);
	}
	maxHeap.removeMax();
	cout << maxHeap.peekMax() << endl;
	maxHeap.toString();
	cout << maxHeap.isEmpty() << endl;
	/*for (int i = 0; i <= 9; i++){
		maxHeap.removeMax();
	}
	cout << maxHeap.isEmpty() << endl;*/
	while (!maxHeap.isEmpty()){
		cout << maxHeap.peekMax() << endl;
		maxHeap.removeMax();
	}
		
}
