# EasyAnimator
## This is a simple animator software made for CS5008


IShape dictates protocol for shapes, abstract shape is common behaviors to shapes, which is implemented by R (rectangle) and C (ellipse) classes. Shapes each have a point2D, dictating position of shapes.



### scratch work:

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

each functionality has:
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
