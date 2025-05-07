#pragma once
#include <iostream>
#include <string>
#include "Data.h"													// Association with data

using namespace std;

class list
{
private:
	data *head, *tail;												// List pointers
public:
	list();															// Constructor
	bool isempty();													// Empty check
	void insert(string, string, string, string, string, string);	// New node in list
	int search(string);												// Search list node
	void display();													// Display list
};