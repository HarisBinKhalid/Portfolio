#include <iostream>
#include <string>
#include "Tree.h"											// Including tree class

using namespace std;

tree::tree()
{
	root = NULL;
}
bool tree::isempty()
{
	if (root == NULL)										// If empty
	{
		return true;
	}
	else
	{
		return false;
	}
}
void tree::insert(string co, string t, string ch, string o, string i, string s)
{
	if (isempty())											// If no node exists in tree
	{
		data *temp = new data(co, t, ch, o, i, s);
		root = temp;
	}
	else													// One or more node exists in tree
	{
		data *temp = root;									// Initial node
		data *parent = NULL;								// Node parent
		while (temp != NULL)								// Loop till end of list
		{
			if (temp->getid() == i)							// If same node exists 
			{
				return;
			}
			else if (temp->getid() > i)						// If node smaller goes left
			{
				parent = temp;
				temp = temp->getleft();
			}
			else if (temp->getid() < i)						// If node larger goes right
			{
				parent = temp;
				temp = temp->getright();
			}
		}
		data *newnode = new data(co, t, ch, o, i, s);		// New node
		if (parent->getid() > i)							// If smaller new node added to left of parent
		{
			parent->setleft(newnode);
		}
		else if (parent->getid() < i)						// If larger new node added to right of parent
		{
			parent->setright(newnode);
		}
	}
}
int tree::search(string s)
{
	data *temp = root;
	while (temp != NULL)									// Loop till end of list
	{
		if (temp->getid() == s)								// If search match
		{
			cout << temp->getcountry() << "\t" << temp->gettype() << "\t" << temp->getchannel() << "\t" << temp->getorder() << "\t" << temp->getid() << "\t" << temp->getship() << "\t" << endl;
			return 0;
		}
		else if (temp->getid() > s)							// If search smaller search left
		{
			temp = temp->getleft();
		}
		else if (temp->getid() < s)							// If search larger search right
		{
			temp = temp->getright();
		}
	}
	return 1;
}
void tree::inorder(data *n)
{
	if (n != NULL)											// Loop to display all
	{
		inorder(n->getleft());								// Recurtion with get left
		cout << n->getcountry() << "\t" << n->gettype() << "\t" << n->getchannel() << "\t" << n->getorder() << "\t" << n->getid() << "\t" << n->getship() << "\t" << endl;
		inorder(n->getright());								// Recurtion with get right
	}
}
void tree::display()
{
	cout << "Display:" << endl << endl;
	cout << "Country\tItem Type\tSales Channel\tOrder Date\tOrder ID\tShip Date" << endl;
	inorder(root);											// display all tree in assending order
}