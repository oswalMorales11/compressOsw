/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compressproject;

/**
 *
 * @author oswal
 */
public class CompressProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       String result = compress("AAABBAAAAABB");
        System.out.println("result es: "+result);
    }

    
    public static String compress(String input){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int limit = input.length() - 1;
        char next = '\0';
        while (i < limit)
        {
            int count = 1;
            next = input.charAt(i++);
            while (i <= limit && next == input.charAt(i))
            {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(next);
            
        }
        if(i == limit)
        {
            sb.append(input.charAt(i));
            sb.append(1);
        }
        return sb.toString();
    }
    
    
    
}
