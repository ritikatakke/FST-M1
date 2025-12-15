from selenium import webdriver
from selenium.webdriver.common.by import By
import time


driver = webdriver.Chrome()
driver.maximize_window()
driver.get("https://training-support.net/webelements/target-practice")
header3 = driver.find_element(By.XPATH,"//h3[contains(text(),'#3')]")
print("Text of header 3 is: "+header3.text)
header5 = driver.find_element(By.XPATH,"//h5[contains(text(),'#5')]")
print("The color of header 5 is:" +header5.value_of_css_property("color"))

buttonPurple = driver.find_element(By.XPATH,"//button[text()=\"Purple\"]")
print("The class of purple button" +buttonPurple.get_dom_attribute('class'))
buttonSlate = driver.find_element(By.XPATH,"//button[text()=\"Slate\"]")
print("the text of button : "+buttonSlate.text)