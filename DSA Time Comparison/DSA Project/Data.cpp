#include <iostream>
#include <string>
#include "Data.h"					// Custom data class

using namespace std;

data::data()						// Constructor
{
	country = "";
	type = "";
	channel = "";
	order = "";
	id = "";
	ship = "";
	next = NULL;
	right = NULL;
	left = NULL;
}
data::data(string co, string t, string ch, string o, string i, string s)
{
	this->country = co;
	this->type = t;
	this->channel = ch;
	this->order = o;
	this->id = i;
	this->ship = s;
	this->next = NULL;
	this->right = NULL;
	this->left = NULL;
}

void data::setcountry(string co)	// Attribute Setter
{
	this->country = co;
}
string data::getcountry()			// Attribute Getter
{
	return country;
}
void data::settype(string t)
{
	this->type = t;
}
string data::gettype()
{
	return type;
}
void data::setchannel(string ch)
{
	this->channel = ch;
}
string data::getchannel()
{
	return channel;
}
void data::setorder(string o)
{
	this->order = o;
}
string data::getorder()
{
	return order;
}
void data::setid(string i)
{
	this->id = i;
}
string data::getid()
{
	return id;
}
void data::setship(string s)
{
	this->ship = s;
}
string data::getship()
{
	return ship;
}
void data::setnext(data *n)			// List pointer setter
{
	this->next = n;
}
data *data::getnext()				// List pointer getter
{
	return next;
}
void data::setright(data *r)		// Tree pointer setter
{
	this->right = r;
}
data* data::getright()				// Tree pointer getter
{
	return right;
}
void data::setleft(data *l)
{
	this->left = l;
}
data* data::getleft()
{
	return left;
}