#pragma once
#include <iostream>
#include <string>
#include <vector>
#include "Freeparking.h"		// include all classes
#include "property.h"
#include "Gotojail.h"
#include "CSquare.h"
#include "Station.h"
#include "Penalty.h"
#include "Player.h"
#include "Random.h"
#include "Bouns.h"
#include "Jail.h"

class manager {
public:
	vector<CSquare*> c;			// vector of derived class objects
	freeparking fp;				// objects of classes
	gotojail gtj;
	property p;
	CSquare cs;
	penalty pe;
	station s;
	random r;
	bonus b;
	jail j;
	
	manager();			// constructor

	void game();		// main game function
};