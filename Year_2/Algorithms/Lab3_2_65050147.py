class Item :
    def __init__(self, profit, weight) :
        self.profit = profit
        self.weight = weight
    
    def __str__(self) :
        return f"profit : {self.profit}, weight : {self.weight}"

def GreedyKnapsack(w, Arr) :
    # sort array by p/w descend
    Arr.sort(key=lambda x: x.profit / x.weight, reverse=True)
    
    finalValue = 0.0

    for item in Arr :
        if item.weight <= w : # if can you put item
            finalValue += item.profit
            w -= item.weight
        else : # if you can't put item
            finalValue += item.profit * w / item.weight
    return finalValue


w = int(input("input weight of this knapsack : "))
n = int(input("How many items in here : "))
print("weight :", w)
print("please put your profit and weight below")
Arr = []
for i in range(n) :
    item = input(f"input item no.{i} : ").split()
    Arr += [Item(int(item[0]),int(item[1]))]
print("best profit :", GreedyKnapsack(w, Arr))


