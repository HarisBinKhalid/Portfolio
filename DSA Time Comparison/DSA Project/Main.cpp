#include <iostream>
#include <fstream>
#include <string>
#include <conio.h>
#include <cstdio>
#include <ctime>
#include "List.h"																// Including list class
#include "Tree.h"																// Including tree class

using namespace std;

list l;																			// List class object
tree t;																			// Tree Class object

int main()
{
	double listtime = 0;
	double treetime = 0;
	do
	{
		int choice = 0;
		cout << "MENU" << endl << endl;
		cout << "1.Insert data in Linked List and Binary Search Tree." << endl;
		cout << "2.Search data in Linked List and Binary Search Tree." << endl;
		cout << "3.Display DataSet." << endl;
		cout << "4.Exit." << endl;
		cout << "Choice: ";
		cin >> choice;

		system("CLS");
		switch (choice)															// Switch for menu
		{
		case 1:
		{
				  cout << "DATA: " << endl << endl;
			{
				int count = 0;
				string country, type, channel, order, id, ship = "";

				ifstream file("DataSet.csv");									// Opening data file

				if (file.is_open())												// If open
				{
					cout << "Loading Data in Linked List...";
					while (!file.eof())											// Loop till end of file
					{
						if (count == 0)											// To skip index 0
						{
							string temp;
							getline(file, temp);
							count = 1;
						}
						else
						{
							getline(file, country, ',');						// Retriving data from file
							getline(file, type, ',');
							getline(file, channel, ',');
							getline(file, order, ',');
							getline(file, id, ',');
							getline(file, ship, '\n');

							l.insert(country, type, channel, order, id, ship);	// Adding data to list
						}
					}
					cout << "\nData Loaded in Linked List, press enter.";
				}
				else
				{
					cout << "File not Found/Open." << endl;
				}
			}
			{
				  int count = 0;
				  string country, type, channel, order, id, ship = "";

				  ifstream file("DataSet.csv");

				  if (file.is_open())
				  {
					  cout << "\n\nLoading Data in Binary Search Tree...";
					  while (!file.eof())
					  {
						  if (count == 0)
						  {
							  string temp;
							  getline(file, temp);
							  count = 1;
						  }
						  else
						  {
							  getline(file, country, ',');
							  getline(file, type, ',');
							  getline(file, channel, ',');
							  getline(file, order, ',');
							  getline(file, id, ',');
							  getline(file, ship, '\n');

							  t.insert(country, type, channel, order, id, ship);	// Adding data to tree
						  }
					  }
					  cout << "\nData Loaded in Binary Search Tree, press enter.";
					  _getch();
				  }
				  else
				  {
					  cout << "File not Found/Open." << endl;
					  _getch();
				  }
			}
				  system("CLS");
				  break;
		}
		case 2:
		{
				  listtime = 0;
				  treetime = 0;
				  cout << "SEARCH:" << endl << endl;
				  string search = "";
				  cout << "Search ID: ";
				  getline(cin.ignore(), search);									// User input for search
			{
				  clock_t start;													// Variable of type time
				  double duration;													// Variable to store time
				  start = clock();													// Storing time before function
				  int s = l.search(search);											// Calling search function
				  duration = (clock() - start) / (double)CLOCKS_PER_SEC;			// Subtraction time after function from time before function

				  if (s == 0)
				  {
					  cout << "Found in List." << endl;
				  }
				  else if (s == 1)
				  {
					  cout << "Not Found" << endl;
				  }
				  listtime = duration;
				  cout << "List Time: " << duration << endl << endl;
			}
			{
				  clock_t start;
				  double duration;
				  start = clock();
				  int s = t.search(search);
				  duration = (clock() - start) / (double)CLOCKS_PER_SEC;

				  if (s == 0)
				  {
					  cout << "Found in Tree." << endl;
				  }
				  else if (s == 1)
				  {
					  cout << "Not Found" << endl;
				  }
				  treetime = duration;
				  cout << "Tree time: " << duration << endl << endl;
		}
				  double diff = 0;
				  diff = listtime - treetime;
				  cout << "LIST\tTREE\tDIFF" << endl;
				  cout << listtime << "\t" << treetime << "\t" << diff << endl;
				  cout << "Press enter.";
				  cin.ignore();
				  cin.clear();
				  _getch();
				  system("CLS");
				  break;
		}
		case 3:
		{
				  l.display();														// Calling display funtion
				  cout << "\nPress enter.";
				  _getch();
				  system("CLS");
				  break;
		}
		case 4:
		{
				  exit(0);															// Terminating the program
				  break;
		}
		default:
		{
				   cin.clear();
				   cin.ignore();
				   cout << "Wrong choice, press enter.";
				   _getch();
				   break;
		}
		}
	} while (true);

	system("PAUSE");
	return 0;
}