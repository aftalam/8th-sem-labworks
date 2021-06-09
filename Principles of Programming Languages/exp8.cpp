//program to prepare a list of 50 questions and their answers using file handling

#include <iostream>
#include <fstream>

using namespace std;

int main()
{
    system("cls");
    ifstream in("ques.txt");

    if (!in)
    {
        cout << "Cannot Open Input File\n";
        return 1;
    }

    char str[255];

    while (in)
    {
        in.getline(str, 255);
        if (in)
            cout << str << endl;
    }

    in.close();
    return 0;
}