# EasyAnimator
## This is a simple animator software made for CS5008


IShape dictates protocol for shapes, abstract shape is common behaviors to shapes, which is implemented by R (rectangle) and C (ellipse) classes. Shapes each have a point2D, dictating position of shapes.


### Overview

<img width="413" alt="Screen Shot 2021-04-01 at 1 27 45 PM" src="https://user-images.githubusercontent.com/35311744/113331575-2248cc00-92ee-11eb-8de2-a006d7f5905c.png">


Helper methods sitting inside wrappers for the controller (e.g. move, fade, shade, resize) will then populate the list as needed by mapping values to the attributes of shapes based on ranges and time ticks. To make it work the wrapper (wrappers are written for the controller) will need a list of one shape, a function to map values (taken as params e.g. rgb) given time stamps, and a way to get an item in a list at tick. The controller will add and remove "relevant" shapes per the generated list IShape. The view displays the provided shapes.

### Model:
- takes a command from the controller to generate a list of shapes

IShape: IShape[] that can then have methods called on it to populate the list for animation. An instantiated IShape is a list of 1 concrete shape.

BasicShape: by default a shape has: position(x1, y1), size(w, h), a default or given color. This can concretely be a rectangle or circle (ellipse).

Colors operate with rgba schemes, with the default "a" being 1, and rgb each being 0, unless specified otherwise.


### Controller:
- takes a list of shapes and passes "relevant" shapes to view (for removal or deletion)
- can take color name e.g. "blue" and convert to rgb for the model to work on


### View
- takes a shape from the controller and displays/removes it accordingly 









### scratch work:

some basic functionalities: 

for move:
1. create initial shape
2. create list of shapes at different positions mapped based on time
- what is the tick interval?
3. iterate through the list, removing the previous and adding the current

for appear/disappear:
1. create intial shape
2. create list of shapes with different opacities mapped based on time
3. iterate through the list, removing the previous and adding the current

for color change:
1. create intial shape
2. create list of shapes with different colors mapped based on time
3. iterate through the list, removing the previous and adding the current

for size change:
1. create intial shape
2. create list of shapes with different sizes mapped based on time
3. iterate through the list, removing the previous and adding the current


---

### each functionality has:
1. create shape
2. list of shapes with attribute mapped to time
3. iterator removing and adding the list at a given time stamp
4. wrapping function to input desired attribute 


things to figure out:
- handling colors (names and RGB)
- 3 basic functions (with generics for attributes) - list of shapes
- what does the controller do?
- what does the view do?


how it would work:
R.move(300, 400);
