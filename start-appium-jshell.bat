@echo off
setlocal

REM Adjust the paths as needed
set JAR_PATH=project jar\*
set SCRIPT=appium-setup.jsh

echo Starting JShell with Appium environment...
jshell --class-path "%JAR_PATH%" "%SCRIPT%"

endlocal