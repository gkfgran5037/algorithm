package level3;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/* 프로그래머스 - 2017 카카오코드 예선 - 카카오 프렌즈 컬러링북
 * 
 * 분제
 *  - 출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다. 
 *    여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. 
 *    (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)
 *    그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.
 * 
 * 입력형식
 *  - 입력은 그림의 크기를 나타내는 m과 n, 그리고 그림을 나타내는 m × n 크기의 2차원 배열 picture로 주어진다. 제한조건은 아래와 같다.
 *      1) 1 <= m, n <= 100
 *      2) picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
 *      3) picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.
 * 
 * 출력형식
 *  - 리턴 타입은 원소가 두 개인 정수 배열이다. 그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.
 * 
 *  - 시험은 최대 10,000 문제로 구성되어있습니다.
 *    문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 *    가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 *    
 * 입출력 예
 *  - 입력  m : 6 / n : 4 / picture : [[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]
 *    출력 [4, 5]
 */
public class Kakao_ColoringBook_1 {
    public static void main(String[] args) throws IOException {
        int m = 6;
        int n = 4;
        int[][]picture = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        
        int[]result = solution(m, n, picture);
        
        System.out.println(result[0] + " " + result[1]);
    }
 
    public static int[] solution(int m, int n, int[][] picture) {
        // 방문배열
        int visited[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = (picture[i][j] == 0)? -1 : 0;
            }
        }
        int[]move1 = {1, -1, 0, 0};
        int[]move2 = {0, 0, 1, -1};
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        for(int i = 0; i < picture.length; i++){
            for(int j = 0; j < picture[i].length; j++){
                // 색칠이 된 상태 && 미방문
                if(picture[i][j] != 0 && visited[i][j] == 0){
                    numberOfArea += 1; 
                    int areaSize = 0;
                    visited[i][j] = picture[i][j];
                    
                    Queue<Point> q = new LinkedList<Point>();
                    q.add(new Point(i, j));
                    
                    // BFS
                    while(!q.isEmpty()){
                        Point p = q.poll();
                        areaSize += 1;
                        
                        for(int mv = 0; mv < 4; mv++){
                            int my = p.y + move1[mv];
                            int mx = p.x + move2[mv];
                            
                            if(my < 0 || my >= m || mx < 0 || mx >= n)
                                continue;
                            
                            if(visited[my][mx] != 0 || picture[my][mx] == 0)
                                continue;
                            
                            // 값에 따라 구역을 나눔.
                            if(picture[my][mx] != visited[p.y][p.x])
                                continue;
                            
                            q.add(new Point(my, mx));
                            visited[my][mx] = visited[p.y][p.x];
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaSize);
                }// 색칠 방문
            } // for
        } // for
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
}

class Point{
    int y;
    int x;
    
    public Point(int y, int x){
        this.y = y;
        this.x = x;
    }
}
