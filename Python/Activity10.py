len = int(input("please inter number of element you want to enter in tuple? "))
number_list = []
for i in range (1,len+1):
    element = int(input(f"please enter {i} element in tuple "))

    number_list.append(element)
number_tuple = tuple(number_list)
print("The tuple entered by user")
print(number_tuple)

print("The list of numbers divided by 5 in tuple")
for num in number_tuple:
    if num % 5 == 0:
        print(num)
    