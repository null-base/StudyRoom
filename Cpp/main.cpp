#include <iostream>

int x = 20;

int main()
{
	int x = 40;

	std::cout << x << std::endl;	 // 40
	std::cout << ::x << std::endl; // 20

	return 0;
}
