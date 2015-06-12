/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * The model class of the calculator application.
 */
public class Calculator extends Subject{
    
    /**
     * The available operators of the calculator.
     */
    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL   // MR
    }
    
    private String Digit;
    private String mDigit;
    private String operator_sign;
    
    /**
     * 建構子
     */
    public Calculator (){
        Digit = "";
        mDigit = "";
        operator_sign = "+";
        
    }
    /**
     * 
     *  數字鍵
     */
    public void appendDigit(int digit) {
        // TODO code application logic here
        Digit += digit;
        Notify();
    }
    
    /**
     * 按小數點
     */
    public void appendDot() {
        // TODO code application logic here
        
        if(Digit.indexOf(".")<0) Digit += ".";
            // String1.indexof(String2);
            // "1234".indexof("3");
        Notify();
    }
    
    /**
     * 
     * 運算符號
     */
    public void performOperation(Operator operator) {
        // TODO code application logic here
        switch(operator)
        {
            case PLUS_MINUS:
                
            Digit = String.valueOf(Double.valueOf(Digit)-Double.valueOf(Digit)*2);
                break;
            case CLEAR:
                Digit = "";
                mDigit = "";
                break;
            case BACKSPACE:
                if (Digit.length()>0)
                    Digit = Digit.substring(0, Digit.length()-1);
                 
                break;
                
            case PLUS:
                
                operator_sign = "+";
                performOperation(Operator.EQUAL);
                mDigit = Digit;
                Digit = "";
                break;
            
            case MINUS:
                
                operator_sign = "-";
                performOperation(Operator.EQUAL);
                mDigit = Digit;
                Digit = "";
                break;
            
            case TIMES:
                
                operator_sign = "*";
                performOperation(Operator.EQUAL);
                mDigit = Digit;
                Digit = "";
                break;
            
            case OVER:
                
                operator_sign = "/";
                performOperation(Operator.EQUAL);
                mDigit = Digit;
                Digit = "";
                break;
            
            case EQUAL:
                if(Digit.equals("")|mDigit.equals(""))
                    return;
                switch(operator_sign)
                {
                    case "+":
                        /*if(Digit.length() == 0) Digit = "0.0";
                        if(mDigit.length() == 0) mDigit = "0.0";
                        */
                        Digit = String.valueOf(Double.parseDouble(mDigit) + Double.parseDouble(Digit));
                        break;
                    case "-":
                        Digit = String.valueOf(Double.parseDouble(mDigit) - Double.parseDouble(Digit));
                        break;
                    case "*":
                        Digit = String.valueOf(Double.parseDouble(mDigit) * Double.parseDouble(Digit));
                        break;
                    case "/":
                        Digit = String.valueOf(Double.parseDouble(mDigit) / Double.parseDouble(Digit));
                        break;
                }
            break;
            
        }
        Notify();
    }
    
    /**
     * 
     * 回傳Digit 
     */
    public String getDisplay() {
        // TODO code application logic here
        return Digit;
        
        
    }

 
}
