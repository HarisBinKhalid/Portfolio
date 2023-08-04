#pragma once
#include <iostream>
#include <string>
#include "CSquare.h"

using namespace std;

class property : CSquare {
public:
	vector<int> square_type;		// declare vector
	vector<string> square_name;
	vector<int> square_cost;
	vector<int> square_rent;
	vector<int> color_group;
	vector<string> property_owner;

	property();						// constructor

	void split();
};