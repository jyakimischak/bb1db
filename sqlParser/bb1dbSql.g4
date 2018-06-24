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
					|   insert|select
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

aTabColumn :
				(
					ADD_KW columnName (',' columnName)*
					|   DROP_KW columnName (',' columnName)*
				)
		   ;

/************************
Insert
************************/
insert		:
                INSERT_KW INTO_KW tableName insertCols insertVals
            ;

insertCols	:
                '(' columnName (',' columnName)* ')'
            ;

insertVals	:
                VALUES_KW '(' value (',' value)* ')'
            ;

/************************
Select statement
************************/
select		:
                selectColumns selectFrom (selectWhere)?
            ;

selectColumns
 		    :
                SELECT_KW '*'
                |   SELECT_KW selectColumnName (',' selectColumnName)*
            ;

selectFrom
 		    :
                FROM_KW tableName (selectJoin)*
            ;

selectJoin  :
                INNER_KW? JOIN_KW tableName ON_KW condition
                |   LEFT_KW OUTER_KW? JOIN_KW tableName ON_KW condition
                |   RIGHT_KW OUTER_KW? JOIN_KW tableName ON_KW condition
                |   FULL_KW OUTER_KW? JOIN_KW tableName ON_KW condition
                |   CROSS_KW? JOIN_KW
            ;

selectWhere
 		    :
                WHERE_KW condition
            ;

condition   :
                '(' condition ')'
                |   NOT_KW? selectColumnName EQ (value | selectColumnName)
                |   NOT_KW? selectColumnName NE (value | selectColumnName)
                |   NOT_KW? selectColumnName GT (value | selectColumnName)
                |   NOT_KW? selectColumnName GTEQ (value | selectColumnName)
                |   NOT_KW? selectColumnName LT (value | selectColumnName)
                |   NOT_KW? selectColumnName LTEQ (value | selectColumnName)
                |   condition AND_KW condition
                |   condition OR_KW condition
            ;


/************************
Stuffed used in several places
************************/
tableName   :
				IDENTIFIER
            ;
columnName  :
				IDENTIFIER
            ;
value       :
				STRING | NUMBER
            ;
selectColumnName
            :
                IDENTIFIER | IDENTIFIER'.'IDENTIFIER
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

SELECT_KW   :   'select'
            ;

FROM_KW     :   'from'
            ;

WHERE_KW    :   'where'
            ;

INNER_KW    :   'inner'
            ;

OUTER_KW    :   'outer'
            ;

LEFT_KW     :   'left'
            ;

RIGHT_KW    :   'right'
            ;

FULL_KW     :   'full'
            ;

CROSS_KW    :   'cross'
            ;

JOIN_KW     :   'join'
            ;

ON_KW       :   'on'
            ;

NOT_KW      :   'not'
            ;

AND_KW      :   'and'
            ;

OR_KW       :   'or'
            ;

IDENTIFIER	:
				[a-z|A-Z]([a-z]|[A-Z]|[0-9])*
			;

EQ          :
                '='
            ;
NE          :
                '<>'
            ;
GT          :
                '>'
            ;
GTEQ        :
                '>='
            ;
LT          :
                '<'
            ;
LTEQ        :
                '<='
            ;

STRING      :
				'\'' ('\'\'' | ~('\''))* '\''
            ;

NUMBER      :
				'-'?([0-9])+
				|
				'-'?([0-9])+'.'?([0-9])*
            ;

WS          :
                [ \r\n\t] + -> channel (HIDDEN)
            ;
            
