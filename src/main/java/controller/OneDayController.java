package controller;

import model.OneDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.OneDayService;

import java.util.List;

@Controller
@RequestMapping(value = {"/","one-day"})
public class OneDayController {
    @Autowired
    OneDayService oneDayService;
    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/oneDay");
        List<OneDay> commentRates = oneDayService.findAll();
        modelAndView.addObject("comments", commentRates);
        modelAndView.addObject("commentRate", new OneDay());
        return modelAndView;
    }

    //    @GetMapping("{id}")
//    public ModelAndView showInformation(@PathVariable Long id) {
//        ModelAndView modelAndView = new ModelAndView("customers/info");
//        Customer customer = customerService.findOne(id);
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
//    }
//
    @PostMapping
    public String updateCustomer(OneDay oneDay) {
        oneDayService.save(oneDay);
        return "redirect:/one-day";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id) {
//        commentService.like(id);
//        model.addAttribute("product", productService.selectProduct(id));
//        return "redirect:/comment";

//        ModelAndView modelAndView = new ModelAndView("/index");
        OneDay oneDay = oneDayService.findById(id);
//        modelAndView.addObject("commentRate", commentRate);
        oneDay.setLikeComment(oneDay.getLikeComment()+1);
        oneDayService.save(oneDay);
//        return modelAndView;
        return "redirect:/one-day";
    }
}
