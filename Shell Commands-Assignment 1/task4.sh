#!/bin/bash
echo "Enter a number: "
read numString
sum=0
i=0
while(($i<${#numString}))
do
sum=$((sum + ${numString:i:1}))
i=$((i+1))
done
echo "$sum"
