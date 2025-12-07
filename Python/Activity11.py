fruit_basket ={
    "apple" :10,
    "banana" :15,
    "strawberry" : 16,
    "cherry" : 45,
    "grapes" : 25
}

fruit_to_find = input("please enter fruit name you wnat to find in basket?").lower()

if(fruit_to_find in fruit_basket):
    print(f"{fruit_to_find} is available in fruit basket")

else:
        print(f"{fruit_to_find} is not available in fruit basket")
