#include <iostream>
#include <sstream>
#include <string>
#include "property.h"

using namespace std;

property::property() {
	split();
}

void property::split() {
	for (int i = 0; i < 26; i++) {			// go through each square
		string line = square[i];			// get single square detaile
		string arr[5];
		int j = 0;
		stringstream ssin(line);
		while (ssin.good() && j < 5) {		// split the line by space
			ssin >> arr[j];
			string word = arr[j];
			if (!isdigit(word[0]) && j > 1) {
				arr[j - 1] = arr[j - 1] + " " + word;
				arr[j] = "";
				ssin >> arr[j];
				word = arr[j];
				if (!isdigit(word[0]) && j > 1) {
					arr[j - 1] = arr[j - 1] + " " + word;
					arr[j] = "";
					ssin >> arr[j];
				}
			}
			++j;
		}
		int k = 0;
		square_type.push_back(stoi(arr[k]));		// save each deatil in vectors
		k++;
		square_name.push_back(arr[k]);
		k++;
		if (!arr[k].empty()) {
			square_cost.push_back(stoi(arr[k]));
			k++;
			square_rent.push_back(stoi(arr[k]));
			k++;
			color_group.push_back(stoi(arr[k]));
		}
		else {
			square_cost.push_back(0);			// if deatil empty
			square_rent.push_back(0);
			color_group.push_back(0);
		}
		property_owner.push_back("");			// set owner as empty
	}
}