/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hong.util.oneLineText.Worker;

/**
 * Using JavaRequManager
 * 
 * @author jakal77
 * 
 */



import com.hong.regu.work.ReguManager;


public class LineEditor {

    ReguManager worker=new ReguManager();

    /*
    one + two = result
    */
    public String getSimplePlusInBothTarget(String one,String two){
    StringBuilder result=new StringBuilder(one);
    result.append(two);
    return result.toString();    
    }
    
    public String getMergedResultsWithTarget(String targetRegu,String input){
    String results=worker.getFilteredResultByRequ(input,targetRegu, 0);
    return results;    
    }
    
    
    
    public String getPlusBeforeTarget(String input,String regu1){
    return null;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
