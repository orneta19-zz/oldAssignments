package com.company.oldAssignments;


/** This class lets the user temper with an image made from pixels.
 * Each pixels is an object of RGBColor class which contains 3 colors: red, green and blue.
 *
 * Created by Neta on 18/04/2016.
 */
public class RGBImage extends RGBColor {

    private RGBColor[][] _pixels;

    /** This constructor creates a new black image the size of the number of rows and columns recieved as params.
     *
     * @param rows - represents the number of rows.
     * @param cols - represents the number of columns.
     */
    public RGBImage (int rows, int cols) {

        final RGBColor BLACK = new RGBColor(0,0,0);

        this._pixels = new RGBColor[rows][cols];
        RGBColor[][] tempPixel = new RGBColor[rows][cols];

        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                tempPixel[row][col] = BLACK;
                this._pixels[row][col] = tempPixel[row][col];

            }
        }

        this._pixels = tempPixel;
    }

    /** This constructor creates a new image which is identical to the array of pixels given as param.
     *
     * @param pixels
     */
    public RGBImage (RGBColor[][] pixels) {

        final int PIXELS_ROW_NUM = pixels.length;
        final int PIXELS_COL_NUM = pixels[0].length;

        this._pixels = new RGBColor[PIXELS_ROW_NUM][PIXELS_COL_NUM];

        for (int row = 0; row < PIXELS_ROW_NUM; row++)
        {
            for (int col = 0; col < PIXELS_COL_NUM; col++)
            {
                this._pixels[row][col] = pixels[row][col];
            }
        }

    }

    /** This constructor receives another image as param and copies its values.
     *
     * @param other
     */
    public RGBImage (RGBImage other) {

        final int OTHER_ROW_NUM = other._pixels.length;
        final int OTHER_COL_NUM = other._pixels[0].length;

        this._pixels = new RGBColor[OTHER_ROW_NUM][OTHER_COL_NUM];
        RGBColor[][] newPixels = new RGBColor[OTHER_ROW_NUM][OTHER_COL_NUM];


        for (int row = 0; row < OTHER_ROW_NUM; row++)
        {
            for (int col = 0; col < OTHER_COL_NUM; col++)
            {
                newPixels[row][col] = other._pixels[row][col];
                this._pixels[row][col] = newPixels[row][col];
            }
        }

        this._pixels = newPixels;
    }

    /** This method returns the height of the image in pixels.
     *
     * @return The height of the image in pixels.
     */
    public int getHeight () {

    return this._pixels.length;
    }

    /** This method returns the width of the image in pixels.
     *
     * @return The width of the image in pixels.
     */
    public int getWidth () {

        return this._pixels[0].length;
    }

    /** This method receives the coordinates of an image, and returns the pixel located at these coordinates.
     * If the coordinates are out of image range, a black pixel is returned
     *
     * @param row - The horizontal coordinate.
     * @param col - The vertical coordinate.
     * @return The pixel located at the received coordinates.
     */
    public RGBColor getPixel (int row, int col) {

        if (row >= this._pixels.length || col >= this._pixels[0].length)
        {
            return new RGBColor(0,0,0);
        }
        else return this._pixels[row][col];
    }

    /** This method receives the coordinates of an image and a triplet of colors (pixel) as params.
     * It sets this pixel to be in the coordinates recieved as params.
     * If these coordinates are outside the image size range, it does nothing.
     *
     * @param row - The horizontal coordinate.
     * @param col - The vertical coordinate.
     * @param pixel - The pixel to move.
     */
    public void setPixel (int row, int col, RGBColor pixel) {

        if (row < this._pixels.length && col < this._pixels[0].length)
        {
            this._pixels[row][col] = pixel;
        }
    }

    /** This method recieves an image as param.
     * It returns whether the image the method was acted upon and the image recieved as param are equal.
     *
     * @param other - The image to compare.
     * @return - Whether the image to compare is equal to the image the method was acted upon.
     */
    public boolean equals (RGBImage other) {

        final int OTHER_ROW_NUM = other._pixels.length;
        final int OTHER_COL_NUM = other._pixels[0].length;


        if (OTHER_ROW_NUM == this._pixels.length && OTHER_COL_NUM == this._pixels[0].length) {


            for (int row = 0; row < this._pixels.length; row++) {
                for (int col = 0; col < this._pixels[0].length; col++) {
                    if (this._pixels[row][col] != other._pixels[row][col]) {
                        return false;
                    }
                }
            }
            return true;
        }
        else
            return false;
    }



    /** This method flips the image the method was acted upon according to the horizontal axis.
     */
    public void flipHorizontal () {


     RGBColor[][] tempArr = new RGBColor[this._pixels.length][this._pixels[0].length];
     for (int row = 0; row < this._pixels.length; row++)
     {
         for (int col = 0; col < this._pixels[0].length; col++)
         {
          tempArr[row][this._pixels[0].length - col - 1] = this._pixels[row][col];
         }
     }
        this._pixels = tempArr;

    }

    /** This method flips the image the method was acted upon according to the vertical axis.
     */
    public void flipVertical () {

      rotateClockwise();
      rotateClockwise();
    }

    /** This method inverts the colors of all pixels in an image.
     * It does so by replacing each RGB color in its complementary color to 255.
     */
    public void invertColors () {

        RGBColor[][] invertedColors = new RGBColor[this._pixels.length][this._pixels[0].length];
        for (int row = 0; row < this._pixels.length; row++)
        {
            for (int col = 0; col < this._pixels[0].length; col++)
            {
                invertedColors[row][col] = new RGBColor(255 - this._pixels[row][col].getRed(), 255 - this._pixels[row][col].getGreen(), 255 - this._pixels[row][col].getBlue());
                this._pixels[row][col] = invertedColors[row][col];
            }
        }

        this._pixels = invertedColors;
    }

    /** This method rotates the image by 90 degrees clockwise.
     */
    public void rotateCounterClockwise () {

        final int NEW_ROW_NUM = this._pixels[0].length;
        final int NEW_COL_NUM = this._pixels.length;


        RGBColor[][] tempArr = new RGBColor[NEW_ROW_NUM][NEW_COL_NUM];

            for (int row = 0; row < this._pixels[0].length; row++) {

                for (int col = 0; col < this._pixels.length; col++) {

                        int newColNum = NEW_ROW_NUM - 1 - row;
                        tempArr[row][col] = this._pixels[col][newColNum];

            }

        }
            this._pixels = tempArr;
    }

    /** This method rotates the image by 90 degrees counterclockwise.
     */
    public void rotateClockwise () {

        final int NEW_ROW_NUM = this._pixels[0].length;
        final int NEW_COL_NUM = this._pixels.length;

        RGBColor[][] tempArr = new RGBColor[NEW_ROW_NUM][NEW_COL_NUM];

        for (int row = 0; row < this._pixels[0].length; row++)
        {
            int newRowNum = NEW_COL_NUM - 1;

            for (int col = 0; col < this._pixels.length && newRowNum >= 0; col++, newRowNum--)
            {
                tempArr[row][col] = this._pixels[newRowNum][row];
            }
        }

        this._pixels = tempArr;
    }

    /** This method recieves a whole number 'offset' as param.
     * It shifts the image right or left according to the param given.
     * The coloumns entered into the shifted coloumns are be all black.
     * If the 'offset' is larger than the number of coloumns, nothing is done.
     * If the 'offset' is equal to the number of coloumns, the whole image becomes black.
     *
     * @param offset - The number of coloumns needed to shift.
     */
    public void shiftCol (int offset) {

        final RGBColor BLACK = new RGBColor(0, 0, 0);
        RGBColor[][] tempArr = new RGBColor[this._pixels.length][this._pixels[0].length];

        for (int row = 0 ; row < this._pixels.length; row++)
        {
            for (int col = 0; col < this._pixels[0].length; col++)
            {
                if (col < Math.abs(offset) && offset < 0)
                {
                    tempArr[row][col] = this._pixels[row][Math.abs(col - offset)];
                }
                else if (col > offset - 1 && offset > 0)
                {
                    tempArr[row][col] = this._pixels[row][col - offset];
                }
                else
                {
                    tempArr[row][col] = BLACK;
                }
            }
        }

        this._pixels = tempArr;
    }

    /** This method recieves a whole number 'offset' as param.
     * It shifts the image up or down according to the param given.l;
     * The rows entered into the shifted rows are be all black.
     * If the 'offset' is larger than the number of rows, nothing is done.
     * If the 'offset' is equal to the number of rows, the whole image becomes black.
     *
     * @param offset - The number of rows needed to shift.
     */
    public void shiftRow (int offset) {

        final RGBColor BLACK = new RGBColor(0, 0, 0);
        RGBColor tempPlacement = new RGBColor();
        RGBColor[][] tempArr = new RGBColor[this._pixels.length][this._pixels[0].length];


        if (offset < this._pixels.length)
        {
            for (int col = 0; col < this._pixels[0].length; col++)
            {
                for (int row = 0; row < this._pixels.length; row++)
                {
                    if (row + offset >= 0 && row + offset < this._pixels.length)
                    {
                        tempPlacement = this._pixels[row][col];
                        this._pixels[row][col] = BLACK;
                        this._pixels[row + offset][col] = tempPlacement;
                    }

                }
            }
        }
        else if (offset == this._pixels.length)
        {
            for (int col = 0; col < this._pixels[0].length; col++)
            {
                for (int row = 0; row < this._pixels.length; row++)
                {
                    tempArr[row][col] = BLACK;
                }
            }

            this._pixels = tempArr;
        }
        else if (offset > this._pixels.length)
        {
            for (int col = 0; col < this._pixels[0].length; col++)
            {
                for (int row = 0; row < this._pixels.length; row++)
                {
                    this._pixels[row][col] = this._pixels[row][col];
                }
            }
        }
    }


    /** This method returns a gray representation of the image.
     *  The grayscale is calculated as defined in the API of RGBColor.
     *
     * @return - A gray representation of the image.
     */
    public double[][] toGrayscaleArray () {

        double[][] greyScaleArr = new double[this._pixels.length][this._pixels[0].length];

        for (int row = 0; row < this._pixels.length; row++)
        {
            for (int col = 0; col < this._pixels[0].length; col++)
            {
               greyScaleArr[row][col] = this._pixels[row][col].convertToGrayscale();
            }
        }

        return greyScaleArr;
    }

    /** This method returns a string representation of the image.
     * The format of the string is:
     * Every row in the array is in a different line, as between each pixel there is a single space.
     * At the end of a row there is no space.
     * Each pixel is presented in a string containing 3 whole numbers seperated by commas, inside round brackets.
     *
     * @return - A string representation of the image.
     */
    public String toString () {

        String stringImage = new String();

        for (int row = 0; row < this._pixels.length; row++)
        {
            for (int col = 0; col < this._pixels[0].length; col++)
            {
                if (col < this._pixels[0].length - 1)
                {
                    String str = (this._pixels[row][col] + " ");
                    stringImage += str;
                }
                else if (col == this._pixels[0].length - 1)
                {
                    String str = (this._pixels[row][col].toString() + '\n');
                    stringImage += str;
                }

            }

        }

        return stringImage;
    }

    /** This method returns a copy of the pixel array.
     *
     * @return - A copy of the pixel array.
     */
    public RGBColor[][] toRGBColorArray () {

        RGBColor[][] arrCopy = new RGBColor[this._pixels.length][this._pixels[0].length];

        for (int row = 0; row < this._pixels.length; row++)
        {
            for (int col = 0; col < this._pixels[0].length; col++)
            {
                arrCopy[row][col] = this._pixels[row][col];
            }
        }

        return arrCopy;
    }
}
