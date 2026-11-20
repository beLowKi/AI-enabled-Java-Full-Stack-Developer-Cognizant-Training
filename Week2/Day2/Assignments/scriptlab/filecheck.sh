#!/bin/bash

readonly path=$1

if [ ! -e $path ]; then
	echo "$path does not exist"
elif [ -f $path ]; then
	echo "$path is a regular file"
elif [ -d $path ]; then
	echo "$path is a directory"
fi
