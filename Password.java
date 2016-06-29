package com.company.oldAssignments;
import java.util.Random;

/**
 * Created by Neta on 04/06/2016.
 */


public class Password
{
    private String _password = "";

    public Password(int length)
    {
        Random generator = new Random();
        for (int i = 0; i < length; i++) {
            this._password += (char)(generator.nextInt(26) + 97);
        }
    }

    public boolean isPassword(String st)
    {
        return st.equals(this._password);
    }

    public String getPassword()
    {
        return this._password;
    }
}
