%{
#include<string.h>
   int i,m;
   struct symtab
   {
     char name[200];
     char type[200];
   }sym[20];

%}

ws	[\t ]
digit	[0-9]
alpha	[a-zA-Z]
id	{alpha}({alpha}|{digit})*

%%

#include{ws}*<{id}\.h>	{printf("\n%s : Preprocessor directive to include header files",yytext);}
#define{ws}+{id}{ws}+({alpha}|{digit})* {printf("\n%s : Preprocessor directive for substitution",yytext);}

if |
case |
else |
while |
do |
switch{ws}*\(.*\) |
for			{printf("\n %s : Keyword",yytext);}

getch\(\) |
printf{ws}*\(\".*\"\) |
scanf{ws}*\(\".*\"\)	{printf("\n %s : Library Function",yytext);}

void{ws}+{id}{ws}*\(({ws}*{id}{ws}*,)*({ws}*{id}{ws}*)?\)	{
									printf("\n%s : Definition of function with return type void" ,yytext);
										strcpy(sym[m].name,yytext);
										strcpy(sym[m].type,"Function");
										m++;
								}
int{ws}+{id}{ws}*\(({ws}*{id}{ws}*,)*({ws}*{id}{ws}*)?\)        {printf("\n%s : Definition of function with return type int" ,yytext);}
float{ws}+{id}{ws}*\(({ws}*{id}{ws}*,)*({ws}*{id}{ws}*)?\)	{printf("\n%s : Definition of function with return type char" ,yytext);}
char{ws}+{id}{ws}*\(({ws}*{id}{ws}*,)*({ws}*{id}{ws}*)?\)	{printf("\n%s : Definition of function with return type float" ,yytext);}
double{ws}+{id}{ws}*\(({ws}*{id}{ws}*,)*({ws}*{id}{ws}*)?\)	{printf("\n%s : Definition of function with return type double" ,yytext);}

{id}{ws}*\(({ws}*{id}{ws}*,)*({ws}*{id}{ws}*)?\)		{printf("\n%s : Function call" ,yytext);}

int{ws}+	{printf("\n%s : Declaration of integer variables",yytext);}
char{ws}+	{printf("\n%s : Declaration of character variables",yytext);}
float{ws}+	{printf("\n%s : Declaration of float variables",yytext);}
double{ws}+	{printf("\n%s : Declaration of double variables",yytext);}

[;,]	{}
[{(]	{printf("\n %s : Opening brace",yytext);}
[})]	{printf("\n %s : Closing brace",yytext);}


[+\-\*\\%=] 	{printf("\n %s : Arithmetic operator",yytext);}
[<>]=? 		{printf("\n %s : Relational operator",yytext);}



{id}	{
		printf("\n %s : Identifier",yytext);
			strcpy(sym[m].name,yytext);
			strcpy(sym[m].type,"Variable");
			m++;

	}
{digit}*(\.{digit}*)?	{
				printf("\n %s : Arithmetic number",yytext);
				strcpy(sym[m].name,yytext);
				strcpy(sym[m].type,"Number");
				m++;

			}

{id}"["{digit}*"]"	{
				printf("\n %s : Array",yytext);
				strcpy(sym[m].name,yytext);
				strcpy(sym[m].type,"Array");
				m++;

			}

%%
int main()
{

		printf("enter the string");
yylex();


 printf("\n\n\n\t--------------------\n");
 printf("\tIndex\tSymbol name\t\t\tSymbol Type");
 printf("\t\t\n--------------------------");

 for(i=0;i<m;i++)
 {
   printf("\n\t%d",i+1);
   printf("\t\t%s",sym[i].name);
   printf("\t\t\t%s\n",sym[i].type);
 }
 yywrap();
}

extern int yywrap()
{
return 1;
}
