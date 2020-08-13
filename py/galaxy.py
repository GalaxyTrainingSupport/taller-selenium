'''
Created on 30 jul. 2020

@author: lruiz
'''

from selenium import  webdriver

driver = webdriver.Chrome("./drivers/chromedriver")
driver.implicitly_wait(10)
driver.maximize_window()

driver.get("https://online.galaxy.edu.pe/")

products = driver.find_elements_by_xpath("//*[@id='content']/section/div/article")

print ("\nTotal " + str(len(products)) + " Cursos:")

print("--- Cursos encontrados ----")

for product in products:

    print(product.text)    


driver.quit()
