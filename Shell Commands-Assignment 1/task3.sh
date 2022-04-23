#!/bin/sh
echo "Enter what operation you want to do: "
read op
echo "Enter num1: "
read num1
echo "Enter num2: "
read num2

case "$op" in
	+) echo $((num1+num2));;
	-) echo $((num1-num2));;
	\*) echo $((num1*num2));;
	/) echo $((num1/num2));;
	*) echo "Invalid Operator";;
esac

