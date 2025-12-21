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

third_rows = driver.find_elements(By.XPATH, "//table/tbody/tr[3]/td")
print("Third row elements")
for element in third_rows:
    print(element.text)

second_row_second_column = driver.find_element(By.XPATH, "//table/tbody/tr[2]/td[2]")
print("The 2nd row and 2 column element:", second_row_second_column.text)

driver.quit()
