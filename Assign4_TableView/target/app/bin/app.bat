@echo off
set JLINK_VM_OPTIONS=
set DIR=%~dp0
"%DIR%\java" %JLINK_VM_OPTIONS% -m ku.cs.assign2javafx/ku.cs.assign2javafx.HelloApplication %*
