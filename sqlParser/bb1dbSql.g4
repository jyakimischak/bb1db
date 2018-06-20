grammar bb1dbSql;


/*********************************************************************************************************************
Parser rules
*********************************************************************************************************************/

/************************
Entry point rule for all programs.
************************/
prog        :
                (cTab)
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




tableName  :
				IDENTIFIER
           ;

columnName :
				IDENTIFIER
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

IDENTIFIER	:
				[a-z|A-Z]([a-z]|[A-Z]|[0-9])*
			;


STRING      :
				'"' ~('"')* '"'
            ;

WS          :
                [ \r\n\t] + -> channel (HIDDEN)
            ;
            
