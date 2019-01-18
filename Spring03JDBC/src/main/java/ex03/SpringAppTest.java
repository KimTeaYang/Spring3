package ex03;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ex03/appContext.xml");
		
		UserDAO dao = ctx.getBean("userDAOMyBatis",UserDAO.class);
		
		System.out.println("현재 총 회원수: "+dao.getUserCount()+"명");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름=>");
		String name = sc.next();
		System.out.println("아이디=>");
		String userid = sc.next();
		System.out.println("비밀번호=>");
		String pwd = sc.next();
		
		UserVO userVO = new UserVO(0,name,userid,pwd,null);
		int n =dao.createUser(userVO);
		
		System.out.println("방금 등록한 회원의 회원번호 idx="+userVO.getIdx());
		
		System.out.println((n>0)?"등록 성공":"등록 실패");
		
		System.out.println("등록후 회원수: "+dao.getUserCount()+"명");
		
		List<UserVO> arr = dao.listUser();
		if(arr!=null) {
			for(UserVO uvo : arr) {
				System.out.println(uvo.toString());
			}
		}
		
		System.out.println("삭제 idx=>");
		String idx = sc.next();
		int n2 = dao.deleteUser(Integer.parseInt(idx));
		System.out.println((n2>0)?"삭제 성공":"삭제 실패");
		
		UserVO user2 = new UserVO(6,"김수정","sujung","123",null);
		int n3 = dao.updateUser(user2);
		
		System.out.println("수정된 회원정보-----");
		UserVO user3 = dao.getUser(6);
		System.out.println(user3.toString());
		
	}

}
