package ex04;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ex04/appContext.xml");
		
		UserDAO dao = ctx.getBean("userDAOMyBatis",UserDAO.class);
		
		System.out.println("현재 총 회원수: "+dao.getUserCount()+"명");
		
		List<UserVO> arr = dao.listUser();
		if(arr!=null) {
			for(UserVO uvo : arr) {
				System.out.println(uvo.toString());
			}
		}
		
		
	}

}
