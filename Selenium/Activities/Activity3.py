from selenium import webdriver
from selenium.webdriver.common.by import By
import time


driver = webdriver.Chrome()
driver.maximize_window()
driver.get("https://training-support.net/webelements/login-form")
print("Title of Page is " +driver.title)
username = driver.find_element(By.XPATH,"//input[@name='username']")
password= driver.find_element(By.XPATH,"//input[@name='password']")
submit= driver.find_element(By.XPATH,"//button[text()='Submit']")

username.send_keys("admin")
password.send_keys("password")
submit.click()
time.sleep(20)
message=driver.find_element(By.XPATH,"//h1")
print(message.text)


