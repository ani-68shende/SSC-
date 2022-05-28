#include <bits/stdc++.h>

using namespace std;

unordered_map<string, string> mp;
string s;
char tk;
int pt = 0;

/*
E -> TE'
E' -> +TE | epsilon
T -> FT'
T' -> *FT | epsilon
F -> (E) | id
*/

void E();
void ED();
void T();
void TD();
void F();

void advance() {
	pt++;
	tk = s[pt];
}

void E() {
	T();
	ED();
}

void ED() {
	if(tk == '+') {
		advance();
		T();
		E();
	}
}

void T() {
	F();
	TD();
}

void TD() {
	if(tk == '*') {
		advance();
		F();
		T();
	}
}

void F() {
	if(tk == '(') {
		advance();
		E();
		if(tk == ')') {
			advance();
		}
	}
	else {
		if(tk == 'i') {
			advance();
		}
	}
}

int main() {

	while(1) {
		cout<<"Enter the string: "<<endl;
		cin>>s;
		tk = s[pt];
		E();
		if(s[pt] == '\0') cout<<"ACCEPTED\n";
		else cout<<"NOT ACCEPTED\n";
		int choice;
		cout<<"Enter 0 to exit: ";
		cin>>choice;
		if(choice == 0) exit(0); 
		pt=0;
	}
	return 0;
}
