/** Image viewer allows for navigation between images in a folder 
 * and also allows the application of the fisheye effect
 *  
 * Michael Jacob 
 * 26/10/17 
 */
public class ImageViewer
{    
    private ImageViewerGUI gui;     // the Graphical User Interface
    private Album album;            // the album
    private int currentNumber;      // the number image currently being viewed
    private int numberViewed;       // the total number of images viewed
    private int totalWidth;         // the total width of all images viewed
    /**
     * Create an ImageViewer and display its GUI on screen.
     * Display the first image.
     * Set the display size.
     */
    public ImageViewer()
    {
        gui = new ImageViewerGUI(this);
        album = new Album("images");    // process images in folder 'images'
        currentNumber = 0;              // first image index zero
        numberViewed = 0;
        setDisplaySize();
        displayImage(false);            // fresh image
    }

    /**
     * View the next image in the album.
     * Prevents currentNumber exceeding the number of images in the album.
     */
    public void nextImage()
    {
        int albumSize = album.numberOfImages();
        if (currentNumber == (albumSize - 1)){
            currentNumber = 0;
        } else{
            currentNumber ++;
        }
        displayImage(false);                    // fresh image
    }

    /**
     * View the previous image in the album
     * Prevents currentNumber falling below 0
     */
    public void previousImage()
    {
        int albumSize = album.numberOfImages();
        if (currentNumber == 0){
            currentNumber = (albumSize - 1);
        } else{
            currentNumber --;
        }
        displayImage(false);                    // fresh image
    }

    /**
     * Applies fisheye effect to the current image being viewed
     */
    public void fishEye()
    {
        Image currentImage = album.getImage(currentNumber);
        currentImage.fishEye();
        displayImage(true);                      // redisplay current image
    }

    /**
     * Displays the current image with its name at the top
     * and its image size in the status bar at the bottom.
     * Increases the number of images viewed by 1.
     * Adds image width to total width.
     * @param - Only increase total viewed and width if a 
     * different image is displayed by user
     */
    private void displayImage(boolean reDisplay)
    {
        Image currentImage = album.getImage(currentNumber);
        gui.showImage(currentImage);
        gui.showName(currentImage.getName());
        gui.showStatus("" + currentImage.getWidth() + " X " + currentImage.getHeight());
        if (!reDisplay){
            numberViewed ++;
            totalWidth += currentImage.getWidth();
        }
    }

    /**
     * Returns total number of images viewed 
     */
    public int getNumberOfImagesViewed()
    {
        return numberViewed;
    }

    /**
     * Calculates and returns the average width of all images viewed
     */
    public int averageImageWidth()
    {
        int averageWidth = totalWidth/numberViewed;
        return averageWidth;
    }
    
    /** 
     * Sets the display size such that all images will fit
     */
    private void setDisplaySize()
    {
        int maxHeight = 0;
        int maxWidth = 0;
        int albumSize = album.numberOfImages();
        /**
        * go through all the images and find the greatest dimensions
        */
        for (int imageNumber = 0; imageNumber < albumSize; imageNumber ++){
            Image image = album.getImage(imageNumber);
            if (image.getHeight() > maxHeight) {
                maxHeight = image.getHeight();
            }
            if (image.getWidth() > maxWidth) {
                maxWidth = image.getWidth();
            }
        }
        gui.setImageSize(maxWidth,maxHeight);
    }

}