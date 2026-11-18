#!/bin/bash
for fruit in apple banana mango
do
	echo "I like $fruit"
done

for i in {1..5}
do
	echo "Number $i"
done

for (( i=1; i<=3; i++ ))
do 
	echo "Square of $i is $(( i * i ))"
done
