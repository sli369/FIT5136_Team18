package com.company;

public class Validate {

    public Validate()
    {

    }


     //method to check whether the input is int
    public boolean checkInt(String number)
    {
        try
        {
            int i = Integer.parseInt(number);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }


     //method to check whether the input number is within valid range
    public boolean checkRange(int inputNumber, int mini, int maxi)
    {
        if(inputNumber > maxi || inputNumber < mini)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
