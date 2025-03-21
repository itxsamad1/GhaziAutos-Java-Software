@echo off
echo Creating desktop shortcut for GhaziAutos...

REM Get the current directory
set "CURRENT_DIR=%~dp0"

REM Create a shortcut on the desktop
echo Set oWS = WScript.CreateObject("WScript.Shell") > CreateShortcut.vbs
echo sLinkFile = oWS.ExpandEnvironmentStrings("%USERPROFILE%\Desktop\GhaziAutos.lnk") >> CreateShortcut.vbs
echo Set oLink = oWS.CreateShortcut(sLinkFile) >> CreateShortcut.vbs
echo oLink.TargetPath = "%CURRENT_DIR%start_GhaziAutos.bat" >> CreateShortcut.vbs
echo oLink.WorkingDirectory = "%CURRENT_DIR%" >> CreateShortcut.vbs
echo oLink.Description = "GhaziAutos Application" >> CreateShortcut.vbs
echo oLink.IconLocation = "%CURRENT_DIR%GhaziAutos.jar" >> CreateShortcut.vbs
echo oLink.Save >> CreateShortcut.vbs
cscript //nologo CreateShortcut.vbs
del CreateShortcut.vbs

echo Desktop shortcut created successfully!
pause 