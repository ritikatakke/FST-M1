from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

driver = webdriver.Chrome()
driver.maximize_window()

driver.get("https://training-support.net/webelements/dynamic-attributes")
print("Title of page is :", driver.title)

name = driver.find_element(By.CSS_SELECTOR, "input[id^='full-name']")
email = driver.find_element(By.CSS_SELECTOR, "input[id$='email']")
date = driver.find_element(By.XPATH, "//input[contains(@name, '-event-date-')]")
additional_detail = driver.find_element(By.XPATH, "//textarea[contains(@name, '-additional-details-')]")
button = driver.find_element(By.XPATH, "//button[text()='Submit']")
success_message = driver.find_element(By.ID, "action-confirmation")

name.send_keys("ritika")
email.send_keys("ritika.takke@gmail.com")
date.send_keys("2025-06-21")
additional_detail.send_keys("we are testing dynamic page")
button.click()

driver.implicitly_wait(20)

if success_message.is_displayed():
    print("Success message is dsiplayed")

driver.quit()
