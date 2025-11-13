@echo off
if not exist build\classes mkdir build\classes
javac -d build\classes *.java Tutorial\*.java
echo Compilation complete.
