#!/bin/bash


# This will compile all the java files in the folder

#find . -name "*.java" -print | xargs javac


# Navigate to the directory where the Java program is saved and Execute the main file

#cd /Users/adityabhargava/eclipse-workspace/CSPRabobank/bin/com/rabobank/csp/main/


# Run the Java program with arguments
#java CustomerStatementProcessor '/Users/adityabhargava/eclipse-workspace/CSPRabobank/resources/records.xml'


java -jar rabobank-csp-0.0.1-SNAPSHOT.jar "records.xml"