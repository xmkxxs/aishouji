package com.xm.controller;

import com.xm.bean.User;
import com.xm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Ming
 * @create 2020-08-13 11:36
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //用户登录
    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(User user, HttpSession session, Model model){
        //判断用户账户密码是否在数据库中存在以及匹配
        String userName=user.getUserName();
        System.out.println(userName);
        String password=user.getPassword();
        System.out.println(password);
        User userDate=userService.login(userName,password);
        if(userDate==null){
            System.out.println("用户数据查不到，账户或密码有误");
            model.addAttribute("loginInfo","failed");
            return "0";//如果账户密码错误，给用户提示
        }else {
            System.out.println("账户密码无误");
            session.setAttribute("user", user);
            model.addAttribute("loginInfo","success");
            return userName;//如果用户密码正确，alert欢迎XXX，在ajax的success中跳转到index
        }
    }

    //注册时检测用户名是否存在
    //@RequestParam接收ajax中date中与此方法的value名相同的请求参数的值
    @RequestMapping(value = "/existUserName",method = RequestMethod.GET)
    @ResponseBody
    public String existUserName(@RequestParam(value="userName")String userName){
        //调用查询用户名是否在数据库存在的方法，返回行数，查到了就是>1,查不到就是0
        Integer result=userService.existUserName(userName);
        if(result==0){
            return "userNameCanBeUsed";
        }else {
            return "userNameCanNotBeUsed";
        }
    }

    //注册时检测邮箱是否存在
    @RequestMapping(value = "/existEmail",method = RequestMethod.GET)
    @ResponseBody
    public String existEmail(@RequestParam(value="email")String email){
        //调用查询邮箱是否在数据库存在的方法，返回行数，查到了就是>1,查不到就是0
        Integer result=userService.existEmail(email);
        if(result==0){
            return "emailCanBeUsed";
        }else {
            return "emailCanNotBeUsed";
        }
    }

    //用户注册，录入用户名密码邮箱
    @RequestMapping(value = "/registeredUserInformationEnter",method = RequestMethod.POST)
    @ResponseBody
    public String registeredUserInformationEnter(User user){
        //开始数据插入
        userService.registeredUserInformationEnter(user.getUserName(),user.getPassword(),user.getEmail());
        //插入后，调用查询此用户方法，判断是否插入成功，插入成功就可以查询到此用户
        Integer result=userService.existUserName(user.getUserName());
        System.out.println(result+"this is result");
        if(result==1){
            return "insertSuccess";
        }else {
            return "insertIsNotSuccess";
        }
    }

    //用户找回密码，服务器判断用户名和邮箱是否匹配
    @RequestMapping(value = "/passwordReset",method = RequestMethod.POST)
    @ResponseBody
    public String passwordReset(User result){
        //获取用户名
        String userName=result.getUserName();
        //获取密码，由于表单两个密码input的name用了相同的名字，serialize封装后接收到的密码格式是：
        //新密码，确认新密码    也就是获取的两个密码中间用，分开
        //截取字符串获取逗号前的值或逗号后的值任意即可，因为已经判断过两个密码一定是相同的才能提交到服务器
        String password=result.getPassword().substring(0, result.getPassword().indexOf(","));
        //获取邮箱
        String email=result.getEmail();
        //首先判断用户是否存在
        Integer existUserName=userService.existUserName(userName);
        if(existUserName==1){//用户存在,搜索到此用户一条记录
            //判断用户名和邮箱是否匹配，通过用户名查询此用户信息
            User user=userService.passwordReset(userName);
            String rightEmail=user.getEmail();
            String oldPassword=user.getPassword();//获取旧密码，用于判断更新密码是否成功
            if(rightEmail.equals(email)){
                System.out.println("用户输入邮箱与数据库一致");
                //更新密码根据用户名
                userService.updatePassword(password,userName);
                //再次查询数据库此时的密码,与旧密码对比，不一样就是更新成功
                User userInfo=userService.passwordReset(userName);
                String newPassword=userInfo.getPassword();
                if(oldPassword.equals(newPassword)){
                    System.out.println("更新失败,此密码可能是您之前使用的密码或是系统其他错误，请尝试更换密码或继续使用此密码！");
                    return "failed";
                }else {
                    System.out.println("重制成功，为您跳转到登录页面");
                    return "success";
                }
            }else {
                System.out.println("邮箱不一致");
                return "different";
            }
        }else {
            System.out.println("用户不存在！");
            return "noexistent";
        }
    }

    //用户退出，销毁session用户信息
    @RequestMapping(value = "/userLogout",method = RequestMethod.POST)
    public String userLogout(HttpSession session){
        session.invalidate();
        return "index";
    }

}
