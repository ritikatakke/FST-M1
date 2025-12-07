number_List= [12,23,45,67,8,4,13]

def sum(list):
    sum=0
    for num in list:
        sum= sum+num
    return sum


Result= sum(number_List)
print(f"The Addition of numbers given in the list is {Result}")

    