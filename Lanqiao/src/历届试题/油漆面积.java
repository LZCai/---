package 历届试题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月10日 上午8:46:10
 * 
 */
public class 油漆面积 {
	
	public static int n ;
	
	public static Edge[] edges ;
	
	public static int[] X ;
	
	public static Node[] tree ;
	
	//创建树
	public static void build(int index, int l, int r){
		
		tree[index] = new Node(l, r, 0, 0) ;
		
		if(l == r) return ;
		
		int mid = (l+r)/2 ;
		
		build(index*2, l, mid) ;
		build(index*2 + 1, mid+1, r) ;
		
	}
	
	public static void pushup(int index){
		
		if(tree[index].cover != 0){ //该节点被扫描线覆盖
			
			tree[index].len = X[tree[index].r + 1] - X[tree[index].l] ;
			
		}else if(tree[index].l == tree[index].r){ //叶子节点，长度为0 ;
			
			tree[index].len = 0 ;
			
		}else{ //该节点所代表的区间没有被完全覆盖，合并左右子集的信息
			
			tree[index].len = tree[index*2].len + tree[index*2 + 1].len ;
			
		}
			
	}

	public static void update(int l, int r, int index, int val){//遍历区间，并记录、判断区间是否被扫描
		
		if(tree[index].l == l && tree[index].r == r){
			
			tree[index].cover += val ; //该区间被扫入，或扫出
			
			pushup(index) ; //更新扫描线的覆盖长度
			
			return ;
		}
		
		int mid = (tree[index].l + tree[index].r)/2 ;
		
		if(r<=mid) update(l, r, index*2, val) ;
		else if(l>mid) update(l, r, index*2+1, val) ;
		else{
			
			update(l, mid, index*2, val) ;
			update(mid+1, r, index*2+1, val) ;
			
		}
		
		pushup(index) ;
		
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		n = scan.nextInt() ;
		
		edges = new Edge[2*n];
		
		X = new int[2*n] ;
		
		tree = new Node[4*n] ;
		
		int index = 0 ;
		
		for(int i=0 ; i<n ; i++){ //读取控制台数据
			
			int x1 = scan.nextInt() ;
			int y1 = scan.nextInt() ;
			int x2 = scan.nextInt() ;
			int y2 = scan.nextInt() ;
			
			X[index] = x1 ;
			edges[index] = new Edge(x1, x2, y1, 1) ;
			
			X[++index] = x2 ;
			edges[index] = new Edge(x1, x2, y2, -1) ;
			
			index ++ ;
			
		}
		
		Arrays.sort(X); //对矩形的横坐标进行排序
		Arrays.sort(edges);
		
		int k = 1 ;
		for(int j=1 ; j<X.length ; j++){  //对X中的数据进行去重
			
			if(X[j] != X[j-1])
				
				X[k++] = X[j] ;
			
		}
		
		build(1, 0, k-1) ; //构建线段树，长度为X中不重复横坐标的个数
		
		int ans = 0 ;
		
		for(int i=0 ; i<edges.length ; i++){ //从下到上，扫描每条线
			
			
		}
		
	}
}

class Edge implements Comparable<Edge>{
	
	int l ;//线段左端点
	int r ;//线段右端点
	int h ;//线段的y值
	int f ;//线段是矩形的入边还是出边
	
	public Edge(int l, int r, int h, int f) {
		
		this.l = l ;
		this.r = r ;
		this.h = h ;
		this.f = f ;
		
	}
	
	public String toString(){
		
		return h+"" ;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Edge o) {
		
		return h > o.h ? 1 : (h == o.h ? 0 : -1);
	}

}
class Node{
	
	
	int l ; //横坐标的区间，横坐标数组的下标
	int r ;
	int cover ;
	int len ;
	
	public Node(int l, int r, int c, int len){
		
		this.l = l ;
		this.r = r ;
		this.cover = c ;
		this.len = len ;
		
	}
}
