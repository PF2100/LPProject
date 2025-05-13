@echo off

del /Q Parser\*.class
del /Q ASTNodes\*.class
del /Q Env\*.class
del /Q IValues\*.class
del /Q Error\*.class

del /Q Parser\*.java

cd Parser
javacc ParserL0.jj
cd ..

javac Parser\*.java ASTNodes\*.java Env\*.java IValues\*.java Error\*.java
