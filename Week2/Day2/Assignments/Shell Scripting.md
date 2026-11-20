
## Part 1: Script basics

### S1 Hello Script

~~~bash
#!/bin/bash
echo "Hello, Linux!"
echo "Today is $(date +%A)"
echo "Current user is $(whoami)"
~~~

#### Q1. What does the first line #!/bin/bash do?

It declares the shell that should be used to run the script.

#### Q2. What happens if you run ./hello.sh before chmod +x?

It won't run because of a permission error.

### S2 Variables

~~~bash
#!/bin/bash
name="Ashu"
age=25
course="LinuxEssentials"
date="$(date +'%F')"
home="$HOME"

echo "Name      : $name"
echo "Age       : $age"
echo "Course    : $course"
echo "Date      : $date"
echo "Home      : $home"
~~~

#### Q1. Why does name = "Ashu" (with spaces) fail?

It's incorrect syntax; shell scripts are very strict about spaces

#### Q2. What is the difference between "\$name" and '$name'?

Writing "$name" will omit the double quotes and return a string of the variable's value while single quotes are included in output; i.e., echo "'\$name'" will output 'Ashu' exactly.

### S3 User input and arguments

~~~bash
#!/bin/bash
read -p "Enter your city: " city
echo "City              : $city"
echo "Script name       : $0"
echo "First arg : $1"
echo "Second arg        : $2"
echo "Arg count : $#"
echo "All args  : $@"
~~~

#### Q1. What does $# hold?

The number of arguments

### S4 Arithmetic calculator

~~~bash
#!/bin/bash
read -p "Enter first number: " n1
read -p "Enter second number: " n2

echo ""
echo "Sum               : $((n1 + n2))"
echo "Difference        : $((n1 - n2))"
echo "Product           : $((n1 * n2))"
echo "Quotient  : $((n1 / n2))"
~~~

#### Q1. Why does 7/2 give 3 in bash?

It cuts of the decimal--taking the floor() of the result instead of regular rounding--so 3.5 becomes 3.

## Part 2: Decisions

### S5 if: positive number

~~~bash
#!/bin/bash
read -p "Enter a number: " n

if [ $n -gt 0 ]; then
        echo "$n is positive"
fi
~~~

#### Q1. What do you see for -3?

Nothing is printed

### S6 if-else: even or odd

~~~bash
#!/bin/bash
read -p "Enter a number: " n

if [ $(( n % 2 )) -gt 0 ]; then
        echo "$n is odd"
else
        echo "$n is even"
fi
~~~

#### Q1. Which operator tests numeric equality inside \[\]?

-eq

### S7 if-elif-else: grade calculator

~~~bash
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
~~~

#### Q1. What would 90 print, and why?

90 would still print "Grade A" because I used -ge which means greater than or equal to.

### S8 File tests

~~~bash
#!/bin/bash

readonly path=$1

if [ ! -e $path ]; then
        echo "$path does not exist"
elif [ -f $path ]; then
        echo "$path is a regular file"
elif [ -d $path ]; then
        echo "$path is a directory"
fi
~~~

#### Q1. What is the difference between -e and -f?

-e checks that an item exist at the path regardless of if it's a file or directory whereas -f only checks for regular files.

### S9 case: service menu

~~~bash
#!/bin/bash
read -p "Choice (start|stop|status): " ch

case $ch in
        start)  echo "Starting service..." ;;
        stop)   echo "Stopping service..." ;;
        status) echo "Service is running" ;;
        *)      echo "Invalid option" ;;
esac
~~~

#### Q1. What do ;; and \* mean in a case block?

";;" separates cases similar to "break;" in other languages like C. "\*" is the same as "default" in C or "\_" for python matches. It catches when $ch is any value other than those specified in other case statements.

## Part 3: Loops

### S10 for loops

~~~bash
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
~~~

#### Q1. How do you step by 2 in a range?

Inside the {}, you'd add "..2" after the end number; e.g., {1..10..2} would be a range from 1-10 stepping by 2.

### S11 for with files

~~~bash
#!/bin/bash
for f in *.txt
do
        echo "$f $(wc -l < "$f")"
done
~~~

#### Q1. Why quote "$f"?

This prevents the shell from re-interpreting its value; e.g., handling backslash escaped characters in this case. "$f" resolves to the raw string of the file's name.

### S12 while loop and countdown

~~~bash
#!/bin/bash

count=1

while [ $count -le 5 ]; do
        echo "Count = "$count""
        count=$(( $count + 1 ))
done

file="names.txt"

while read -r line; do
        echo -e "> $line"
done <$file
~~~

#### Q1. What happens if you forget to increase the counter?

The while loop goes on infinitely

### S13 break and continue

~~~bash
#!/bin/bash

for i in {1..10}; do
        if [ $i -eq 3 ]; then
                continue;
        fi

        if [ $i -eq 6 ]; then
                break;
        fi

        echo "i = "$i""
done

echo "Loop finished"
~~~

#### Q1. What is the difference between break and continue?

"break" exits the loop while "continue" goes to the next iteration.

## Part 4: Functions and Practical Scripts

### S14 Functions

~~~bash
#!/bin/bash
greet(){
        echo "Hello, $1!"
}

sum(){
        echo "Sum = "$(( $1 + $2 ))""
}

greet "Ashu"
sum 10 20
greet "Linux"
~~~

#### Q1. Why must a function be defined before it is called?

Otherwise, the script wouldn't know where to go. It would be like trying to use a non-existent variable.

### S15 System report

~~~bash
#!/bin/bash
clear

echo "=============== System Report ==============="
echo "User              : $(whoami)"
echo "Host              : $(hostname)"
echo "Date              : $(date '+%F %T')"
echo "Uptime            : $(uptime -p)"
echo "Disk used : $(df -h / | awk 'NR==2{print $5}')"
echo "Logged in : $(who | wc -l) users(s)"
~~~

#### Q1. What does NR\=\=2 select in the awk command?

It selects a specific row under the "Use%" column output by "df -h".

### S16 Backup script

~~~bash
#!/bin/bash
src="$HOME/lab1"
dest="/tmp/backup_$(date +%Y%m%d)"

if [ ! -d "$src" ]; then
        echo "Source folder not found!"
        exit 1
fi

mkdir -p "$dest"
cp -r "$src"/. "$dest"
echo "Backup done: $dest"
~~~

#### Q1. What does exit 1 signal?

The code quit with an error.

#### Q2. Why use mkdir -p?

It doesn't error if target directory already exists, and it creates any parent directories necessary for the operation.

### S17 Log error checker

~~~bash
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
~~~

#### Q1. What does -z test?

It's true for empty strings.

### S18 Challenge: multiplication table

~~~bash
#!/bin/bash

read -p "Enter a number: " n

if [ $n -le 0 ]; then
        echo "Error: only positive integers accepted"
        exit 1
fi

for i in {1..10}; do
        echo "$n x $i = $(( $n * $i ))"
done
~~~

#### Q1. Which loop type did you pick and why?

I chose a \{\} loop because it's quicker to type.

### S19 Challenge: menu-driven tool

~~~bash
#!/bin/bash

choice=0

while [ $choice -ne 4 ]; do
        read -p "1) Date 2) Disk 3) Files 4) Quit
Choice: " choice

        case $choice in
                1)      echo "$(date '+%F')" ;;
                2)      echo "$(df -h / | awk 'NR==2{print $5}')";;
                3)      echo "$(ls .)" ;;
        esac
done

echo "Bye!"
~~~

#### Q1. How does the loop end?

After inputting 4, the while loop's condition is broken.