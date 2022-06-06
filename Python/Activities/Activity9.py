#Given a two list of numbers create a new list such that new list should contain only odd numbers from the first list and even numbers from the second list.

list1 = [1,9,3,4,5,6,22,23]
list2 = [1,9,3,4,5,6,22,23]

print(list1)
print(list2)

list3 = []

for num in list1:
    if(num%2!=0):
        list3.append(num)

for num in list2:
    if(num%2==0):
        list3.append(num)

print(list3)

