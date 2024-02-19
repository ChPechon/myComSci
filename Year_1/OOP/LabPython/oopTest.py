class Employee :
    # class atrributes
    name = str()
    id = int()
    salary = float()

    def __init__(self, name, id) :
        self.name = name
        self.id = id
        self.salary = 10000

    # class methods
    def setSalary(self, salary) :
        self.salary = salary

    def __str__(self) :
        return (f"I am {self.name} my id is {self.id}")
    
class Chef(Employee) :
    def __init__(self, name, id) :
        super()

    def cook() :
        print("cooking")


emp1 = Employee("Mark", 42)
emp2 = Employee("Mark", 42)

print(emp1 == emp2)


print("\nprint object without __str__")
print(emp1)