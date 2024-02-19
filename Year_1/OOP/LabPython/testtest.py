import random

animal = ["Bird", "fish", "lion"]

x, y, z = "Hello", "World", 1

x, y, z = animal

def myFunc() :
    x = "Pechon"
    print("Hello", x)

print(random.randrange(1, 10))
myFunc()
y.replace("Data", "Mining")
print(x[:1], y)
print(z)

for i in "apple" :
    print(i, len(i))
    print("p" in i)

age = 19
text = "I am Peth and I am {}"

print(text.format(age))

def youngestChild(*str) :
    print("The youngest child is " + str[len(str) - 1])

youngestChild("Ami", "Ana", "Armel", "Ather")
#this is a comment