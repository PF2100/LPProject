#!/bin/sh

# Clean up old files
rm -f target/*.class
rm -f src/Parser/*.java

# Generate parser files
cd src/Parser
javacc ParserL0.jj
cd ../..

# Compile all Java files
javac -d target -cp src $(find src -name "*.java")