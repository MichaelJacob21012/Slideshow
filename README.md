# Slideshow
Goal
The goal of this assignment is to implement a simple image viewer.
The application has been partially implemented, and you need to complete the missing bits.
To get started, get the ‘slideshow’ project
from the subject web site. This is the partially
implemented project. When you open it, you
will see the class structure depicted on the left.
Three of the classes are fully implemented –
you do not need to modify them. One class –
ImageViewer – has not been finished, and it is
your job to finish implementation of this class.
Here is a quick overview over the existing
classes:

Class ImageViewerGUI
This class presents the GUI (Graphical User
Interface) of the application. That is: It draws the main window, the buttons, and all the other things you see
on the screen. It does two things: If the user clicks a button, that call is passed on the the ImageViewer class;
and the ImageViewer class may call this one to display an image or a String in the interface.

Class Image
This class represents a single image. Investigate it: it has methods such as getName, getHeight, etc. You need
to call these methods to display some of the needed information.

Class Album
This represents a collection of images ready for viewing. An album is built by specifying a folder on disk with
some image files in it (by default the folder called images inside the project folder). The album will automatically load all image files that it finds in that folder (e.g. jpg, png, tiff files).

Class ImageViewer
This class implements the logic of the image viewer. This is where you have to do your work. This is also the
class that you instantiate to start this application.

Base tasks
To complete this assignment you have to do the following:

• Implement the method stubs (methods with missing method bodies) in the ImageViewer class.

• The effect should be this: When the image viewer is started, the first image (index 0) should be automatically displayed.

• With any image that is displayed, the image name should be shown near the top of the window. (The
GUI class has a method to do this.)

• The status bar at the bottom of the window should show the image size.

• When a user clicks Next, the next image should be displayed (with correct name and size). At the end
of the album, clicking Next shows the first image again.

• When a user clicks Previous, the previous image should be displayed (with correct name and size).
This should wrap around to the last image when scrolling past the first one.

• When FishEye is clicked, the fisheye effect should be applied to the image. (There is a method in the
Image class that applies the effect.)

• You must complete all comments where they are missing (class and method comments).
To achieve this, you have to make use of the ‘album’ variable in the ImageViewer class to retrieve images,
and of the Image methods to get image names and sizes. For example, the line
currentImage = album.getImage(2);
would retrieve image number 2 from the album and store it in a variable named currentImage. Test your code
well. Your program should never display a runtime error.

Challenge tasks (Do these only if you have time left over)

Three more tasks:
• Implement a method named getNumberOfImagesViewed that returns the number of images that have
been viewed since the image viewer was started. The return value should be an int. Viewing the same
image twice counts as 2 views.

• Implement a method named averageImageWidth that returns the average width of the images viewed
so far. The result is of type int.

• Find the maximum width and the maximum height of any of the images in the album. Then use the
GUI’s setImageSize method to set this maximum size (in the constructor of the ImageViewer). This
will stop the image viewer resizing with every image change.

Extra challenge task (just for fun – no marks)
Add another button labeled Statistics to the interface. If this button is clicked, a dialogue opens that displays
the statistics information from the previous challenge tasks (number of images, average width)
