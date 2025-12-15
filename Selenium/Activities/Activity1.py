from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Chrome()
driver.get("https://training-support.net")
print("Title")
print(driver.title)

button = driver.find_element(By.LINK_TEXT,"About Us")
button.click()
print("New Title")
print(driver.title)

driver.quit()




