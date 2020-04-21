package Text;

import cn.kgc.mp.mapper.EmplyoeeMapper;
import cn.kgc.mp.pojo.Employee;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 罗云辉
 * @date
 */
@RunWith(SpringJUnit4ClassRunner.class)/
@ContextConfiguration(locations = "classpath:applicationContext.xml")/*加载IOC容器*/
public class MpText {
    @Autowired
    private EmplyoeeMapper emplyoeeMapper;
    /*新增*/
    @Test
    public void TestInsert(){
        Employee employee =new Employee();
        employee.setLastName("农业大学");
        employee.setAge(3);
        employee.setEmail("15151@.com");
        employee.setGender(1);
        Integer result = emplyoeeMapper.insert(employee);
        System.out.println("result = " + result);
    }



    /*更新 根据id修改*/
    @Test
    public void TestUpdateId(){
        Employee employee = new Employee();
        employee.setLastName("截单时间");
        employee.setAge(1);
        employee.setEmail("dadg@163.com");
        employee.setGender(1);
        employee.setId(18);
        Integer result = emplyoeeMapper.updateById(employee);
 /*       Integer result = emplyoeeMapper.updateAllColumnById(employee);*/
        System.out.println("result = " + result);
    }


    @Test
    public  void TestSelect(){


        //分页查询
        List<Employee> employees = emplyoeeMapper.selectPage(new Page<Employee>(2, 2), null);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }
    //删除
    @Test
    public void testDelete(){

        //根据id批量删除
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        Integer byId = emplyoeeMapper.deleteBatchIds(list);
        System.out.println("byId = " + byId);
    }
}
