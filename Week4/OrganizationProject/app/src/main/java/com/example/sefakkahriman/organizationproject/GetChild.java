package com.example.sefakkahriman.organizationproject;


public class GetChild {

    /*Inputs
     *
     * B2, E5, F6
     * A1, B2, C3, D4
     * D4, G7, I9
     * G7, H8
     * */
    int depth = 0;

    //get the child of parent and make a recursive call

    public void printChild(Person parent) {
        this.depth++;
        for (int i = 0; i < parent.getChildListSize(); i++) {
            Person child = parent.getChildByIndex(i);
            for(int j = 0; j < this.depth; j++){
                System.out.print("    ");
            }
            System.out.println(parent.getChildByIndex(i).getName());
            printChild(parent.getChildByIndex(i));
        }
        this.depth = this.depth - 1;
    }
}




