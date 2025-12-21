from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
wait = WebDriverWait(driver, 10)

driver.maximize_window()
driver.get("https://training-support.net/webelements/dynamic-content")
print("Title of page is :", driver.title)

click_me = driver.find_element(By.ID, "genButton")
text = driver.find_element(By.ID, "word")

click_me.click()

if wait.until(EC.text_to_be_present_in_element((By.ID, "word"), "release")):
    print("Text Release found")

driver.quit()
