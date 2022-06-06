#Given a tuple of numbers, iterate through it and print only those numbers which are divisible by 5

tuplenum = (1,3,4,33,45,65,20)
print(tuplenum)

print("Elements divisible by 5 are : ")
for num in tuplenum:
    if(num%5==0):
        print(num)
