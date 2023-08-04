#include <iostream>
#include <ctime>
#include "Random.h"
#include <fstream>
#include <string>
using namespace std;

// Returns a random number in the range 1 .. 6
// Note that I am using casting to convert one data type to another

random::random(){
	this->set_turns();
}
int random::gen_Random()
{
	return static_cast<int>( static_cast<double> (rand()) / (RAND_MAX + 1) * 6.0f + 1 );
}


void random::return_random()
{
	// A random number generator actually produces a pseudo-random sequence of numbers.
	// This means that the random number generator will always produce the same sequence of numbers.
	// The generator needs to be "seeded" with a value. You seed the generator with the function srand().
	// If you want to create a different sequence of numbers each time then seed it with the time as follows:
	/*srand( static_cast<unsigned int> (time(0)) );
	// The output of time() is time_t (which is actually an int).
	// static_cast<unsigned int> merely converts the output of time() into an unsigned integer.
	for( int i = 0; i < 10; i++ )
	{
		cout << Random() << endl;
	}
	cout << endl;*/

	// However, if you seed the generator with the same value each time then it will always produce
	// the same sequence of numbers. You want this to occur with the Monopoly program.
	// The next bit of code does this:
	
	/*string line;
	ifstream infile;
	infile.open("seed.txt");
	getline(infile, line);
	char seed_value = line[0];
	cout << seed_value;
	infile.close();*/
	
}
void random::set_turns() {
	srand(7);
	for (int i = 0; i < 20; i++) {
		this->turns[i] = gen_Random();
	}
}

void random::display_turns() {
	
	for (int i = 0; i < 20; i++) {
		cout<< this->turns[i]<<endl;
	}
}

int random::roll() {
	return gen_Random();
}
