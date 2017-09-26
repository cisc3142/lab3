#include <assert.h>
#include <iostream>
#include <time.h>
#include <list>
#include <vector>

#include "llist.h"
#include "timing.h"

#define ARRSIZE 100000

template <class Iter>
void selectionSort(Iter, Iter);	// implement

struct time {
	uint64 start;
	std::string name;
	time(const std::string& str="") : start(GetTimeMs64()), name(str) {}
	void getTimeElapsed() { 
		std::cout << name << "... " << GetTimeMs64() - start << std::endl; 
	}
	void startAgain(const std::string& str="") {
		start = GetTimeMs64();
		name = str;
	}
};


int main(int argc, char** argv) {
	// generate random array
	srand (time(NULL));
	int arr[ARRSIZE];
	for (int i = 0; i < ARRSIZE; i++) {
		arr[i] = rand() % 100;
	}

	// vector
	std::vector<int> vec, vec2;
	struct time t("filling vector");
	for (int i = 0; i < ARRSIZE; i++) vec.push_back(arr[i]);
	t.getTimeElapsed();
	vec2 = vec;

	t.startAgain("sorting vector");
	selectionSort(vec.begin(), vec.end());
	t.getTimeElapsed();

	// singly linked list
	List<int> lst;
	t.startAgain("filling list");
	for (int i = 0; i < ARRSIZE; i++) lst.push_front(arr[i]);
	t.getTimeElapsed();

	t.startAgain("sorting list");
	selectionSort(lst.begin(), lst.end());
	t.getTimeElapsed();

	// doubly linked list
	List<int> dlst;		// TODO: change to DList 
	t.startAgain("filling dlist");
	for (int i = 0; i < ARRSIZE; i++) dlst.push_front(arr[i]);
	t.getTimeElapsed();

	t.startAgain("sorting dlist");
	selectionSort(dlst.begin(), dlst.end());
	t.getTimeElapsed();

	// check sort
	std::sort(vec2.begin(), vec2.end());
	assert(vec==vec2);

	std::list<int> stlist;
	for (int i = 0; i < ARRSIZE; i++) { stlist.push_front(arr[i]); }
	stlist.sort();
	auto dit = dlst.begin();
	auto stlit = stlist.begin();
	while (dit != dlst.end() && stlit != stlist.end()) {
		assert(*dit == *stlit);
		++dit; ++stlit;
	}
}

// TODO: fill in with selection sort implementation
template <class Iter>
void selectionSort(Iter begin, Iter end) {
	
}
