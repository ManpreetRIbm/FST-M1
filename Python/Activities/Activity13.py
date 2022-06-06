# Write a function sum() such that it can accept a list of elements and print the sum of all elements

from re import S


def sum(numbers):
    s=0
    for number in numbers:
        s=s+number
    return s 

numlist = [1,5,3,7]
res = sum(numlist)
print("Sum of numbers in list are : " +str(res))