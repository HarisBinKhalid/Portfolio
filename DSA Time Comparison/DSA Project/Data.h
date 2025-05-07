#pragma once
#include <iostream>
#include <string>

using namespace std;

class data
{
private:
	string country, type, channel, order, id, ship;			// Data attributes

	data *next;												// Pointer for linked list
	data *right;											// Pointer for binary search tree
	data *left;
public:
	data();													// Default constructor
	data(string, string, string, string, string, string);	// parameterized constructor

	void setcountry(string);								// Attribute setter
	string getcountry();									// Attribute getter
	void settype(string);
	string gettype();
	void setchannel(string);
	string getchannel();
	void setorder(string);
	string getorder();
	void setid(string);
	string getid();
	void setship(string);
	string getship();
	void setnext(data*);									// List pointer setter
	data *getnext();										// List pointer getter
	void setright(data*);									// Tree pointer setter
	data *getright();										// Tree pointer getter
	void setleft(data*);
	data *getleft();
};