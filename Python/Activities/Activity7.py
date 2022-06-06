#program to calculate the sum of all the elements in a list.

numbers = list(input("Enter numbers separated by comma : ").split(","))
sum=0
for number in numbers:
    sum += int(number)

print(sum)

