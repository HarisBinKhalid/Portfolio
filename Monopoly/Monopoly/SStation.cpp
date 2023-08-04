#include <iostream>
#include <string>
#include "Station.h"

using namespace std;

bool station::displaystation(string owner, int new_position, player player1, player player2) {
	int amount1 = player1.getmoney();		// get player money
	int amount2 = player2.getmoney();
	int rent = 10;
	int cost = 200;
	if (amount1 > 0) {						// check money is positive
		if (owner.empty()) {				// station not owned
			amount1 -= cost;				// reduce cost of station
			player1.setmoney(amount1);		// set new money
			cout << player1.getname() << " buys station for cost " << cost << endl;
			return true;
		}
		else if (owner != player1.getname()) {	// station owned
			amount1 -= rent;					// pay rent
			player1.setmoney(amount1);
			amount2 += rent;					// receive rent
			player2.setmoney(amount2);
			cout << player1.getname() << " pays " << rent << endl;
		}
	}
	return false;
}