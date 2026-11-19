#!/bin/bash
read -p "Enter marks (0-100): " n
grade=""

if [ $n -ge 90 ]; then
        grade="A"
elif [ $n -ge 80 ]; then
        grade="B"
elif [ $n -ge 50 ]; then
        grade="C"
else
        echo "Fail"
        exit 0
fi

echo "Grade $grade"
