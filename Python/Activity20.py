import pandas as pd

df= pd.read_excel('emp.xlsx')

print(df)

size= df.shape


print(f"The number of rows and columns in excel sheetemployee is {size}" )

email = df['Email']

print(f"The list of Emails from employee excel is as follows {email}")

print("Sorted data based on first Name")
print(df.sort_values('FirstName'))