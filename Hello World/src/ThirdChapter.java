

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThirdChapter {
    public int [] solution(String s){
        String arr[]=s.replaceAll("  "," ").split(" ");
       
        int[] answer=new int[arr.length];
        for(int i=0;i<arr.length;i++)answer[i]=Integer.parseInt(arr[i]);
        Arrays.sort(answer);
        return answer;
    }    

    public static void main(String[] args)throws IOException{
        ThirdChapter T=new ThirdChapter();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num1=Integer.parseInt(br.readLine());
        String arr1=br.readLine();
        int num2=Integer.parseInt(br.readLine());
        String arr2=br.readLine();
        arr1=arr1+" "+arr2;
        for(int x:T.solution(arr1))System.out.print(x+" ");
    }
}

*/

/*

import java.util.Scanner;

public class ThirdChapter{
    public int[] solution(int num1, int num2, int[] arr1, int[] arr2){
        int[] answer=new int[num1+num2]; //정렬한 값을 넣을 배열
        int p1=0,p2=0,i=0;
        while(p1<num1 & p2<num2 ){
            if(arr1[p1]<arr2[p2])answer[i++]=arr1[p1++]; //작은걸 먼저 넣는다.
            else answer[i++]=arr2[p2++];
        }

        //남는 것은 온통 큰수이니 넣어버린다. 이것은 두 배열이 정렬이 된 배열이여서 가능하다.
        while(p1<num1)answer[i++]=arr1[p1++];
        while(p2<num2)answer[i++]=arr2[p2++];

        return answer;
    }

    public static void main(String[] args){
        ThirdChapter T=new ThirdChapter();
        Scanner sc=new Scanner(System.in);

        int num1=sc.nextInt();
        int[] arr1=new int[num1];
        for(int i=0;i<num1;i++)arr1[i]=sc.nextInt();

        int num2=sc.nextInt();
        int[] arr2=new int[num2];
        for(int i=0;i<num2;i++)arr2[i]=sc.nextInt();

        for(int x:T.solution(num1, num2, arr1, arr2)){
            System.out.print(x+" ");
        }

        sc.close();

    }
}

//이런 쉬운 정렬 문제가 만약에 나온다면 투 포인터를 쓰는 지 확인하기위함이므로 이렇게 풀자!!!


*/

/*

import java.util.*;
class Main {	
	public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
		ArrayList<Integer> answer = new ArrayList<>();
		int p1=0, p2=0;
		while(p1<n && p2<m){
			if(a[p1]<b[p2]) answer.add(a[p1++]);
			else answer.add(b[p2++]);
		}
		while(p1<n) answer.add(a[p1++]);
		while(p2<m) answer.add(b[p2++]);
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] a=new int[n];
		for(int i=0; i<n; i++){
			a[i]=kb.nextInt();
		}
		int m=kb.nextInt();
		int[] b=new int[m];
		for(int i=0; i<m; i++){
			b[i]=kb.nextInt();
		}
		for(int x : T.solution(n, m, a, b)) System.out.print(x+" ");
	}
}

*/

/*

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThirdChapter {

    public ArrayList<Integer> solution(int num1,int num2, int[] arr1,int[] arr2){
        ArrayList<Integer> result=new ArrayList<>();
        ArrayList<Integer> answer=new ArrayList<>();
        int p1=0,p2=0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        while(p1<num1 &p2<num2){
            if(arr1[p1]<arr2[p2])result.add(arr1[p1++]);
            else result.add(arr2[p2++]);
        }

        while(p1<num1)result.add(arr1[p1++]);
        while(p2<num2)result.add(arr2[p2++]);

        for(int i=0;i<result.size()-1;i++){
            
            if(result.get(i+1).equals(result.get(i))){
                answer.add(result.get(i+1));
            }
            
        }

        return answer;
    }
    public static void main(String[] args)throws IOException{
        ThirdChapter T=new ThirdChapter();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num1=Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine()); 
        int[] arr1=new int[num1];
        int i=0;
        while(st.hasMoreTokens()){
            arr1[i++]=Integer.parseInt(st.nextToken());
        }

        int num2=Integer.parseInt(br.readLine());
        st =new StringTokenizer(br.readLine()); 
        int[] arr2=new int[num2];
        i=0;
        while(st.hasMoreTokens()){
            arr2[i++]=Integer.parseInt(st.nextToken());
        }        
        
        for(int x: T.solution(num1, num2, arr1, arr2)){
            System.out.print(x+" ");
        }
    }
}

*/

