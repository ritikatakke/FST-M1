player1 = input("enter player 1 name: ")
player2 = input("enter player 2 name: ")




player1_choice = input(player1 + " Do you want to select Rock , Paper ,scissor ?").lower()
player2_choice = input(player1 + " Do you want to select Rock , Paper ,scissor ?").lower()



if player1_choice == player2_choice:
    print("its tie!")
elif player1_choice == "rock":
    if player2_choice == "scissor":
        print("player1 Rock Wins! ")
    else:
        print("player2  Paper wins! ")

elif player1_choice == "scissor":
    if player2_choice == "paper":
        print("player1 scissor wins!")
    else:
        print("player 2 rock wins")

elif player1_choice == "paper":
    if player2_choice == "rock":
        print("player1 paper wins!")
    else:
        print("player 2 scissor wins")

else:
    print("invalid choice")

 

    
 