list1=[34,65,89,67,12,35,33,44]
list2=[23,22,24,35,28,46,23,26,34,45]

list3=[]

for num in list1:
    if (num % 2 != 0):
        list3.append(num)

for num in list2:
    if(num % 2 == 0):
        list3.append(num)

print(list3)