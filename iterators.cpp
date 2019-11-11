#include <algorithm>
#include <iostream>
#include <vector>

template <class T>
void selectionSort(std::vector<T>& v) {
	/*******Your code here********/

	/*****************************/
	/***Test code: do not modify***/
	std::vector<T> vv(v);
	std::sort(vv.begin(), vv.end());
	auto it1 = v.begin(), it2 = vv.begin();
	while (it1 != v.end() && it2 != vv.end()) {
		if (*it1 != *it2) throw("List not sorted\n");
		++it1; ++it2;
	}
	/*****************************/
}

template <class T>
void reverseList(std::vector<T>& v) {
	/***Test code: do not modify***/
	std::vector<T> vv(v);
	/*****************************/
	/*******Your code here********/

	/*****************************/
	/***Test code: do not modify***/
	auto it1 = v.begin(), it2 = vv.end();
	--it2;
	while (it1 != v.end()) {
		if (*it1 != *it2) throw("List not reversed\n");
		++it1; --it2;
	}
	/*****************************/
}

template <class T>
void removeEveryOtherELement(std::vector<T>& v) {
	/***Test code: do not modify***/
	std::vector<T> vv(v);
	/*****************************/
	/*******Your code here********/
	// Remove every *odd* element (at index 1, 3, ...)

	/*****************************/
	/***Test code: do not modify***/
	auto it1 = v.begin(), it2 = vv.begin();
	while (it1 != v.end() && it2 != vv.end()) {
		if (*it1 != *it2) throw("Even indices not equal\n");
		++it1; ++it2;
		if (it1 == v.end()) break;
		if (*it1 == *it2) throw("Odd index not removed\n");
		++it1;
	}
	/*****************************/
}

void printList(const std::vector<int>& v) {
	for  (int x : v) std::cout << x << " ";
	std::cout << std::endl;
}

void fillList(std::vector<int>& v) {
	for (int i = 0; i < 23; i++) v.push_back(i);
	std::random_shuffle(v.begin(), v.end());
}

int main() {

	std::vector<int> v;
	fillList(v);
	
	try {
		selectionSort(v);
	} catch (char const* err) {
		std::cout << err << std::endl;
	}

	try {
		removeEveryOtherELement(v);
	} catch (char const* err) {
		std::cout << err << std::endl;
	}

	try {
		reverseList(v);
	} catch (char const* err) {
		std::cout << err << std::endl;
	}
}
