package chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//https://algospot.com/judge/problem/read/TSP1
public class TravelingSalesMan {
    static int testcase;
    static int city;
    static double[][] distance;
    static int[] visited;
    static int shortestPath = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine().trim());
        for (int test=0; test<testcase; test++) {
            city = Integer.parseInt(br.readLine().trim());
            distance = new double[city][city];
            visited = new int[city];
            for (int r=0; r<city; r++) {
                String[] strs = br.readLine().split("  ");
                for (int c=0; c<city; c++) {
                    distance[r][c] = Double.parseDouble(strs[c]);
                }
            }
            Stack<Integer> stack = new Stack<>();
            for (int i=0; i<city; i++) {
                stack.push(i);
                solve(0, stack);
                stack.pop();
            }
            System.out.println(shortestPath);
            shortestPath = Integer.MAX_VALUE;
        }
    }
    public static int getStart() {
        for (int i=0; i<city; i++) {
            if (visited[i]==0) return i;
        }
        return -1;
    }
    public static void solve(int path, Stack<Integer> s) {
        if (s.size()==city) {
            shortestPath = Math.min(shortestPath, path);
            return;
        }
        int start = s.peek();
        visited[start]=1;
        for (int i=0; i<city; i++) {
            if (i==start) continue;
            if (visited[i]==1) continue;
            s.push(i);
            solve(path+(int)distance[start][i], s);
            s.pop();
        }
        visited[start] = 0;
    }
}
