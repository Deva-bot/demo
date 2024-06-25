package UnitTestProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import UnitTestProject.Model.User;

public interface UserRepository extends JpaRepository<User,Long>
{
	//indexed param
	@Query("select u from User u where u.userName=?1 and u.userId=?2")
	public User findByNameAndIdJpql(String name,int id);
	
	// named param
	@Query("select u from User u where u.userName =:name and u.salary =:sal")
	public User findByNameAndSalary(@Param("name")String name,@Param("sal")int salary);
	
	//NativeQuery using index param
	@Query(value = "SELECT * FROM user WHERE job = ?1 AND salary >=?2", nativeQuery = true)
	public List<User> findByJobAndSalary(String job, int salary);
	
	
}
