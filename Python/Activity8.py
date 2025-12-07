len = int(input("Please enter the number of elemnts in list "))
numbers= []
for i in range (1,len+1):
 element = int (input(f"Please enter the {i} number in list "))
 numbers.append(element)

if numbers[0]==numbers[-1]:
 print("true")
else :
 print("false")
