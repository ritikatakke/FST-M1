from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
wait = WebDriverWait(driver, 10)

driver.get("https://training-support.net/webelements/popups")
print("Page title:", driver.title)

driver.find_element(By.ID, "launcher").click()

wait.until(EC.element_to_be_clickable((By.ID, "username")))

username = driver.find_element(By.ID, "username")
username.send_keys("admin")

password = driver.find_element(By.ID, "password")
password.send_keys("password")

driver.find_element(By.XPATH, "//button[text()='Submit']").click()

message = driver.find_element(By.CSS_SELECTOR, "h2.text-center").text
print("Message display after Login", message)

driver.quit()
