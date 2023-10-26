#pragma once
#include<iostream>
#include<string>

using namespace std;

class player {
private:
	string name;			// declare attributes
	int money;
	int position;
public:
	player(string n);		// constructor

	void setname(string n);	// declare setter
	string getname();		// declare getter
	void setmoney(int m);
	int getmoney();
	void setposition(int p);
	int getposition();
};