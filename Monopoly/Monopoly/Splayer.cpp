#include<iostream>
#include<string>
#include"Player.h"

using namespace std;

player::player(string n) {
	this->name = n;				// initilize players
	this->money = 1500;
	this->position = 0;
}

void player::setname(string n) {	// initilize setters
	this->name = n;
}
string player::getname() {			// initilize getters
	return name;
}
void player::setmoney(int m) {
	this->money = m;
}
int player::getmoney() {
	return money;
}
void player::setposition(int p) {
	this->position = p;
}
int player::getposition() {
	return position;
}