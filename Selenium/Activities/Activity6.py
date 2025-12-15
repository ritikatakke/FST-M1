from selenium import webdriver
from selenium.webdriver.common.by import By
import time


driver = webdriver.Chrome()
driver.maximize_window()
driver.get("https://training-support.net/webelements/dynamic-controls")
print("Title of page is "+driver.title)
checkbox = driver.find_element(By.ID,"checkbox")
checkbox.click()
if(checkbox.is_selected()):
    print("checkbox is selected")
else:
    print("checkbox is not selected")

checkbox.click()
if(checkbox.is_selected()):
    print("checkbox is selected")
else:
    print("checkbox is not selected")