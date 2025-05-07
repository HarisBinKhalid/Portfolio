#include <iostream>
#include <string>
#include "List.h"										// Including list class

using namespace std;

list::list()
{
	head = NULL;
	tail = NULL;
}
bool list::isempty()
{
	if (head == NULL)									// If empty
	{
		return true;
	}
	else
	{
		return false;
	}
}
void list::insert(string co, string t, string ch, string o, string i, string s)
{
	if (isempty())										// No node in list
	{
		data *temp = new data(co, t, ch, o, i, s);		// First node
		head = temp;									// Point head
		tail = temp;									// Point tail
	}
	else
	{
														// One or more node in list
	}
	{
		data *temp = new data(co, t, ch, o, i, s);		// New node
		tail->setnext(temp);							// Set tail
		tail = temp;									// Point tail
	}
}
int list::search(string s)
{
	data *temp = head;
	while (temp != NULL)								// Loop till end of list
	{
		if (temp->getid() == s)							// Search match
		{
			cout << temp->getcountry() << "\t" << temp->gettype() << "\t" << temp->getchannel() << "\t" << temp->getorder() << "\t" << temp->getid() << "\t" << temp->getship() << "\t" << endl;
			return 0;
		}
		else											// Get next node
		{
			temp = temp->getnext();
		}
	}	return 1;
}
void list::display()
{
	if (isempty())
	{
		cout << "\nList is Empty." << endl << endl;
	}
	else
	{
		system("CLS");
		data *temp = head;
		cout << "LIST:" << endl << endl;
		
		cout << "Country\tItem Type\tSales Channel\tOrder Date\tOrder ID\tShip Date" << endl;
		while (temp != NULL)							// Loop to display all
		{
			cout << temp->getcountry() << "\t" << temp->gettype() << "\t" << temp->getchannel() << "\t" << temp->getorder() << "\t" << temp->getid() << "\t" << temp->getship() << "\t" << endl;
			temp = temp->getnext();
		}
	}
}