/*

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThirdChapter{
    public ArrayList<Integer> solution(int num1, int num2, int[] arr1, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1=0,p2=0;
        while(p1<num1 & p2<num2){
            if(arr1[p1]==arr2[p2]){
                answer.add(arr1[p1++]);
                p2++;
            }
            else if(arr1[p1]<arr2[p2])p1++;
            else p2++;
        }
        return answer;
    }
    public static void main(String[] args)throws IOException{
        ThirdChapter T=new ThirdChapter();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num1=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr1=new int[num1];
        int i=0;
        while(st.hasMoreTokens()){
            arr1[i++]=Integer.parseInt(st.nextToken());
        }

        int num2=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        int[] arr2=new int[num2];
        i=0;
        while(st.hasMoreTokens()){
            arr2[i++]=Integer.parseInt(st.nextToken());
        }

        for(int x:T.solution(num1, num2, arr1, arr2)){
            System.out.print(x+" ");
        }
    }
}

*/


/*

import java.io.*;
import java.util.StringTokenizer;

public class ThirdChapter{

    public int solution(int total, int continu, int[] arr){
        int answer=0;
        int max=0;
        for(int i=0;i<total-continu;i++){
            int check=0;
            for(int j=i;j<i+continu;j++){
                check+=arr[j];
            }
            if(max<check){
                max=check;
                answer=max;
            }
        }
        return answer;
    }
    public static void main(String[] args)throws IOException{
        ThirdChapter T=new ThirdChapter();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        int total=Integer.parseInt(s[0]);
        int continu=Integer.parseInt(s[1]);

        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[total];
        int i=0;
        while(st.hasMoreTokens()){
            arr[i++]=Integer.parseInt(st.nextToken());
        }
        System.out.print(T.solution(total, continu, arr));

    }
}

*/

/*

import java.util.Scanner;

public class ThirdChapter{
    public int solution(int n,int k,int[] arr){
        int answer=0, sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        answer=sum;

        for(int i=k;i<n;i++){       //예를 들어 1 2 3 4 5 6 7 8 이 있다.
            sum+=arr[i]-arr[i-k];  //1 2 3 을 더한 값이 기본 값. 이후 1 2 3 4 에서 4를 더하고 1을 빼 2 3 4를 구하는 방식. 이것이 슬라이딩 윈도우 방식
            answer=Math.max(answer, sum);
        }
        return answer;
    }
    public static void main(String[] args){
        ThirdChapter T = new ThirdChapter();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int k=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		System.out.print(T.solution(n, k, arr));
    }
}

*/



import java.io.*;
import java.util.StringTokenizer;

public class ThirdChapter{

    public int solution (int total, int goal, int[] arr){
   
        int cnt=0;

        // 1 2 1 3 1 1 1 2  
        //순서를 적어보자면 차례로 더 하다가 값이 맞으면 멈춘다. 왜냐면 어차피 숫자가 1보다 커 더해지므로 더 이상의 경우는 없기 때문.
        //그러면 1에서 모든 수를 구하면 2 다음은 1 다음은 3 이러헤
        for(int i=0; i<total;i++){  
            int sum=0;
            for(int j=i;j<total;j++){
                sum+=arr[j];
                if(goal==sum){ 
                    cnt++;
                    break;
                }
                else if(goal<sum)break; //그냥 안 맞고 값이 커지면 멈춘다. 시간낭비를 막자

            }
        }
        return cnt;
    }
    public static void main(String[] args)throws IOException{
        ThirdChapter T=new ThirdChapter();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        int total=Integer.parseInt(s[0]);
        int goal=Integer.parseInt(s[1]);
        int[] arr=new int[total];

        StringTokenizer st=new StringTokenizer(br.readLine());
        int i=0;
        while(st.hasMoreTokens()){
            arr[i++]=Integer.parseInt(st.nextToken());
        }

        System.out.print(T.solution(total, goal, arr));
    }
}


