grammar bb1dbSql;


/*********************************************************************************************************************
Parser rules
*********************************************************************************************************************/

/************************
Entry point rule for all programs.
************************/
prog        :
                (
					cTab|dTab|aTab
					|
					insert
				)
            ;

/************************
Create table
************************/
cTab		:
                CREATE_KW TABLE_KW tableName '('
					columnName AUTO_KW?
                	(',' columnName)*
                ')'
            ;

/************************
Drop table
************************/
dTab		:
                DROP_KW TABLE_KW tableName
            ;

/************************
Alter table
************************/
aTab		:
                ALTER_KW TABLE_KW tableName aTabColumn
            ;

/************************
Alter table, add or drop column
************************/
aTabColumn :
				(
					ADD_KW columnName (',' columnName)*
					|
					DROP_KW columnName (',' columnName)*
				)
		   ;

/************************
Insert
************************/
insert		:
                INSERT_KW INTO_KW tableName insertCols insertVals
            ;

/************************
Insert columns
************************/
insertCols	:
                '(' columnName (',' columnName)* ')'
            ;

/************************
Insert values
************************/
insertVals	:
                VALUES_KW '(' value (',' value)* ')'
            ;


tableName  :
				IDENTIFIER
           ;

columnName :
				IDENTIFIER
           ;

value      :
				STRING | NUMBER
           ;


/*********************************************************************************************************************
Lexer rules
*********************************************************************************************************************/

COMMENT_LINE
  			:
  				'--' .*? ('\r\n' | '\r' | '\n') -> channel (HIDDEN)
  			;
  			
COMMENT_BLOCK
  			:
  				'/*' .*? '*/' -> channel (HIDDEN)
  			;


CREATE_KW   :   'create'
            ;

TABLE_KW    :   'table'
            ;

AUTO_KW     :   'auto'
            ;

DROP_KW     :   'drop'
            ;

ALTER_KW    :   'alter'
            ;

ADD_KW      :   'add'
            ;

INSERT_KW   :   'insert'
            ;

INTO_KW     :   'into'
            ;

VALUES_KW   :   'values'
            ;

IDENTIFIER	:
				[a-z|A-Z]([a-z]|[A-Z]|[0-9])*
			;


STRING      :
				'\'' ('\'\'' | ~('\''))* '\''
            ;

NUMBER      :
				[1-9]([0-9])*
				|
				'0.'([0-9])*[1-9]([0-9])*
				|
				[1-9]([0-9])*'.'?([0-9])*
            ;

WS          :
                [ \r\n\t] + -> channel (HIDDEN)
            ;
            
