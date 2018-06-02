package acm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 64621 -- lzcai
 * @time 2017年12月4日 下午9:41:15
 * 
 */
public class DragonOrSnake {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int case_num = scan.nextInt() ;		
		int criminal_num = scan.nextInt() ;
		int message_num = scan.nextInt() ;
		
		String str = null ;
		
		List<String> mesg = new ArrayList<String>() ;
		
		for(int i=0; i <= message_num; i++){
			
			str = scan.nextLine();			
			
			mesg.add(str) ;
			
		}
		
		for(int i=0; i < mesg.size(); i++){
			
			if(!mesg.equals("")){
				String[] str_list = mesg.get(i).split(" ") ;
				
				if(str_list[0].equals("A")){
					
					String result = findThem(i, mesg) ;
					
					System.out.println(result);
				}
			}
		}
		
		scan.close(); 
	}
		
		
	
	public static String findThem(int n, List<String> mesg){
		
		int c1 = Integer.parseInt(mesg.get(n).split(" ")[1]) ;
		int c2 = Integer.parseInt(mesg.get(n).split(" ")[2]) ;
		
		Set<Integer> Dragon = new HashSet<Integer>() ;
		Set<Integer> Snake = new HashSet<Integer>() ;
		
		List<String> unsure = new ArrayList<String>() ;
		
		for(int i = 0; i < n; i ++){
			
			String m = mesg.get(i) ;
			
			if(!m.equals("")){
				
				String[] m_list = m.split(" ") ;
				
				if(m_list[0].equals("D")){
					
					int c01 = Integer.parseInt(m_list[1]) ;
					int c02 = Integer.parseInt(m_list[2]) ;
					
					if(Dragon.size() == 0 && Snake.size() == 0){
						
						Dragon.add(c01) ;
						Snake.add(c02) ;
					}else if(Dragon.contains(c01)){
						Snake.add(c02) ;
					}else if(Snake.contains(c01)){
						Dragon.add(c02) ;
					}else if(Dragon.contains(c02)){
						Snake.add(c01) ;
					}else if(Snake.contains(c02)){
						Dragon.contains(c01) ;
					}else{
						unsure.add(m) ;
					}
					
					
				}
				
			}
		
		}
		
		if(unsure.size() > 0){
			for(String m : unsure){
				
				String[] m_list = m.split(" ") ;
				
				int c01 = Integer.parseInt(m_list[1]) ;
				int c02 = Integer.parseInt(m_list[2]) ;
				
				if(Dragon.contains(c01)){
					Snake.add(c02) ;
				}else if(Snake.contains(c01)){
					Dragon.add(c02) ;
				}else if(Dragon.contains(c02)){
					Snake.add(c01) ;
				}else if(Snake.contains(c02)){
					Dragon.contains(c01) ;
				}
			}
		}
		
		if((Dragon.contains(c1) && Snake.contains(c2)) || (Dragon.contains(c2) && Snake.contains(c1))){
			return "In different gangs." ;
		}else if((Dragon.contains(c1) && Dragon.contains(c2)) || (Snake.contains(c1) && Snake.contains(c2))){
			return "In the same gang." ;
		}else{
			return "Not sure yet." ;
		}
		
	}
}
