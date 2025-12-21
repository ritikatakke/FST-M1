from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains

driver = webdriver.Chrome()
actions = ActionChains(driver)

driver.maximize_window()
driver.get("https://training-support.net/webelements/keyboard-events")
print("Title of page is :", driver.title)

actions.send_keys("Hi My name is ritika").send_keys(Keys.RETURN).perform()

text_entered = driver.find_element(By.CSS_SELECTOR, "h1.mt-3").text
print("The entered text :", text_entered)

driver.quit()
