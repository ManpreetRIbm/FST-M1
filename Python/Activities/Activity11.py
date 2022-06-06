#Create a Python dictionary that contains a bunch of fruits and their prices. Write a program that checks if a certain fruit is available or not.

fruits = {
    "apple" : 5,
    "banana" : 4,
    "cherry" : 9,
    "dragonfruit" : 15
}

checkFruit = input("Enter fruit that you want to check in dictionary : ").lower()

if(checkFruit in fruits):
    print("Yes this fruit is available")
else:
    print("No this fruit is not available")

