#include<iostream>
#include<sstream>
#include<string>
#include"CSquare.h"

using namespace std;

CSquare::CSquare() {		// constructor
	read();
}

void CSquare::read() {		// file reading funtion
	string line;
	ifstream infile;

	infile.open("monopolish.txt");		// open file
	if (infile.is_open()) {
		int i = 0;
		while (!infile.eof()) {
			getline(infile, line);		// read each line
			square.push_back(line);		// save in vector
			i++;
		}
	}
	infile.close();			// close file
}

int CSquare::bonusroll() {		// virtual funtions
	return 0;
}
int CSquare::penaltyroll() {
	return 0;
}
void CSquare::display(string n) {
}
bool CSquare::displaystation(string o, int n, player p1, player p2) {
	return false;
}