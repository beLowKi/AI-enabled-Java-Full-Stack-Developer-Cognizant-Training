#!/bin/bash
read -p "Enter a number: " n

if [ $(( n % 2 )) -gt 0 ]; then
	echo "$n is odd"
else
	echo "$n is even"
fi
