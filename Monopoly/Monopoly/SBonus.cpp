#include <iostream>
#include <string>
#include "Bouns.h"
#include "Random.h"

using namespace std;

int bonus::bonusroll() {
	random r;
	int roll = r.roll();		// get random number

	if (roll = 1) {				// check roll
		cout << "Find some money. Gain £20" << endl;
		return 20;
	}
	else if (roll = 2) {
		cout << "Win a coding competition. Gain £50 " << endl;
		return 50;
	}
	else if (roll = 3) {
		cout << "Receive a rent rebate. Gain £100 " << endl;
		return 100;
	}
	else if (roll = 4) {
		cout << "Win the lottery. Gain £150 " << endl;
		return 150;
	}
	else if (roll = 5) {
		cout << "Sell your iPad. Gain £200 " << endl;
		return 200;
	}
	else {
		cout << "It’s your birthday. Gain £300 " << endl;
		return 300;
	}
}