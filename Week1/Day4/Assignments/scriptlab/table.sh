#!/bin/bash

read -p "Enter a number: " n

if [ $n -le 0 ]; then
	echo "Error: only positive integers accepted"
	exit 1
fi

for i in {1..10}; do
	echo "$n x $i = $(( $n * $i ))"
done
