#!/bin/bash
for f in *.txt
do 
	echo "$f $(wc -l < "$f")"
done
