//program to count the number of objects of a class using static member function

#include <iostream>
using namespace std;

class test
{
    int objNo;
    static int objCnt;

public:
    test()
    {
        objNo = ++objCnt;
    }
    ~test()
    {
        --objCnt;
    }
    void printObjNumber(void)
    {
        cout << " Object Number : " << objNo << "\n";
    }
    static void printObjCount(void)
    {
        cout << " Count : " << objCnt << "\n";
    }
};

int test::objCnt;

int main()
{
    test t1, t2;
    test::printObjCount();

    test t3, t4;
    test::printObjCount();

    t1.printObjNumber();
    t2.printObjNumber();
    t3.printObjNumber();
    t4.printObjNumber();

    return 0;
}
