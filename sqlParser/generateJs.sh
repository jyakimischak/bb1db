#!/bin/bash

if [ -d "outJs" ]; then rm -r outJs; fi
mkdir outJs
java -Xmx500M -cp "lib/*" org.antlr.v4.Tool -Dlanguage=JavaScript -o outJs bb1dbSql.g4


