# EasyAnimator
## This is a simple animator software made for CS5008


IShape dictates protocol for shapes, abstract shape is common behaviors to shapes, which is implemented by R (rectangle) and C (ellipse) classes. Shapes each have a point2D, dictating position of shapes.


### Overview

The model operates with a ledger of shapes and changes to those shapes. Respective classes of shapes and changes manage the behaviors of the animation. Rect and Circle are concrete shapes extending the AbstractShape class that implements the BasicShape interface for shapes. The model's main job is to store and update the shapes according to the changes based on ticks and inputs managed upstream by the controller. 

### Main Model

<img width="985" alt="Screen Shot 2021-04-05 at 12 42 48 PM" src="https://user-images.githubusercontent.com/35311744/113599474-a8c21e00-960c-11eb-9702-514193b8fc1f.png">

### Shapes in the Model

<img width="978" alt="Screen Shot 2021-04-05 at 12 43 08 PM" src="https://user-images.githubusercontent.com/35311744/113599493-aeb7ff00-960c-11eb-8eeb-2a2b3548da25.png">

### Changes to the Model

<img width="983" alt="Screen Shot 2021-04-05 at 12 43 22 PM" src="https://user-images.githubusercontent.com/35311744/113599523-bb3c5780-960c-11eb-8b6f-3a8c4d7f4c6c.png">


### Model:
- holds a list of shapes + changes and defines behaviors for those shapes/changes


### Controller:
- calls on the models methods to get shapes at a particular tick
- updated versions of the shapes are then passed to the view


### View
- the view clears its draw space and adds the new shapes to the display



