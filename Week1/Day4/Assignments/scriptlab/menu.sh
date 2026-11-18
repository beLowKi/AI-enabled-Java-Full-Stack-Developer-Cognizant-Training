#!/bin/bash

choice=0

while [ $choice -ne 4 ]; do
	read -p "1) Date 2) Disk 3) Files 4) Quit
Choice: " choice

	case $choice in
		1) 	echo "$(date '+%F')" ;;
		2) 	echo "$(df -h / | awk 'NR==2{print $5}')";;
		3)	echo "$(ls .)" ;;
	esac		
done

echo "Bye!"
