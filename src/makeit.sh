#!/bin/sh



rm Parser/*.class ASTNodes/*.class Env/*.class IValues/*.class Error/*.class
rm Parser/*.java

cd Parser/
javacc ParserL0.jj
javac Parser/*.java ASTNodes/*.java Env/*.java IValues/*.java Error/*.java
