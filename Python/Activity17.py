import pandas as pd

data={
    'Username' :['admin','charles','deku'],
    'Passwords':['password','Charl13','AllMight']
}

df= pd.DataFrame(data)

print(df)

df.to_csv('AdminData.csv',index=False)