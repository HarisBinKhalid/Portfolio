#pragma once
class random {
	public:
		int turns[20];			// declare attribute
		random();
		int gen_Random();		// declare funtions
		void return_random();
		void set_turns();
		void display_turns();
		int roll();
};