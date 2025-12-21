from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains

driver = webdriver.Chrome()
actions = ActionChains(driver)

driver.maximize_window()
driver.get("https://training-support.net/webelements/drag-drop")
print("Title of page is :", driver.title)

dropzone1 = driver.find_element(By.ID, "dropzone1")
dropzone2 = driver.find_element(By.ID, "dropzone2")
ball = driver.find_element(By.ID, "ball")

dropzone_text = driver.find_element(By.CLASS_NAME, "dropzone-text")

actions.click_and_hold(ball).move_to_element(dropzone1).release().perform()
if dropzone_text.text == "Dropped!":
    print("Ball is dropped in zone1")
else:
    print("Ball is not dropped in zone1")

actions.drag_and_drop(ball, dropzone2).perform()
if dropzone_text.text == "Dropped!":
    print("Ball is dropped in zone2")
else:
    print("Ball is not dropped in zone2")

driver.quit()
