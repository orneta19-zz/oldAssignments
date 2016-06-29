package com.company.oldAssignments;

/** This class represents a disco ball made from 4 light bulbs.
 * Each light bulb's color is defined by the colors red, green and blue.
 *
 * @author Neta Oren
 * @since 06/04/2016
 * @version 0.1
 */
public class Disco {

    LightBulb _bulb1 = new LightBulb(new RGBColorOld());
    LightBulb _bulb2 = new LightBulb(new RGBColorOld());
    LightBulb _bulb3 = new LightBulb(new RGBColorOld());
    LightBulb _bulb4 = new LightBulb(new RGBColorOld());


    /** This constructor recieves four light bulbs as parameters.
     * It sets the color of this light bulb to the given light bulb's color.
     *
     * @param b1 - Light bulb no. 1
     * @param b2 - Light bulb no. 2
     * @param b3 - Light bulb no. 3
     * @param b4 - Light bulb no. 4
     */
    public Disco (LightBulb b1, LightBulb b2, LightBulb b3, LightBulb b4) {

        this._bulb1.setColor(b1._color);
        this._bulb2.setColor(b2._color);
        this._bulb3.setColor(b3._color);
        this._bulb4.setColor(b4._color);

    }

    /** This method returns the value of the first bulb.
     *
     * @return The value of the first bulb.
     */
    public LightBulb getFirstBulb () {

        return this._bulb1;

    }

    /** This method returns the value of the second bulb.
     *
     * @return The value of the second bulb.
     */
    public LightBulb getSecondBulb () {

        return this._bulb2;

    }

    /** This method returns the value of the third bulb.
     *
     * @return The value of the third bulb.
     */
    public LightBulb getThirdBulb () {

        return this._bulb3;

    }

    /** This method returns the value of the fourth bulb.
     *
     * @return The value of the fourth bulb.
     */
    public LightBulb getFourthBulb () {

        return this._bulb4;

    }

    /** This method recieves a number of a bulb and changes its switched value to its opposite.
     * If the bulb is on, it turns it off. If the bulb is off, it turns it on.
     *
     * @param num - Represents the number of the bulb.
     */
    public void switchBulb (int num) {

        final int NO_BULB = 0;
        final int FIRST_BULB = 1;
        final int SECOND_BULB = 2;
        final int THIRD_BULB = 3;
        final int FOURTH_BULB = 4;

        if (num <= FOURTH_BULB && num > NO_BULB)
            {if (num == FIRST_BULB)
                this._bulb1.switchLight();
            if (num == SECOND_BULB)
                this._bulb2.switchLight();
            if (num == THIRD_BULB)
                this._bulb3.switchLight();
            if (num == FOURTH_BULB)
                this._bulb4.switchLight();
            }

    }

    /** This method turns on all the bulbs at once.
     */
    public void turnAllOn () {

        if (this._bulb1.isSwitchedOn() == false)
            this._bulb1.switchLight();
        if (this._bulb2.isSwitchedOn() == false)
            this._bulb2.switchLight();
        if (this._bulb3.isSwitchedOn() == false)
            this._bulb3.switchLight();
        if (this._bulb4.isSwitchedOn() == false)
            this._bulb4.switchLight();

    }

    /** This method turns off all the bulbs at once.
     */
    public void turnAllOff () {

        if (this._bulb1.isSwitchedOn() == true)
            this._bulb1.switchLight();
        if (this._bulb2.isSwitchedOn() == true)
            this._bulb2.switchLight();
        if (this._bulb3.isSwitchedOn() == true)
            this._bulb3.switchLight();
        if (this._bulb4.isSwitchedOn() == true)
            this._bulb4.switchLight();

    }

    /** This method checks whether all light bulbs are on and returns true or false accordingly.
     *
     * @return True or false whether all light bulbs are on.
     */
    public boolean areAllOn () {

        if (this._bulb1.isSwitchedOn() == true && this._bulb2.isSwitchedOn() == true
                && this._bulb3.isSwitchedOn() == true && this._bulb4.isSwitchedOn() == true)
            return true;
        else
            return false;

    }

    /** This method checks whether all light bulbs are off and returns true or false accordingly.
     *
     * @return True or false whether all light bulbs are off.
     */
    public boolean areAllOff () {

        if (this._bulb1.isSwitchedOn() == false && this._bulb2.isSwitchedOn() == false
                && this._bulb3.isSwitchedOn() == false && this._bulb4.isSwitchedOn() == false)
            return true;
        else
            return false;

    }

    /** This method checks whether all light bulbs are the same color and returns true or false accordingly.
     *
     * @return True or false whether all light bulbs are the same color.
     */
    public boolean allSameColor () {

        if (this._bulb1 == this._bulb2 && this._bulb2 == this._bulb3 && this._bulb3 == this._bulb4)
            return true;
        else
            return false;

    }
}
