package com.example.calculator;

import android.app.AlertDialog;
import android.app.Dialog;

import androidx.fragment.app.FragmentManager;

import java.util.Stack;
import java.util.zip.DeflaterOutputStream;

public class EvaluateString
{
    public static boolean hasPrecedence(char op1, char op2)
    {

        if ((op1 == 'x' || op1 == ':') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static double applyOp(char op, double b, double a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case 'x':
                return a * b;
            case ':':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    public static boolean  checksig(char sig)
    {
        if (sig == 'x' || sig == ':' || sig == '-' || sig == '+')
            return  true;
        return false;
    }

    public static double evaluate(String expression)
    {
        int check=0;

        if (expression.charAt(0)=='*' || expression.charAt(0)==':' || expression.charAt(expression.length())==':' || expression.charAt(expression.length())=='x'
        || expression.charAt(expression.length())=='+' ||expression.charAt(expression.length())=='-'  )
            check=1;

        for (int i=0; i<expression.length()-1; i++)
            if (checksig(expression.charAt(i)) && checksig(expression.charAt(i))) {
                check = 1;
                break;
            }

        if (check == 1){
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.getContext());
            builder1.setMessage("Error!");
            builder1.setCancelable(true);
            AlertDialog alert11 = builder1.create();
            alert11.show();
            return 0;
        }


        if (expression.charAt(0)=='-' || expression.charAt(0)=='+') expression= "0"+ expression;
        char[] tokens = expression.toCharArray();

        // Stack for numbers: 'values'
        Stack<Double> values = new Stack<Double>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++)
        {
            // Current token is a whitespace, skip it
            // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;

            // Current token is a number, push it to stack for numbers
            if ( (tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.')
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.'))
                    sbuf.append(tokens[i++]);
                values.push(Double.parseDouble(sbuf.toString()));
                if (i != tokens.length - 1){
                    i--;
                }
            }
            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == 'x' || tokens[i] == ':')
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }

        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        // Top of 'values' contains result, return it
        return values.pop();

    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.




}

