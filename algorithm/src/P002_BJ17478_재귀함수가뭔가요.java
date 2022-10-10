package 공진호;

import java.util.Scanner;

public class P002_BJ17478_재귀함수가뭔가요 {
	
	static String depth_line = "";

	static void recursion(int current, int target){
        String current_line  = depth_line;
        if (current == target){
            System.out.println(current_line +"\"재귀함수가 뭔가요?\"");
            System.out.println(current_line + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(current_line +"라고 답변하였지.");
        }
        else{
            System.out.println(current_line +"\"재귀함수가 뭔가요?\"");
            System.out.println(current_line +"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            System.out.println(current_line +"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            System.out.println(current_line +"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
            depth_line += "____";
            recursion(current+1, target);
            System.out.println(current_line +"라고 답변하였지.");
            
        }

    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursion(0, n);
        
    }

}
