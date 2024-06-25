package UnitTestProject;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import UnitTestProject.Model.User;
import UnitTestProject.Repository.UserRepository;

@SpringBootTest
public class UserTest 
{
	@Autowired
	private UserRepository userRepository;
	
//	@Test
//	public void saveUser()
//	{
//		User user1 = new User();
//		user1.setUserName("EEE");
//		user1.setJob("javaDevelopper");
//		user1.setSalary(200000);
//		
//		User user2 = new User();
//		user2.setUserName("FFF");
//		user2.setJob("javaDevelopper");
//		user2.setSalary(250000);
//		userRepository.saveAll(List.of(user1,user2));
//			
//	}
	@Test
	public void getNameAndId()
	{
		User getNameAndId = userRepository.findByNameAndIdJpql("FFF",2);
		System.out.println(getNameAndId.getSalary());
	}
	
	@Test
	public void getNameAndSalary()
	{
		User get = userRepository.findByNameAndSalary("EEE", 200000);
		System.out.println(get.getSalary());
	}
	
	@Test
	public void getJobAndSalary()
	{
		List<User> getUser = userRepository.findByJobAndSalary("javaDevelopper",50000);
		
			getUser.forEach(n->
			{
				System.out.println("userId: "+n.getUserId());
				System.out.println("userName: "+n.getUserName());
				System.out.println("userJob: "+n.getJob());
				System.out.println("userSalary: "+n.getSalary());
				
			}
		);
		
		
	}
}
	

