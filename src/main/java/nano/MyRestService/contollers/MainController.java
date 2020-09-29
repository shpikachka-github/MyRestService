package nano.MyRestService.contollers;


import nano.MyRestService.dao.StudentAccountDAO;
import nano.MyRestService.model.StudentAccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private StudentAccountDAO studentAccountDAO;

    @RequestMapping("/")
    @ResponseBody
    public String showStudentAccounts(Model model) {
        List<StudentAccountInfo> list = studentAccountDAO.getStudentAccount();

        model.addAttribute("accountInfos", list);

        return "accountsPage";
    }
}
