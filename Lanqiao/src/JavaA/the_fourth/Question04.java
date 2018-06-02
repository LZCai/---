package JavaA.the_fourth;

import java.util.ArrayList;
import java.util.List;

public class Question04 {
    
    static class number{
    	
    	public int num ;
    	
    	public int money ;
    	
    	public number(int num, int money){
    		
    		this.num = num ;
    		this.money = money ;
    		
    	}
    }
    
    public static void main(String[] args){
    	
    	List<number> list2 = new ArrayList<number>() ;
    	List<number> list8 = new ArrayList<number>() ;
    	
    	for(int i=1000 ; i<9999 ; i++){
    		
    		StringBuilder sb = new StringBuilder(i+"") ;
    		
    		String n1 = sb.reverse().toString();
    		
    		char[] n_byte = n1.toCharArray() ;
    		
    		for(int j=0 ; j<n_byte.length ; j++){
    			
    			if(n_byte[j] == '6'){
    				
    				n_byte[j] = '9' ;
    				
    			}else if(n_byte[j] == '9'){
    				
    				n_byte[j] = '6' ;
    			}
    		
    		}
    		
    		int n2 = Integer.valueOf(new String(n_byte)) ;
    		
    		if(200 < i-n2 && i-n2 < 300){
    			
    			list2.add(new number(i, i-n2)) ;
    		}
    		
    		if(800 < n2-i && n2-i < 900){
    			
    			list8.add(new number(i, n2-i)) ;
    		}
    	}
    	
    	for(int i=0 ; i<list8.size() ; i++){
    		
    		for(int j=0 ; j<list2.size() ; j++){
    			
    			if(list8.get(i).money - list2.get(j).money == 558){
    				
    				System.out.println(list8.get(i).num +" , "+list2.get(j).num);
    			}
    		}
    	}
    }
}