package test;

import java.util.Scanner;

/**
* 求两个数字字符串的乘积
* 值以字符串形式返回
*/
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		String[] inputs = s.split(" ");
		
		System.out.println(getMul(inputs[0], inputs[1]));
	}
	
	private static String getMul(String a, String b){
		StringBuilder builder = new StringBuilder();  
		
		String num_1 = new StringBuilder(a).reverse().toString();  
        String num_2 = new StringBuilder(b).reverse().toString();  
          
        int[] result = new int[num_1.length() + num_2.length()]; 
        for(int i = 0;i < num_1.length();i++){  
            for(int j = 0;j < num_2.length();j++){  
                result[i+j] += (num_1.charAt(i)-'0') * (num_2.charAt(j)-'0');  
            }  
        }  
          
        for(int i = 0;i < result.length;i++){
        	// 当前位 
            int current = result[i] % 10;
            // 进位
            int carry = result[i] / 10;          
            if(i < result.length - 1){  
                result[i+1] += carry;  
            }  
            builder.insert(0, current);
        }  
          
        while(builder.charAt(0) == '0' && builder.length() > 1){  
            builder.deleteCharAt(0);  
        }  
        
        return builder.toString(); 
	}
}
