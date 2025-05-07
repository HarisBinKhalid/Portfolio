#include <iostream>
#include <string>
#include "Data.h"													// Association with data

using namespace std;

class tree
{
private:
	data *root;														// Tree pointer
public:
	tree();															// Constructor
	bool isempty();													// Check empty
	void insert(string, string, string, string, string, string);	// New node in tree
	int search(string);												// Seach node in tree
	void inorder(data*);											// Tree sequence for display
	void display();													// Tree display
};