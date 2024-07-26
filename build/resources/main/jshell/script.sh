jscript.jsh#!/bin/bash
jshell jscript.jsh &
J_SHELL_PID=$!
wait $J_SHELL_PID
kill -9 $J_SHELL_PID