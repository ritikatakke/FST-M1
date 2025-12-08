import pandas as pd
from pandas import ExcelWriter


data= {
    'FirstName':["Satvik", "Avinash", "Lahri"],
	'LastName':["Shah", "Kati", "Rath"],
	'Email':["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
	'PhoneNumber':["4537829158", "4892184058", "4528727830"]
}

df= pd.DataFrame(data)
print(df)

writer = ExcelWriter('emp.xlsx')
df.to_excel(writer, sheet_name='empdata', index=False)

writer.close()