from selenium import webdriver
from selenium.webdriver.common.by import By
import time


driver = webdriver.Chrome()
driver.maximize_window()
driver.get("https://training-support.net/webelements/dynamic-controls")
print("Title of page is "+driver.title)
checkbox = driver.find_element(By.ID,"checkbox")
if(checkbox.is_displayed()):
    print("checkbox is displayed")
else:
    print("checkbox is not displayed")
toggle_Checkbox = driver.find_element(By.XPATH,"//button[text()='Toggle Checkbox']")
toggle_Checkbox.click()
time.sleep(5)
if(checkbox.is_displayed()):
    print("checkbox is displayed")
else:
    print("checkbox is not displayed")