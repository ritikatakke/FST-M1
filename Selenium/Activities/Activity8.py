from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains

driver = webdriver.Chrome()
actions = ActionChains(driver)

driver.maximize_window()
driver.get("https://training-support.net/webelements/mouse-events")
print("Title of page is :", driver.title)

cargo_lock = driver.find_element(By.XPATH, "//h1[text()='Cargo.lock']")
cargo_toml = driver.find_element(By.XPATH, "//h1[text()='Cargo.toml']")
src = driver.find_element(By.XPATH, "//h1[text()='src']")
target = driver.find_element(By.XPATH, "//h1[text()='target']")

actions.click(cargo_lock) \
       .pause(0.2) \
       .move_to_element(cargo_toml) \
       .pause(0.2) \
       .click(cargo_toml) \
       .perform()

message = driver.find_element(By.ID, "result")
print("Confirmation text when we click on cargo.toml is", message.text)

actions.double_click(src) \
       .pause(0.2) \
       .context_click(target) \
       .pause(1) \
       .perform()

open_option = driver.find_element(By.XPATH, "//ul/li[1]/button")
actions.click(open_option).pause(0.2).perform()

target_message = driver.find_element(By.ID, "result")
print("Confirmation text when we click on src is :", target_message.text)

driver.quit()
