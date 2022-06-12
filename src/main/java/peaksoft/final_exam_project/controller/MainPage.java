package peaksoft.final_exam_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainPage {

    @RequestMapping("/")
    public String viewMainPage() {
        return "main_page";
    }
}
