from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
wait = WebDriverWait(driver, 10)

driver.maximize_window()
driver.get("https://training-support.net/webelements/dynamic-controls")
print("Title of page is :", driver.title)

checkbox = driver.find_element(By.ID, "checkbox")
toggle_checkbox = driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']")

if checkbox.is_displayed():
    print("checkbox is visible")

toggle_checkbox.click()
wait.until(EC.invisibility_of_element(checkbox))

if not checkbox.is_displayed():
    print("checkbox is not visible")

toggle_checkbox.click()
wait.until(EC.visibility_of(checkbox))

if checkbox.is_displayed():
    print("checkbox is visible")
    checkbox.click()

driver.quit()
