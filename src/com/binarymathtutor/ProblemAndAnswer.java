package com.binarymathtutor;
import java.util.Random;
import java.lang.Math;

public class ProblemAndAnswer {
    private String mProblem, mAnswer;
    public ProblemAndAnswer() {   //default constructor initializes problem and answer as empty strings
        mProblem = "";
        mAnswer = "";
    }
    /** setProblem takes a string and modifies it into a Binary problem
    @param problem    The string to modify
    @return           Returns nothing but sets given object's mProblem to the problem.
  */
    public void setProblem(String problem) {
        StringBuilder myproblem = new StringBuilder();
        Random randomGenerator = new Random();
        boolean mybool = false;
        //While loop creates problem and ensures result will not be negative
        while(!mybool) {
            //First for-loop creates first binary in problem
            for (int i = 0; i < 6; i++) {
                int bit = randomGenerator.nextInt(2);
                if (bit == 1) {
                    myproblem.append(1);
                } else {
                    myproblem.append(0);
                }
            }
            //plusminus determines the operation the problem will have
            int plusminus = randomGenerator.nextInt(3);
            if (plusminus == 1) {
                myproblem.append("-");
            } else if (plusminus == 2) {
                myproblem.append("*");
            } else {
                myproblem.append("+");
            }
            //Second for-loop determines the second binary in problem
            for (int i = 0; i < 6; i++) {
                int secondbit = randomGenerator.nextInt(2);
                if (secondbit == 1) {
                    myproblem.append(1);
                } else {
                    myproblem.append(0);
                }
            }
            //if statement determines if problem will result in a negative number
            if (plusminus==1) {
                String firstbit = myproblem.substring(0,5);
                String secondbit = myproblem.substring(7,12);
                double firstdub = 0.0;
                double seconddub = 0.0;
                //for loop converts binary to decimal to perform operations
                for(int j = 0; j < firstbit.length(); j++) {
                    firstdub += ((firstbit.charAt(4-j) - '0') * Math.pow(2, j));
                    seconddub += ((secondbit.charAt(4-j)-'0') * Math.pow(2,j));
                }
                //if-else statement determines whether problem results in a negative number. If it does, the problem is
                //cleared and will be modified again.
                if (firstdub - seconddub >= 0) {
                    mybool = true;
                }
                else {
                    myproblem.setLength(0);
                }
            }
            else {
                mybool=true;
            }
        }
        //sets problem equal to string and returns problem.
        problem = myproblem.toString();
        this.mProblem = problem;
    }
    /** setAnswer takes in a string and modifies it to the correct answer for the ProblemAndAnswer object
       @param answer        Given string to modify to correct answer
       @return              Returns nothing but sets object's mAnswer to modified answer string
    */
    public void setAnswer(String answer) {
        StringBuilder myanswer = new StringBuilder();
        //Following to strings split the problem string into two seperate strings which contain the two binaries
        String firstbit = mProblem.substring(0,6);
        String secondbit = mProblem.substring(7);
        double firstdub = 0.0;
        double seconddub = 0.0;
        double dubanswer = 0.0;
        //For-loop converts binaries to decimals
        for (int j = 0; j < firstbit.length(); j++) {
            firstdub += (((firstbit.charAt(5-j)) - '0') * Math.pow(2, j));
            seconddub += ((secondbit.charAt(5-j)-'0') * Math.pow(2,j));
        }
        //Following if-else statements determine the operation and give answer for problem in decimal
        if (mProblem.charAt(6) == '-') {
            dubanswer = firstdub - seconddub;
        }
        else if (mProblem.charAt(6)== '+') {
            dubanswer = firstdub + seconddub;
        }
        else if (mProblem.charAt(6)== '*') {
            dubanswer = firstdub * seconddub;
        }
        //Below casts double version of answer to int version of answer
        int intanswer = (int)dubanswer;
        //Below while loop converts answer to decimal
        while(intanswer>0) {
            myanswer.append(String.valueOf((int)(intanswer % 2)));
            intanswer /= 2;
        }
        //The myaswer given by while loop is in reverse order, so it must be reversed and then mAnswer is set to answer.
        answer= myanswer.reverse().toString();
        mAnswer = answer;
    }

    /** getProblem is a getter method which returns mProblem data
    @return         Returns mProblem data
     */
    public String getProblem() {
        return mProblem;
    }
    /** getAnswer is a getter method which returns mAnswer data
    @return         Returns mAnswer data
     */
    public String getAnswer() {
        return mAnswer;
    }
    /** checkAnswer takes in a string and returns a boolean if it is the same as mAnswer
     @param response        Given string to evaluate against mAnswer
     @return                Returns true if response is equal to mAnswer
     */

    public boolean checkAnswer(String response) {
        return response.equals(mAnswer);
    }

}
