#Writing data to csv files

#import pandas
import pandas

#create dictionary to hold data
data = {
    "Usernames": ["manu", "Amy", "Dan"],
    "Passwords": ["manu123", "amy123", "dan123"]
}

#create dataframe using this data
dataframe = pandas.DataFrame(data)

#print dataframe
print(dataframe)

	
"""
 Write the DataFrame to a CSV file
 To avoid writing the index numbers to the file as well
 the index property is set to false
"""

dataframe.to_csv("userDetails.csv", index=False)

