#pragma once
#include <iostream>
#include <string>
#include "CSquare.h"
#include "Player.h"

using namespace std;

class station : public CSquare {
public:
	bool displaystation(string, int, player, player); // declare funtion
};