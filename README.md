# EasyAnimator
## This is a simple animator software made for CS5008


IShape dictates protocol for shapes, abstract shape is common behaviors to shapes, which is implemented by R (rectangle) and C (ellipse) classes. Shapes each have a point2D, dictating position of shapes.


### Overview

<img width="788" alt="Screen Shot 2021-04-01 at 5 02 27 PM" src="https://user-images.githubusercontent.com/35311744/113353678-0b18d700-930c-11eb-965f-5cdfee02ae32.png">


Rect and Circle are concrete shapes extending the AbstractShape class that implements the BasicShape interface for shapes. Each shape has a Point2D reference. The model has a list of various shapes, whose "versions" that get sent to the controller at particular time. This represents a snapshot at a particular time, where attributes get mapped to a time stamp, resulting in "movement."

### Model:
- holds a list of shapes and defines behaviors for those shapes

AnimationModel: Is a list of shapes that have particular behaviors defined (e.g. move, fade).

BasicShape: By default a shape has: position(x1, y1), size(w, h), a default or given color. This can concretely be a rect or circle (ellipse).

Colors operate with rgba schemes, with the default "a" being 1, and rgb each being 0, unless specified otherwise.


### Controller:
- calls on the models methods to get shapes at a particular tick
- updated versions of the shapes are then passed to the view


### View
- the view clears its draw space and adds the new shapes to the display



