class Car:
    'This class represents Car'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer+" "+self.model+" is moving.")

    def stop(self):
        print(self.manufacturer+" "+self.model+" has stopped.")

car1 = Car("Tata Motors", "Curvv", "2023", "Electric", "Blue")
car2 = Car("Tata Motors", "Avinya", "2024", "EV", "Gold")
car3 = Car("Suzuki", "Swift", "2017", "Automatic", "Black")

car2.accelerate()
car1.stop()
