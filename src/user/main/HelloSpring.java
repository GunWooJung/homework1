package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import user.service.UserService;

public class HelloSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new FileSystemXmlApplicationContext("src/spring/applicationContext.xml");
		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
		helloSpring.menu(context);
	}
	
	public void menu(ApplicationContext context) {
		  Scanner sc = new Scanner(System.in);
          UserService user = null;
          int num = 0;
          
          while (true) {
             System.out.println("***************************");
                System.out.println("   1. 회원 정보 입력");
                System.out.println("   2. 회원 정보 출력");
                System.out.println("   3. 회원 정보 수정");
                System.out.println("   4. 회원 정보 삭제");
                System.out.println("   5. 종료");
                System.out.println("***************************");
                System.out.print("선택: ");
                num = sc.nextInt();

                if (num == 5) break;
                if (num == 1) user = (UserService)context.getBean("userInputService");
                else if (num == 2) user = (UserService)context.getBean("userOutputService");
                else if (num == 3) user = (UserService)context.getBean("userUpdateService");
                else if (num == 4) user = (UserService)context.getBean("userDeleteService");
                else {
                   System.out.println("잘못입력하셨습니다.");
                   continue;
                }
                user.execute();
          }
          
       }

}
