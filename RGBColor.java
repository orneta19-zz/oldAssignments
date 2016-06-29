package com.company.oldAssignments;

/**
 * Created by Neta on 06/05/2016.
 */

    public class RGBColor
    {
        private int _red;
        private int _green;
        private int _blue;
        private static final int MAX_COLOR_VAL = 255;

        public RGBColor()
        {
            this._red = (this._green = this._blue = 0);
        }

        public RGBColor(int red, int green, int blue)
        {
            if (validColor(red)) {
                this._red = red;
            }
            if (validColor(green)) {
                this._green = green;
            }
            if (validColor(blue)) {
                this._blue = blue;
            }
        }

        public RGBColor(RGBColor other)
        {
            if (other != null)
            {
                this._red = other._red;
                this._green = other._green;
                this._blue = other._blue;
            }
        }

        public int getRed()
        {
            return this._red;
        }

        public int getGreen()
        {
            return this._green;
        }

        public int getBlue()
        {
            return this._blue;
        }

        public void setRed(int num)
        {
            if (validColor(num)) {
                this._red = num;
            }
        }

        public void setGreen(int num)
        {
            if (validColor(num)) {
                this._green = num;
            }
        }

        public void setBlue(int num)
        {
            if (validColor(num)) {
                this._blue = num;
            }
        }

        public String toString()
        {
            return "(" + this._red + "," + this._green + "," + this._blue + ")";
        }

        public boolean equals(RGBColor other)
        {
            if (other == null) {
                return false;
            }
            if (other.getRed() == this._red) {}
            return ((other.getGreen() == this._green ? 1 : 0) & (other.getBlue() == this._blue ? 1 : 0)) != 0;
        }

        public void mix(RGBColor other)
        {
            if (other != null)
            {
                this._red = ((this._red + other._red) / 2);
                this._green = ((this._green + other._green) / 2);
                this._blue = ((this._blue + other._blue) / 2);
            }
        }

        public double convertToGrayscale()
        {
            return 0.3D * this._red + 0.59D * this._green + 0.11D * this._blue;
        }

        public void invert()
        {
            this._red = (255 - this._red);
            this._green = (255 - this._green);
            this._blue = (255 - this._blue);
        }

        private boolean validColor(int num)
        {
            return (num >= 0) && (num <= 255);
        }
    }


