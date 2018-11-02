Set oShell = CreateObject ("Wscript.Shell") 
Dim strArgs
strArgs = "cmd /c compile.bat"
oShell.Run strArgs, 0, false