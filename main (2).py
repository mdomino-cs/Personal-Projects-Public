import math
import csv

k = 3

dataSet = [[3,2],[5,2],[2,2],[50,6],[3,2],[1,2],[2,1],[5,4],[20,22]]
def kmeans(dataSet,k,epochs):
  midPoints = []
  distances = []
  groups = []
  averages = []
  for i in range(k):
    midPoints.append(dataSet[i])
  for q in range(epochs):
    averages = []
    groups = []
    for i in range(k):
      groups.append([])
    for j in range(len(dataSet)):
      distances = []
      for i in range(k):
       distances.append(math.dist(dataSet[j],midPoints[i]))
      groups[distances.index(min(distances))].append(dataSet[j])
    for w in range(len(midPoints)):   
      x=0
      y=0
      for i in range(len(groups[w])):     
       x+=groups[w][i][0]
       y+=groups[w][i][1]
      x=x/len(groups[w])
      y=y/len(groups[w])
      averages.append([x,y])
    midPoints= averages.copy()
  return groups



data = kmeans(dataSet,3,50).copy()

for i in range(len(data)):
  for j in range(len(data[i])):
    data[i][j].insert(0,i+1)

filename = "groups.csv"
with open(filename, 'w') as csvfile:
  csvWriter = csv.writer(csvfile)
  feild = ["group","ColA","ColB"]
  csvWriter.writerow(feild)
  for i in range(len(data)):
    for k in range(len(data[i])):
      csvWriter.writerow(data[i][k])