import java.util.*;
class Solution {
    int[][] visited;
    int[][] maps;
    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        for (int i = 0; i < visited.length; i++)
            Arrays.fill(visited[i],Integer.MAX_VALUE);
        this.maps = maps;
        int answer = bfs();
        return (answer==Integer.MAX_VALUE)?-1:answer;
    }
    
    int bfs(){
        int[][] dxy = {{0,1},{0,-1},{1,0},{-1,0}}; //동서남북
        visited[0][0] = 1;
        ArrayDeque<int[]> a = new ArrayDeque<>();
        a.add(new int[]{0,0});
        
        while (!a.isEmpty()){
            int[] now = a.pollFirst();
            int x = now[0];
            int y = now[1];
            for (int[] d : dxy){
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) //범위 제한 초과
                    continue;
                if (maps[nx][ny] == 0) //벽
                    continue;
                if (visited[nx][ny] <= visited[x][y]+1)//새것보다 옛것이 짧거나 같다면
                    continue;
                visited[nx][ny] = visited[x][y] + 1;
                a.add(new int[]{nx,ny});
            }
        }

        return visited[maps.length-1][maps[0].length-1];
    }
}