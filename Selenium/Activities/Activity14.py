from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait

driver = webdriver.Chrome()
wait = WebDriverWait(driver, 10)

driver.maximize_window()
driver.get("https://training-support.net/webelements/tables")
print("Title of page is :", driver.title)

rows = driver.find_elements(By.XPATH, "//table/tbody/tr")
print("The number of rows in table is :", len(rows))

columns = driver.find_elements(By.XPATH, "//table/thead/tr/th")
print("The number of columns in table is :", len(columns))

book_name = driver.find_element(By.XPATH, "//table/tbody/tr[5]/td[2]")
print("The book name in 5th row is:", book_name.text)

price_header = driver.find_element(By.XPATH, "//table/thead/tr/th[5]")
price_header.click()

book_name_after = driver.find_element(By.XPATH, "//table/tbody/tr[5]/td[2]")
print("The book name in 5th row after sorting is:", book_name_after.text)

driver.quit()
