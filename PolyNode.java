package com.company.oldAssignments;

/** This class represents a node in a polynom.
 *
 * @author Neta Oren
 * @since 09.06.2016
 * @version 0.1
 */
public class PolyNode {

    int _power;
    double _coefficient;
    PolyNode _next;


    /** This constructor receives 'power' and 'coefficient' as params.
     * It sets the matching class variables to the value of the received params, and the '_next' variable to 'null'.
     * If it receives a negative coefficient, both the '_power' and '_coefficient' variables are set to 0.
     *
     * @param power - The power value to assign to '_power'.
     * @param coefficient - The coefficient value to assign to '_coefficient'.
     */
    public PolyNode (int power, double coefficient) {

        this._next = null;

        if (power >= 0)
        {
            this._power = power;
            this._coefficient = coefficient;
        }
        else if (power < 0)
        {
            this._power = 0;
            this._coefficient = 0;
        }
    }


    /** This constructor receives 'power', 'coefficient' and 'next' as params.
     * It sets the matching class variables to the value of the received params.
     * If it receives a negative coefficient, both the '_power' and '_coefficient' variables are set to 0.
     *
     * @param power - The power value to assign to '_power'.
     * @param coefficient - The coefficient value to assign to '_coefficient'.
     * @param next - The next value to assign to '_next'.
     */
    public PolyNode (int power, double coefficient, PolyNode next) {

        if (power >= 0)
        {
            this._power = power;
            this._coefficient = coefficient;
        }
        else if (power < 0)
        {
            this._power = 0;
            this._coefficient = 0;
        }

        this._next = next;
    }


    /** This constructor is a copy constructor.
     * It copies the value of the given param 'p' into the class variable '_next'.
     *
     * @param p - The object with value to copy.
     */
    public PolyNode (PolyNode p) {

            this._power = p._power;
            this._coefficient = p._coefficient;
            this._next = p._next;

    }


    /** This method returns the '_power' class variable.
     *
     * Runtime complexity: O(1)
     * Space complexity: O(1)
     *
     * @return The '_power' variable.
     */
    public int getPower () {

    return this._power;
    }


    /** This method returns the '_coefficient' class variable.
     *
     * Runtime complexity: O(1)
     * Space complexity: O(1)
     *
     * @return The '_coefficient' variable.
     */
    public double getCoefficient () {

        return this._coefficient;
    }


    /** This method returns the '_next' class variable.
     *
     * Runtime complexity: O(1)
     * Space complexity: O(1)
     *
     * @return The '_next' variable.
     */
    public PolyNode getNext () {

        return this._next;

    }


    /** This method sets the '_power' class variable according to the param given.
     *
     * Runtime complexity: O(1)
     * Space complexity: O(1)
     *
     * @param power - The 'power' value to set to the class variable '_power'.
     */
    public void setPower (int power) {

        if (power >= 0)
        {
            this._power = power;
        }

    }


    /** This method sets the '_coefficient' class variable according to the param given.
     *
     * Runtime complexity: O(1)
     * Space complexity: O(1)
     *
     * @param coefficient - The 'coefficient' value to set to the class variable '_coefficient'.
     */
    public void setCoefficient (double coefficient) {

        this._coefficient = coefficient;

    }


    /** This method sets the '_next' class variable according to the param given.
     *
     * Runtime complexity: O(1)
     * Space complexity: O(1)
     *
     * @param next - The 'next' value to set to the class variable '_next'.
     */
    public void setNext (PolyNode next) {

        this._next = next;

    }


    /** This method overrides the method 'toString' from the 'String' class.
     * It returns a representation of all class variables as a string.
     *
     * Runtime complexity: O(n)
     * Space complexity: O(1)
     *
     * @return A representation of all class variables as a string.
     */
    @Override
    public String toString () {

            if (this._coefficient == 0)
            {
                return "";
            }
            if (this._power == 0)
            {
                return "" + this._coefficient;
            }
            if (this._coefficient == 1)
            {
                if (this._power == 1)
                {
                    return "x";
                }
                else
                {
                    return "x^" + this._power;
                }
            }
            if (this._coefficient == -1)
            {
                if (this._power == 1)
                {
                    return "-x";
                }
                else
                {
                    return "-x^" + this._power;
                }
            }
            if (this._power == 1)
            {
                return this._coefficient + "x";
            }
            else
            {
                return this._coefficient + "x^" + this._power;
            }
        }
}




