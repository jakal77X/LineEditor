/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hong.util.oneLineText.WorkManager;

import com.hong.util.oneLineText.Worker.LineEditor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author jakal77
 */
public class OneLineEditManager {
  LineEditor worker=new LineEditor();
  String editHome="/data/textEdit/";
  String lineFeader=System.getProperty("line.separator");
  String outputPath="";
  String inputPath="";
  
  String inputFileName="input.txt";
  String outPutFileName="resultOut.txt";
  /**
     * @param args the command line arguments
     */
  
  private void initPath(){
  outputPath= setAppendAll(editHome,outPutFileName);
  inputPath=setAppendAll(editHome,inputFileName);
  }
    
    public static void printMsg(String msg){
        System.out.println(msg);
    }
    
    /* appendParam+oneLine---> plural lines
    oneLine image.honto.jp/item/1/48/2619/0128/26190128_1.jpg
    oneLine image.honto.jp/item/1/48/2619/0128/26190128_2.jpg
    ....
    in outPutPath
    --> appendParamimage.honto.jp/item/1/48/2619/0128/26190128_1.jpg
    --> appendParamimage.honto.jp/item/1/48/2619/0128/26190128_1.jpg
    */
    
    /* @Since 0.01 at 14.05.18
    
       appendPa---> paramOne to be appended first
       inputedLine---> to be appended as tail
    */
    public void setAppendBeforeItFromTargetLines(String appendPa)throws 
       IOException{
    //String oneLine=this.setAppendAll(arg);
    initPath();
    BufferedReader bri=new BufferedReader(new FileReader(inputPath));    
    BufferedWriter brw=new BufferedWriter(new FileWriter(outputPath));
    
    StringBuilder editedLines=new StringBuilder();
    String oneL="";  
        
      while(true){
      oneL=bri.readLine();
      if((oneL==null)||oneL.isEmpty()){
       break;   
      }
      oneL=this.setAppendAll(appendPa,oneL);
      editedLines.append(oneL);
      editedLines.append(lineFeader);
     }
      brw.write(editedLines.toString());
      brw.flush();
    }
   
    
    private String setAppendAll(String ... test){
    StringBuilder oneLine=new StringBuilder();
    for(String ele:test){
      oneLine.append(ele);
    }
    return oneLine.toString();
    }
    
    
    public static void main(String[] args) throws IOException{
    OneLineEditManager edit=new OneLineEditManager();
    edit.setAppendBeforeItFromTargetLines("http:/");
    }
    
}
