#!/bin/bash

readonly file="$1"

# Checking if input item exists and is file
if [ ! -e $file ]; then
	echo "Usage: <script> logfile"
	exit 1
fi
if [ ! -f $file ]; then
	echo "Error: input item must be a file"
	exit 1
fi

count=$(grep -i "error" $file | wc -l)
echo "Errors found: "$count""

if [ $count -gt 5 ]; then
	echo "ALERT: over 5 errors"
else
	echo "Log looks healthy"
fi

