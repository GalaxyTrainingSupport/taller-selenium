'''
Created on 30 jul. 2020

@author: lruiz
'''

from selenium import  webdriver
import time

driver = webdriver.Chrome("./drivers/chromedriver")

driver.implicitly_wait(30)

driver.maximize_window()

driver.get("https://www.google.com/")

driver.find_element_by_name("q").send_keys("Galaxy Training")

driver.find_element_by_name("btnK").click()

time.sleep(5)

driver.quit()