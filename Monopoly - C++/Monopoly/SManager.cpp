#include <iostream>
#include <string>
#include "Manager.h"


manager::manager() {
	c.push_back(&j);		// add object pointers to vector
	c.push_back(&gtj);
	c.push_back(&fp);
	c.push_back(&s);
	c.push_back(&b);
	c.push_back(&pe);
}

void manager::game() {
	player player1("Hamster");		// player names
	player player2("Pumpkin");
	cout << "Welcome to Monopl-ish" << endl << endl;
	int round = 0;
	int x = 0;
	while (x < 2) {
		for (int i = 0; i < 20; i++) {			// number of round
			if ((i % 2) == 0) {					// player 1 turn
				round++;
				cout << "Round " << round << endl;
				int roll = r.turns[i];		// getting rendom rolls
				cout << player1.getname() << " rolls " << roll << endl;
				int new_position = player1.getposition() + roll;		// moving player
				player1.setposition(new_position);		// setting player position

				if (new_position > 25) {				// board round completed once
					player1.setposition(-1);
					int roll_left = new_position - 25;
					new_position = player1.getposition() + roll_left;
					player1.setposition(new_position);

					player1.setmoney(player1.getmoney() + 200);		// playyer rewared for completeing round
					cout << player1.getname() << " passes GO and collects £200" << endl;
				}
				cout << player1.getname() << " lands on " << p.square_name[new_position] << endl;

				if (p.square_type[new_position] == 1) {			// player location property
					int amount1 = player1.getmoney();
					int amount2 = player2.getmoney();
					int rent = p.square_rent[new_position];
					if (amount1 > 0) {							// check for positive player money
						if (p.property_owner[new_position].empty()) {	// property not owned
							amount1 -= p.square_cost[new_position];		// reduce cost
							player1.setmoney(amount1);
							p.property_owner[new_position] = player1.getname();		// property owed
							cout << player1.getname() << " buys " << p.square_name[new_position] << " for cost " << p.square_cost[new_position] << endl;
						}
						else if (p.property_owner[new_position] != player1.getname()) {	// property owwned by another player
							int color = p.color_group[new_position];
							string owner = p.property_owner[new_position];
							if (color == p.color_group[new_position - 1]) {				// if same color owned by same player for double rent
								if (owner == p.property_owner[new_position - 1]) {
									rent *= 2;
								}
							}
							else if (color == p.color_group[new_position + 1]) {
								if (owner == p.property_owner[new_position + 1]) {
									rent *= 2;
								}
							}
							else if (color == p.color_group[new_position + 1] && color == p.color_group[new_position - 1]) {
								if (owner == p.property_owner[new_position + 1] && owner == p.property_owner[new_position - 1]) {
									rent *= 2;
								}
							}
							else if (color == p.color_group[new_position + 1] && color == p.color_group[new_position + 2]) {
								if (owner == p.property_owner[new_position + 1] && owner == p.property_owner[new_position + 2]) {
									rent *= 2;
								}
							}
							else if (color == p.color_group[new_position - 1] && color == p.color_group[new_position - 2]) {
								if (owner == p.property_owner[new_position - 1] && owner == p.property_owner[new_position - 2]) {
									rent *= 2;
								}
							}

							amount1 -= rent;								// pay rent
							player1.setmoney(amount1);
							amount2 += rent;								// receive rent
							player2.setmoney(amount2);
							cout << player1.getname() << " pays " << rent << endl;
						}
					}
				}
				else if (p.square_type[new_position] == 3) {			// player location station
					if (c[3]->displaystation(p.property_owner[new_position], new_position, player1, player2)) {
						p.property_owner[new_position] = player1.getname();
					}
				}
				else if (p.square_type[new_position] == 4) {		// player location bonus

					int amount = player1.getmoney();
					int gain = c[4]->bonusroll();					// random roll for bonus
					amount += gain;									// receive bonus
					player1.setmoney(amount);
				}
				else if (p.square_type[new_position] == 5) {		// player location penalty
					int amount = player1.getmoney();
					int gain = c[5]->penaltyroll();					// random roll for penalty
					amount -= gain;									// pay penalty
					player1.setmoney(amount);
				}
				else if (p.square_type[new_position] == 6) {		// player location jail
					c[0]->display(player1.getname());
				}
				else if (p.square_type[new_position] == 7) {		// player location go to jail
					int amount = player1.getmoney();
					amount -= 50;									// pay jail fine
					player1.setposition(6);
					player1.setmoney(amount);

					c[1]->display(player1.getname());
				}
				else if (p.square_type[new_position] == 8) {		// player location free parking
					c[2]->display(player1.getname());
				}
				cout << player1.getname() << " has " << player1.getmoney() << endl;
			}
			else {
				cout << "Round " << round << endl;
				int roll = r.turns[i];									// everything same repeats but for player 2
				cout << player2.getname() << " rolls " << roll << endl;
				int new_position = player2.getposition() + roll;
				player2.setposition(new_position);

				if (new_position > 25) {
					player2.setposition(-1);
					int roll_left = new_position - 25;
					new_position = player2.getposition() + roll_left;
					player2.setposition(new_position);

					player2.setmoney(player2.getmoney() + 200);
					cout << player2.getname() << " passes GO and collects £200" << endl;
				}
				cout << player2.getname() << " lands on " << p.square_name[new_position] << endl;

				if (p.square_type[new_position] == 1) {
					int amount1 = player2.getmoney();
					int amount2 = player1.getmoney();
					int rent = p.square_rent[new_position];
					if (amount1 > 0) {
						if (p.property_owner[new_position].empty()) {
							amount1 -= p.square_cost[new_position];
							player2.setmoney(amount1);
							p.property_owner[new_position] = player2.getname();
							cout << player2.getname() << " buys " << p.square_name[new_position] << " for cost " << p.square_cost[new_position] << endl;
						}
						else if (p.property_owner[new_position] != player2.getname()) {
							int color = p.color_group[new_position];
							string owner = p.property_owner[new_position];
							if (color == p.color_group[new_position - 1]) {
								if (owner == p.property_owner[new_position - 1]) {
									rent *= 2;
								}
							}
							else if (color == p.color_group[new_position + 1]) {
								if (owner == p.property_owner[new_position + 1]) {
									rent *= 2;
								}
							}
							else if (color == p.color_group[new_position + 1] && color == p.color_group[new_position - 1]) {
								if (owner == p.property_owner[new_position + 1] && owner == p.property_owner[new_position - 1]) {
									rent *= 2;
								}
							}
							else if (color == p.color_group[new_position + 1] && color == p.color_group[new_position + 2]) {
								if (owner == p.property_owner[new_position + 1] && owner == p.property_owner[new_position + 2]) {
									rent *= 2;
								}
							}
							else if (color == p.color_group[new_position - 1] && color == p.color_group[new_position - 2]) {
								if (owner == p.property_owner[new_position - 1] && owner == p.property_owner[new_position - 2]) {
									rent *= 2;
								}
							}

							amount1 -= rent;
							player2.setmoney(amount1);
							amount2 += rent;
							player1.setmoney(amount2);
							cout << player2.getname() << " pays " << rent << endl;
						}
					}
				}
				else if (p.square_type[new_position] == 3) {
					if (c[3]->displaystation(p.property_owner[new_position], new_position, player2, player1)) {
						p.property_owner[new_position] = player2.getname();
					}
				}
				else if (p.square_type[new_position] == 4) {
					int amount = player2.getmoney();
					int gain = c[4]->bonusroll();
					amount += gain;
					player2.setmoney(amount);
				}
				else if (p.square_type[new_position] == 5) {
					int amount = player2.getmoney();
					int gain = c[5]->penaltyroll();
					amount -= gain;
					player2.setmoney(amount);
				}
				else if (p.square_type[new_position] == 6) {
					c[0]->display(player2.getname());
				}
				else if (p.square_type[new_position] == 7) {
					int amount = player2.getmoney();
					amount -= 50;
					player2.setposition(6);
					player2.setmoney(amount);

					c[1]->display(player2.getname());
				}
				else if (p.square_type[new_position] == 8) {
					c[2]->display(player2.getname());
				}
				cout << player2.getname() << " has " << player2.getmoney() << endl;
			}


			cout << endl;


		}
		x++;
	}

	cout << endl << "GAME OVER" << endl;									// game end
	cout << player1.getname() << " has £" << player1.getmoney() << endl;	// player progress
	cout << player2.getname() << " has £" << player2.getmoney() << endl;

	if (player1.getmoney() > player2.getmoney()) {							// winning player
		cout << player1.getname() << " wins." << endl;
	}
	else if (player1.getmoney() < player2.getmoney()) {
		cout << player2.getname() << " wins." << endl;
	}
	else {
		cout << "It's a draw." << endl;
	}

	cout << endl;
}