import pandas as pd

df = pd.read_csv("AdminData.csv")

print("Username Column from AdminData CSV file:")
print(df["Username"])

# Accessing specific row values
print("Username for 2nd row is:", df["Username"][1])
print("Password for 2nd row is:", df["Passwords"][1])

# Sorting ascending by Username
print("Username sorted in Ascending Order:")
print(df.sort_values("Username"))

# Sorting descending by Password
print("Password sorted in Descending Order:")
print(df.sort_values("Passwords", ascending=False))

