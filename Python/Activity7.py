
len = int(input("Please enter the number of elemnts in list"))
numbers= []
for i in range (1,len):
 element = int (input(f"Please enter the {i} number in list "))
 numbers.append(element)

sum =0
for num in numbers:
    sum += num

print(f"The addition of all numbers in list is {sum}")    