#Rock-paper scissor game

#Get users names
user1 = input("Enter user1 name : ")
user2 = input("Enter user2 name : ")

#Get users choices
user1_answer = input(user1+" do you want to choose rock, paper or scissor ? ").lower()
user2_answer = input(user2+" do yo want to choose rock, paper or scissor ? ").lower()

#Check who wins
if user1_answer == user2_answer:
    print("It's a tie")

elif user1_answer == 'rock':
    if user2_answer == 'scissor':
        print("Rock wins")
    else:
        print("Paper wins")

elif user1_answer == 'scissor':
    if user2_answer == 'paper':
        print("Scissor wins")
    else:
        print("Rock wins")

elif user1_answer == 'paper':
    if user2_answer == 'rock':
        print("Paper wins")
    else:
        print("Scissors wins")

else:
    print("Invalid input. Please try again")