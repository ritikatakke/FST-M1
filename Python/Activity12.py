def sum(n):
    if n>=0:
        return n + sum(n-1)
    else:
        return 0

result = sum(10)    
print(f"Sum of numer 0 to 10 is {result}")

    


    