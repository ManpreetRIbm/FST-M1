#Read CSV

#import pandas library
import pandas

#read csv file and store in a dataframe
dataframe = pandas.read_csv("userDetails.csv")

#print full data
print("Full data : ")
print(dataframe)

#Print the values only in the Usernames column
print("Values only in username : ")
print(dataframe["Usernames"])

#Print the username and password of the second row
print("username and password of the second row : ")
print(dataframe["Usernames"][1], dataframe["Passwords"][1])

#Sort the Usernames column data in ascending order and print data
print("Sort the Usernames column data in ascending order and print data")
print(dataframe.sort_values('Usernames'))

#Sort the Passwords column in descending order and print data
print("Sort the Passwords column in descending order and print data")
print(dataframe.sort_values('Passwords', ascending=False))