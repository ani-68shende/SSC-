#include <bits/stdc++.h>
using namespace std;

string s = "";
int temp_pointer = 0;
char token;

void E();
void T();
void F();
void EP();
void TP();

void advance()
{
    temp_pointer++;
    token = s[temp_pointer];
}

void E()
{
    T();
    EP();
}

void T()
{
    F();
    TP();
}

void F()
{
    if (token == '(')
    {
        advance();
        E();
        if (token == ')')
        {
            advance();
        }
    }
    else if (token == 'i')
    {
        advance();
    }
}

void TP()
{
    if (token == '*')
    {
        advance();
        F();
        TP();
    }
}

void EP()
{
    if (token == '+')
    {
        advance();
        T();
        EP();
    }
}

int main()
{
    while (1)
    {
        cout << "Enter the string: ";
        cin >> s;
        int choice = 0;
        token = s[temp_pointer];
        E();
        if (token == '\0')
        {
            cout << "Accepted" << endl;
        }
        else
        {
            cout << "Rejected" << endl;
        }
        cout << "Enter your choice: (0:continue || 1: break)" << endl;
        cin >> choice;
        if (choice == 1)
        {
            break;
        }
        temp_pointer = 0;
    }
    return 0;
}
