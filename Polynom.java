package com.company.oldAssignments;

/** This class represents a polynom.
 *
 * @author Neta Oren
 * @since 09.06.2016
 * @version 0.1
 */
public class Polynom {

    private PolyNode _head;


    /** This constructor creates an empty list.
     */
    public Polynom () {

        this._head = null;

    }


    /** This constructor receives as param an object from the 'PolyNode' class.
     * It adds the object to the beginning of the list.
     *
     * @param p - The PolyNode object to add to the polynom.
     */
    public Polynom (PolyNode p) {

        if (p != null)
        {
            this._head = p;
        }

    }


    /** This method receives as param an object from the 'PolyNode' class
     * It adds the object to the polynom (in the right place).
     * It returns the new polynom.
     *
     * Runtime complexity: O(n)
     * Space complexity: O(1)
     *
     * @param p - The PolyNode object to add to the polynom.
     * @return The new polynom.
     */
    public Polynom addNode (PolyNode p) {

        PolyNode x = this._head;
        boolean flag = true;

        if (x == null)
        {
            this._head = new PolyNode(p.getPower(), p.getCoefficient());
            return this;
        }
        else
        {
            while (flag)
            {
                if (this._head.getPower() < p.getPower())
                {
                    PolyNode temp = this._head;
                    PolyNode temp2 = new PolyNode(p.getPower(), p.getCoefficient());
                    this._head = temp2;
                    this._head.setNext(temp);
                    return this;
                }
                else if (x.getNext() != null && x.getNext().getPower() < p.getPower())
                {
                    PolyNode temp = x.getNext();
                    PolyNode temp2 = new PolyNode(p.getPower(), p.getCoefficient());
                    x.setNext(temp2);
                    x = x.getNext();
                    x.setNext(temp);
                    return this;
                }
                else if (x.getNext() != null)
                {
                    if (x.getNext().getPower() == p.getPower())
                    {
                        x.getNext().setCoefficient(x.getNext().getCoefficient() + p.getCoefficient());
                        return this;
                    }
                }
                if (x.getNext() != null)
                {
                    x = x.getNext();
                }
                else
                {
                    flag = false;
                }
            }

            x.setNext(new PolyNode(p.getPower(), p.getCoefficient()));
        }

        return this;
    }


    /** This method receives as param a whole number (scalar).
     * It multiplies the polynom by the given scalar.
     * It returns the new polynom.
     *
     * Runtime complexity: O(n)
     * Space complexity: O(1)
     *
     * @param num - The scalar by which to multiply the polynom.
     * @return The new polynom.
     */
    public Polynom multByScalar (int num) {

        PolyNode temp = this._head;

        while (temp != null)
        {
            temp.setCoefficient(temp.getCoefficient() * num);
            temp = temp.getNext();
        }

        return this;
    }


    /** This method receives as param another polynom.
     * It adds it to the polynom on which the method is acted upon.
     * It returns the summed polynom.
     *
     * Runtime complexity: O(n)
     * Space complexity: O(1)
     *
     * @param other - The polynom to add to the polynom on which the method is acted upon.
     * @return The summed polynom.
     */
    public Polynom addPol (Polynom other) {

        PolyNode x = other._head;

        while (x != null)
        {
            this.addNode(x);
            x = x.getNext();
        }

        return this;
    }


    /** This method receives as param another Polynom.
     * It multiplies the received polynom by the polynom on which the method is acted upon.
     * It returns the multiplied polynom.
     *
     * Runtime complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param other - The polynom to multiply.
     * @return The multiplied polynom.
     */
    public Polynom multPol (Polynom other) {

        PolyNode thisNode = this._head;
        PolyNode otherNode = other._head;
        Polynom result = new Polynom();
        PolyNode temp;

        while (thisNode != null)
        {
            while (otherNode != null)
            {
                temp = new PolyNode((otherNode.getPower() + thisNode.getPower()),(otherNode.getCoefficient() * thisNode.getCoefficient()));
                result.addNode(temp);
                otherNode = otherNode.getNext();
            }

            otherNode = other._head;
            thisNode = thisNode.getNext();
        }

        this._head = result._head;
        return this;
    }


    /** This method calculated the differential of the polynom on which the method is acted upon.
     * It returns the polynomial differential.
     *
     * Runtime complexity: O(n)
     * Space complexity: O(1)
     *
     * @return The polynomial differential.
     */
    public Polynom differential () {

        PolyNode temp = this._head;
        int power;

        while (temp != null)
        {
            power = temp.getPower();
            temp.setCoefficient(temp.getCoefficient() * power);
            temp.setPower(power - 1);
            temp = temp.getNext();
        }

        return this;
    }


    /** This method overrides the 'toString' method from the 'String' class.
     * It returns a string representation of the polynom.
     *
     * Runtime complexity: O(n)
     * Space complexity: O(1)
     *
     * @return A string representation of the polynom.
     */
    @Override
    public String toString () {

        String str = "";
        PolyNode current = this._head;

        while (current != null)
        {
            if (!str.equals("") && current.getCoefficient() > 0)
            {
                str += "+";
            }

            str += current;
            current = current.getNext();
        }

        return str;
    }
}
