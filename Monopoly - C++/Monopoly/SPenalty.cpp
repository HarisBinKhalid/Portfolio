#include <iostream>
#include <string>
#include "Penalty.h"
#include "Random.h"

using namespace std;

int penalty::penaltyroll() {
	random r;
	int roll = r.roll();		// get random number from random.cpp

	if (roll = 1) {				// check roll
		cout << "Buy a coffee in Starbucks. Lose £20" << endl;
		return 20;
	}
	else if (roll = 2) {
		cout << "Pay your broadband bill. Lose £50 " << endl;
		return 50;
	}
	else if (roll = 3) {
		cout << "Visit the SU shop for food. Lose £100 " << endl;
		return 100;
	}
	else if (roll = 4) {
		cout << "Buy an assignment solution. Lose £150 " << endl;
		return 150;
	}
	else if (roll = 5) {
		cout << "Go for a romantic meal. Lose £200 " << endl;
		return 200;
	}
	else {
		cout << "Pay some university fees. Lose £300 " << endl;
		return 300;
	}
}