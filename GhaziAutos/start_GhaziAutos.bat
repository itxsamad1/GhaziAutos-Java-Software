@echo off
echo Starting GhaziAutos...

REM Define possible XAMPP installation paths
set XAMPP_PATHS=C:\xampp;D:\xampp;E:\xampp

REM Find XAMPP installation
for %%p in (%XAMPP_PATHS%) do (
    if exist "%%p\mysql\bin\mysqld.exe" (
        set XAMPP_PATH=%%p
        goto :found_xampp
    )
)
echo XAMPP not found in common locations. Please edit this script with your XAMPP path.
pause
exit

:found_xampp
echo Found XAMPP in %XAMPP_PATH%

REM Check if MySQL is running
netstat -an | find "3306" > nul
if errorlevel 1 (
    echo MySQL is not running. Starting MySQL...
    REM Start MySQL using the found path
    start "" /B "%XAMPP_PATH%\mysql\bin\mysqld.exe" --defaults-file="%XAMPP_PATH%\mysql\bin\my.ini"
    
    REM Wait for MySQL to start
    echo Waiting for MySQL to start...
    timeout /t 5 /nobreak > nul
) else (
    echo MySQL is already running
)

REM Check if Java is installed
java -version > nul 2>&1
if errorlevel 1 (
    echo Java is not installed or not in PATH. Please install Java first.
    pause
    exit
)

REM Check if the JAR file exists
if not exist "GhaziAutos.jar" (
    echo GhaziAutos.jar not found in the current directory.
    pause
    exit
)

REM Start the application
echo Launching GhaziAutos...
start javaw -jar GhaziAutos.jar

exit 