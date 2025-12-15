from selenium import webdriver
from selenium.webdriver.common.by import By
import time


driver = webdriver.Chrome()
driver.maximize_window()
driver.get("https://training-support.net/webelements/dynamic-controls")
print("Title of page is "+driver.title)
inputbox = driver.find_element(By.ID,"textInput")
if(inputbox.is_enabled()):
    print("input box is enabled")
else:
     print("input box is disabled")

driver.find_element(By.ID,"textInputButton").click()



time.sleep(5)
if(inputbox.is_enabled()):
    print("input box is enabled")
else:
     print("input box is disabled")
