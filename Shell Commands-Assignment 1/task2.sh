#!/bin/bash

currentFibNum=0
a=1
b=1
echo "Enter the number upto which you need Fibonacci series : "
read limit
echo -n "$a "
echo -n "$b "
while ((currentFibNum<=limit))
do
currentFibNum=$((a+b))
if [ $currentFibNum -le $limit ]
then echo -n "$currentFibNum "
fi
a=$b
b=$currentFibNum
done
echo ""
