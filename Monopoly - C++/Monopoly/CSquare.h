#pragma once
#include<iostream>
#include<fstream>
#include<string>
#include<vector>
#include"Player.h"

using namespace std;

class CSquare {
public:
	vector<string> square;		// declare vector
	

	CSquare();		// constructor

	void read();	// declare funtion
	
	virtual int bonusroll();	// declare virtual funtions
	virtual int penaltyroll();
	virtual void display(string);
	virtual bool displaystation(string, int, player, player);
};

