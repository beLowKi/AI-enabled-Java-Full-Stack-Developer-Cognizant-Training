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
