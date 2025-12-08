
class Car:
        
 def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color
        
 def accelerate(self):
     print(f"{self.manufacturer} {self.model} is moving")
 def stop(self):
    print(f"{self.manufacturer} {self.model} has Stopped")

car1 = Car("Toyota", "swift", "2015", "Manual", "purple")
car2 = Car("Maruti", "suzuki", "2018", "Manual", "Red")
car3 = Car("Suzuki", "Swift", "2016", "Automatic", "Black")
    
car1.accelerate()
car1.stop()
car2.accelerate()
car2.stop()
