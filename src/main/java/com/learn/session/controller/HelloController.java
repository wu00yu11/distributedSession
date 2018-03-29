package com.learn.session.controller;

import com.learn.session.model.Staff;
import com.learn.session.service.IStaffService;
import org.apache.catalina.LifecycleState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author
 * @describe:
 * @create 2018-03-26 17:19
 **/
@RestController
public class HelloController {
    private static Logger log = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private IStaffService staffService;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(HttpServletRequest request){
        log.info("begin .....................");
        Object o = request.getSession().getAttribute("springboot");
        if(o == null){
            o = "spring boot 牛逼了!!!有端口"+request.getLocalPort()+"生成";
            request.getSession().setAttribute("springboot", o);
        }
        Staff staff = new Staff();
        staff.setId("s011");
        staff.setAge(1800);
        staff.setName("wuyusen111111111111111111111111111111111111111111111111");
        List<Staff> Staffs = staffService.getStaffList(staff);
        for (Staff sf:Staffs) {
          log.info("......................." + sf.toString());
        }
        log.info("end .....................");
        return "端口=" + request.getLocalPort() +  " sessionId=" + request.getSession().getId() +"<br/>"+o;
    }

}
