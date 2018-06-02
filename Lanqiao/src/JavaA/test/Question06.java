package JavaA.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月29日 下午4:00:29
 * 
 */
public class Question06 {
	
	public static ArrayList<Integer> list = new ArrayList<Integer>();
    public static int count = 0;   //代表输入折线中所含顶点最少数目
    public static int result = 0;  //最终输出结果
    public static int[][] judgeMid = new int[10][10];  //填写两点之间有中间节点的情形
    
    public boolean check1() {   //判断当前路径是否符合行走规则
        boolean[] used = new boolean[10];
        for(int i = 0;i < 10;i++)
            used[i] = false;
        for(int i = 0;i < list.size() - 1;i++) {
            used[list.get(i)] = true;
            int now = list.get(i);
            int next = list.get(i + 1);
            if(judgeMid[now][next] != 0) {
                int mid = judgeMid[now][next];
                if(used[mid] == true)
                    continue;
                else
                    return false;
            }
        }
        return true;
    }
    
    public boolean check2(int[][] edge) {  //判断当前路径是否包含题意所输入折线边
        if(list.size() > 3 &&list.size() >= count && check1()) {
            for(int i = 0;i < edge.length;i++) {
                if(list.contains(edge[i][0]) && list.contains(edge[i][1])) {
                    int a = list.indexOf(edge[i][0]);
                    int b = list.indexOf(edge[i][1]);
                    if(Math.abs(a - b) == 1) 
                        continue;
                    else
                        return false;
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public void dfs(int[][] edge, int step) {    
        if(step == 9) {
            return;
        } else {
            for(int i = 1;i < 10;i++) {
                if(list.contains(i))
                    continue;
                list.add(i);
                if(check2(edge)) {
                    result++;
                }
                dfs(edge, step + 1);
                list.remove(list.size() - 1);
            }
        }
        return;
    }
    
    public static void main(String[] args) {
        judgeMid[1][3] = judgeMid[3][1] = 2;
        judgeMid[1][7] = judgeMid[7][1] = 4;
        judgeMid[1][9] = judgeMid[9][1] = 5;
        judgeMid[2][8] = judgeMid[8][2] = 5;
        judgeMid[3][7] = judgeMid[7][3] = 5;
        judgeMid[3][9] = judgeMid[9][3] = 6;
        judgeMid[4][6] = judgeMid[6][4] = 5;
        judgeMid[7][9] = judgeMid[9][7] = 8;
    
        Question06 test = new Question06();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] edge = new int[N][2];
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0;i < N;i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            set.add(a);
            set.add(b);
            edge[i][0] = a;
            edge[i][1] = b;
        }
        count = set.size();
        test.dfs(edge, 0);
        System.out.println(result);
    }

}
