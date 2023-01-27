package com.binarymathtutor;

public class BinaryMathTutor {
    public ProblemAndAnswer[] mylist = new ProblemAndAnswer[15];
    /** BinaryMathTutor constructs a BinaryMathTutor object which is an array of 15 ProblemAndAnswer Objects.
     * While-loop has embedded for-loop which creates the BinaryMathTutor object. It then checks the object
     * with the checkList method. If checkList is true, the list is assigned to mylist. If not, another newlist is
     * created.
     */
    public BinaryMathTutor() {
        boolean truebool = false;
        while(!truebool) {
            ProblemAndAnswer[] newlist = new ProblemAndAnswer[15];
            for (int q = 0; q < 15; q++){
                newlist[q] = new ProblemAndAnswer();
                newlist[q].setProblem(newlist[q].getProblem());
                newlist[q].setAnswer(newlist[q].getAnswer());
            }
            truebool = checkList(newlist);
            if(truebool) {
                mylist = newlist;
            }
        }
    }

    /**
     * checkList evaluates a given array of ProblemAndAnswer objects and ensures that there are 5 of each type of
     * operation: +, -, *. It evaluates these in a series of if-else statements in a for-loop.
     * @param mylist        Given array to evaluate.
     * @return              Returns boolean. If it is true, then mylist param has 5 of each type of operation.
     */

    public boolean checkList(ProblemAndAnswer[] mylist) {
        int minus=0;
        int plus=0;
        int times=0;
        for(int l = 0; l < 15; l++) {
            if(mylist[l].getProblem().charAt(6) == '-') {
                minus++;
            }
            else if (mylist[l].getProblem().charAt(6) == '+') {
                plus++;
            }
            else if (mylist[l].getProblem().charAt(6) == '*') {
                times++;
            }
        }
        return (minus == 5 && plus == 5 && times == 5);
    }
}
