import requests
from bs4 import BeautifulSoup


problems = []
url = 'https://amazon.com'

try:
    website = requests.get(url) 
except requests.exceptions.RequestException as e:
    problems.append("Error fetching the website")

if (len(problems) == 0):
    problems.append("Everything looks good!!")

print(problems)
##jhbfhbsf

