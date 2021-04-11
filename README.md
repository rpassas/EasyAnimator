# EasyAnimator
## This is a simple animator software made for CS5008



### Overview

The model operates with a ledger of shapes and changes to those shapes. Respective classes of shapes and changes manage the behaviors of the animation. Rect and Circle are concrete shapes extending the AbstractShape class that implements the BasicShape interface for shapes. Move, Resize, and Recolor are all concrete changes that can occur to shapes as the animation progresses. The model's main job is to store and update the shapes according to the changes based on ticks and inputs managed upstream by the controller. 

### Main Model


<img width="1055" alt="Screen Shot 2021-04-05 at 7 12 40 PM" src="https://user-images.githubusercontent.com/35311744/113637692-3d477300-9643-11eb-9a06-76352125b73f.png">

AnimationModel: interface

AnimationModelImpl: implementing concrete class

The AnimationModel class is the interface for the AnimationModelImpl that sits at the core of the model. The implemenation holds listOfShapes for created shapes in a base state, listOfChanges holds the changes that will take place over the course of the animation, and the keys are held in a list and updated incrementally as a simple way to access shapes if needed that way just within the model. When the animation runs, modified copies of the of shapes are returned via getShapesAtTick() where changes in listOfChanges dictate alterations to versions of shapes held in listOfShapes. Shapes and changes can be added and removed here via outlined methods.

### Shapes in the Model

<img width="1017" alt="Screen Shot 2021-04-05 at 7 14 05 PM" src="https://user-images.githubusercontent.com/35311744/113637709-47697180-9643-11eb-9f1e-61e588b0b70f.png">

BasicShape: interface

AbstractShape: abstract class with a Point2D

Rect, Circle: concrete inheriting classes

Shapes themselves all have positions (Point2D composition), dimensions, color values, a string label to help provide another way to ID shapes, and a tick for when the animation runs (used by the controller as time passes). These attributes can be set and get via common methods in AbstractShape. Concrete shapes also have overloaded constructors so there are multiple ways to create shapes, have individual toString() methods, and can retrieve their respective enum types. Because the model will have to create copies of shapes, cloneShape() will help to get copies of the base case shapes in the model.

### Changes to the Model

<img width="747" alt="Screen Shot 2021-04-05 at 7 14 24 PM" src="https://user-images.githubusercontent.com/35311744/113637719-4b958f00-9643-11eb-9838-1a935601d8ce.png">

Change: interface

AbstractChange: abstract class with a Point2D

Move, Recolor, Resize: concrete inheriting classes

The model also keeps track of changes which each get starting attributes, ending attributes, start time, end time, a type, and a label and ID's for the shape that the change they are associated with (both are there for the sake of flexibility for the controller). While individual concrete classes, like Move, change only a particular type of attribute, Point2D in the case of Move, AbstractChange handles common attributes, like timestamps, ID, label, a type (which gets set in the concrete classes via a "super" call). These changes keep record of what change is supposed to occur, and over what time period, helping the model to generate appropriate copies of existing shapes at the appropriate times.

note: enum classes are not shown in the UML diagrams (types of changes and shapes are enumerated)

---

Questions for TA are below DELETE BEFORE SUBMISSION
  1. Best way to implement our builder/abstract view/concrete view. Right now I think appendable submits to the builder, the builder main method parses it to the correct concrete class and the class outputs the view as required.
  2. How to implement the getshapesattick method correctly/ does it need to be in the text view
  3. If no speed is input i'm asuming it goes to 1, might want to confirm it.
  4. Possible methods for common interface: tempo(determine speed for ticks per second), tween(attr converter) ... does start/run() make sense to have? 
  5. clarify inputs - do we only need to work with command line inputs like in the spec? What about having users generate .txt files?
  6. Are elements like the graphics and Jframe classes best used in a composition or just used within the visual view class itself? What should the panels be used for?
