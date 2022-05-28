{%
#include<stdio.h>
extern int yylex();
extern int yywrap();
extern int yyparse();
%}

%token WH IF DO FOR OP CP OCB CCB CMP SC ADG ID NUM COMMA OPR

%%
start: swh | mwh | dowh | sif | mif;
swh: WH OP cmpn CP stmt			{printf("VALID SINGLE STATEMENT WHILE LOOP\n");};
mwh: WH OP cmpn CP OCB stmt CCB		{printf("VALID MULTI STATEMENT WHILE LOOP\n");};
dowh: DO OCB stmt CCB WH OP cmpn CP SC	{printf("VALID DO-WHILE LOOP\n");};
sid: IF OP cmpn CP stmt			{printf("VALID SINGLE STATEMENT IF\n");};
mif: OF OP cmpn CP OCB stmt CCB		{printf("VALID MULTIPLE STATEMENT IF");};

cnob: ID CMP ID | ID CMP NUM;

stmt: ID ASG ID OPR ID SC | ID ASG ID OPR NUM SC | ID ADG NUM OPR ID SC | ID ADG NUM OPR NUM SC | ID ASG NUM | start {printf("NESTED INSIDE A ");}

%%

int yyerror(char *str) {
	printf("%s", str);
}

main() {
	yyparse();
}
