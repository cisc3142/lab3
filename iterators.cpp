#include <algorithm>
#include <iostream>
#include <vector>


template <class Iter>
void selectionSort(Iter begin, Iter end) {
	/*******Your code here********/

	/*****************************/
	/***Test code: do not modify***/
	typedef typename std::iterator_traits<Iter>::value_type value_type;
	std::vector<value_type> vv(begin, end);
	std::sort(begin, end);
	auto it1 = begin, it2 = vv.begin();
	while (it1 != end  && it2 != vv.end()) {
		if (*it1 != *it2) throw("Range not sorted\n");
		++it1; ++it2;
	}
	/*****************************/
}

template <class Iter>
void reverseRange(Iter begin, Iter end) {
	/***Test code: do not modify***/
	typedef typename std::iterator_traits<Iter>::value_type value_type;
	std::vector<value_type> vv(begin, end);
	/*****************************/
	/*******Your code here********/

	/*****************************/
	/***Test code: do not modify***/
	auto it1 = begin, it2 = vv.end();
	--it2;
	while (it1 != end) {
		if (*it1 != *it2) throw("Range not reversed\n");
		++it1; --it2;
	}
	/*****************************/
}

template <class Iter>
void printRange(Iter begin, Iter end) {
	/*******Your code here********/

	/*****************************/
}

int main() {

	std::vector<int> v;
	for (int i = 0; i < 23; i++) v.push_back(i);
	std::random_shuffle(v.begin(), v.end());

	bool errored = false;
	
	try {
		selectionSort(v.begin(), v.end());
	} catch (char const* err) {
		std::cout << err << std::endl;
		errored = true;
	}


	try {
		reverseRange(v.begin(), v.end());
	} catch (char const* err) {
		std::cout << err << std::endl;
		errored = true;
	}

	printRange(v.begin(), v.end());

	if (errored) exit(EXIT_FAILURE);
}
