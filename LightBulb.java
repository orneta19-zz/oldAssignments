package com.company.oldAssignments;

/** This class represents a light bulb color, defined by three color components - red, green and blue.
 *
 * @author Neta Oren
 * @since 04/04/2016
 * @version 0.1
 */
public class LightBulb {

    RGBColorOld _color = new RGBColorOld();
    boolean _switchedOn;

    /** This constructor sets this color as the other color recieved.
     * It also sets the light switch (switchedOn) as false (Off).
     * If any of the colors recieved are not in the legal range (0 - 255) then all colors are set to 0 (black).
     * @param red - The red color component value.
     * @param green - The green color component value.
     * @param blue - The blue color component value.
     */
    public LightBulb (int red, int green, int blue) {

        final int MIN_VALUE = 0;
        final int MAX_VALUE = 255;

        this._switchedOn = false;

        if (red < MIN_VALUE || red > MAX_VALUE || green < MIN_VALUE || green > MAX_VALUE
                || blue < MIN_VALUE || blue > MAX_VALUE)
        {
            this._color.setRed(MIN_VALUE);
            this._color.setGreen(MIN_VALUE);
            this._color.setBlue(MIN_VALUE);

        } else {
            this._color.setRed(red);
            this._color.setGreen(green);
            this._color.setBlue(blue);
        }

    }

    /** This constructor sets this color as the other color.
     * It also sets the light switch (switchedOn) as false (Off).
     * @param color - The RGBColorOld to copy.
     */
    public LightBulb (RGBColorOld color) {

        this._switchedOn = false;

        this.setColor(color);

    }

    /** This copy constructor recieves other lightbulb from user and copies it to this lightbulb.
     * @param other - The LightBulb to copy.
     */
    public LightBulb (LightBulb other) {

        this._color = other._color;


    }

    /** This method returns the color of the light bulb.
     * @return The color of the light bulb.
     */
    public RGBColorOld getColor () {

        return new RGBColorOld(_color);

    }

    /** This method sets the color of the light bulb to the color recieved.
     * @param color - The color of the light bulb recieved.
     */
    public void setColor (RGBColorOld color) {

        this._color.setRed(color.getRed());
        this._color.setGreen(color.getGreen());
        this._color.setBlue(color.getBlue());

    }

    /** This method checks whether the light bulb is switched on or not, and returns true or false accordingly.
     * @return - true or false, depending if the light is switched on or not.
     */
    public boolean isSwitchedOn () {

        if (this._switchedOn == true)
            return true;
        else
            return false;

    }

    /** This method changes the state of the light bulb.
     * If it's on, it turns it off and vice versa.
     */
    public void switchLight () {

        if (isSwitchedOn() == false)
            this._switchedOn = true;
        else
            this._switchedOn = false;

    }

    /** This method returns a string representation of this bulb as the three colors making it.
     * @return A string representation of this bulb as the three colors making it.
     */
    public String toString () {

        String redString = Integer.toString(this._color.getRed());
        String greenString = Integer.toString(this._color.getGreen());
        String blueString = Integer.toString(this._color.getBlue());
        String switchState;
        if (this._switchedOn == true)
            switchState = "On";
        else
            switchState = "Off";

        return ("(" + redString + "," + greenString + "," + blueString + ") " + switchState);

    }
}
