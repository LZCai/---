package JavaA.the_seventh;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月28日 下午3:21:36
 * 
 */
public class Question08 {
	
	 private static int[] a = new int[3];
	    private static int[] bb = new int[5];



	    private static int f(int b,int myc,int hisc){
	        //多分支是来源于 用a中的哪个来选择b中的哪个

	        boolean is0 = false;

	        if(b-a[0] < 0 && b-a[1] < 0 && b-a[2] < 0){//没有能够取到的意思是说，都小于0了

	        if(myc%2 == 1&& hisc%2 == 0) return  1;
	        if(myc%2 == 1&& hisc%2 == 1) return  0;
	        if(myc%2 == 0&& hisc%2 == 1) return -1;
	        if(myc%2 == 0&& hisc%2 == 0) return  0;
	        }

	        for(int i=0;i<a.length;i++){

	            if(b-a[i]>=0){//如果没有这里的限制，将会导致本身不能进行的选择进行了  
	            int n = f(b-a[i],hisc,myc + a[i]);//如果不用n，而是用两次f(b-a[i],hisc,myc)，重复
	            if(n == -1) return  1;
	            if(n == 0)  is0 = true;//如果对面选择了一个最优化的平局，对你来说你当然并不会满足，就会再往后寻找看一下是否能赢
	            }
	        }

	        if(is0 == true){
	            is0 = false;
	            return 0;
	        }

	        //for循环完了，既没有能赢的，也没有能逼平的，只好输了
	        return -1;

	    }
	    public static void main(String[] args){
	        boolean is1 = false,is0 = false;
	        Scanner sc = new Scanner(System.in);
	        for(int i=0;i<a.length;i++){
	            a[i] = sc.nextInt();
	        }
	        for(int j=0;j<bb.length;j++){
	            bb[j] = sc.nextInt();
	        }

	        for(int k=0;k<bb.length;k++){

	        int b=bb[k],myc=0,hisc=0;

	        for(int i=0;i<a.length;i++){
	            if(b-a[i] >= 0){

	            int n = f(b-a[i],hisc,myc + a[i]);
	            if(n == -1) { is1=true; break;   }
	            if(n == 0)  { is0=true; continue;}
	               //对面return了-1，你就是胜利的
	            }
	        }
	        //自己的多次选择分别交给对手处理，根据对手的return，只要能赢就退出，如果平了再看看接下来的有没有能赢的，实在没有只好输了
	        //你选择了一个最优的，我当然也要选择一个最优的，没什么问题
	        if(is1 == true){//这里的优先级一定要搞清楚
	            is1 =false;
	            is0 =false;
	            System.out.print("+ ");
	        }
	        else if(is0 == true){
	            is0 =false;
	            System.out.print("0 ");
	        }else
	        System.out.print("- ");
	    }
	        
	}

}
