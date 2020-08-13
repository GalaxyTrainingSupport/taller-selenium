'''
Created on 30 jul. 2020

@author: lruiz
'''

from selenium import  webdriver

driver = webdriver.Chrome("./drivers/chromedriver")
driver.implicitly_wait(10)
driver.maximize_window()


driver.get("https://www.amazon.com/")

search_field = driver.find_element_by_id("twotabsearchtextbox")
search_field.clear()


search_field.send_keys("iphone 11 screen protector")
search_field.submit()


products = driver.find_elements_by_xpath("//*[@id='search']/div[1]/div/div[1]")

print ("Total " + str(len(products)) + " products:")

for product in products:
    print(product.text)

driver.quit()