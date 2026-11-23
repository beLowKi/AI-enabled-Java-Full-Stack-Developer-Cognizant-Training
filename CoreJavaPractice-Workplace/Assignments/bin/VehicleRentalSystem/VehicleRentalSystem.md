## Example Output

![[Screenshot (111).png]]

## Usage of Inheritance and Polymorphism

The Car and Bike classes inherit from the base Vehicle most of their properties--model, number, days, etc. --as well as some methods. Mainly, their "displayDetails" method is defined solely in Vehicle, but both subclasses have access to it.

Polymorphism is used in Main.java when an Array of Vehicles is used to store inputs. That Array can be a mixture of Cars and Bikes because they inherit from Vehicle.