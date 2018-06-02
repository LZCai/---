package JavaA.the_fifth;

import java.util.ArrayList;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月25日 上午10:24:40
 * 
 */
public class Question03 {
	
	public static int count ;
	
	public static void main(String[] args){
		
		//用于产生所有的四位数
		ArrayList<Integer> num_list = new ArrayList<Integer>() ;
		
		for(int i=1 ; i<=9 ; i++){
			
			for(int j=0 ; j<=9 ; j++){
				
				for(int k=0 ; k<=9 ; k++){
					
					for(int l=0 ; l<=9 ; l++){
						
						if(i==j || i==k || i==l || j==k || j==l || k==l)
							
							continue ;
						
						num_list.add(i*1000+j*100+k*10+l) ;
					}
				}
			}
		}
		
		//遍历四位数的数列，分别判断每个数是否符合题目要求，并把符合要求的数据加入新的数列
		for(int i=0 ; i<num_list.size() ; i++){
			
			for(int j=1 ; j<4 ; j++){
				
				int a = num_list.get(i)/(int)Math.pow(10, j) ;
				
				int b = num_list.get(i) - a*(int)Math.pow(10, j) ;
				
				int c = a*b ; 
				
				String cs = Integer.toString(c) ;
				String num = Integer.toString(num_list.get(i)) ;
				
				
				
				if(cs.length() == num.length()){
					
					boolean f = true ;
					
					for(int k=0 ; k<num.length() ; k++){
						
						if(!cs.contains(num.substring(k, k+1))){
							
							f = false ;
						}
							
					}
					
					if(f){
					count ++ ;
					System.out.println(a+" * "+b+" = "+c);
					}
				}
			}
		}
		
		System.out.println(count);
	}
	
}
