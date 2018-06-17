#!/bin/bash

rm -r outJava
mkdir outJava
java -Xmx500M -cp "lib/*" org.antlr.v4.Tool -o outJava bb1dbSql.g4
javac -cp "lib/*" outJava/*.java
cd outJava
java -cp "../lib/*:." org.antlr.v4.gui.TestRig bb1dbSql prog -gui ../grunInput.txt
cd ..
