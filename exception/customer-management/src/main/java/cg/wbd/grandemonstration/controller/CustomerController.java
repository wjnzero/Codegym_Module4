package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.exception.DuplicateEmailException;
import cg.wbd.grandemonstration.model.Counter;
import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.model.Province;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("customers")
@SessionAttributes("counter")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> allProvinces() {
        return provinceService.findAll();
    }

    @ModelAttribute("counter")
    public Counter setUp(){
        return new Counter();
    }

    @GetMapping
    public ModelAndView showList(Optional<String> s, Pageable pageInfo, @ModelAttribute("counter") Counter counter) {
        ModelAndView modelAndView = new ModelAndView("/customers/list");
        Page<Customer> customers = s.isPresent() ? search(s, pageInfo) : getPage(pageInfo);
        modelAndView.addObject("keyword", s.orElse(null));
        modelAndView.addObject("customers", customers);
        counter.increment();
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        try {
            ModelAndView modelAndView = new ModelAndView("/customers/info");
            Optional<Customer> customerOptional = customerService.findOne(id);
            modelAndView.addObject("customer", customerOptional.get());
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:/customers");
        }
    }

    @PostMapping
    public ModelAndView updateCustomer(Customer customer) throws DuplicateEmailException {
//        try {
//            customerService.save(customer);
//            return new ModelAndView("redirect:/customers");
//        } catch (DuplicateEmailException e) {
//            return new ModelAndView("/customers/err");
//        }
        customerService.save(customer);
        return new ModelAndView("redirect:/customers");
    }

    private Page<Customer> getPage(Pageable pageInfo) {
        try {
            return customerService.findAll(pageInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Page<Customer> search(Optional<String> s, Pageable pageInfo) {
        return customerService.search(s.get(), pageInfo);
    }
//    @ExceptionHandler(DuplicateEmailException.class)
//    public ModelAndView showInputNotAcceptable() {
//        return new ModelAndView("/customers/err");
//    }

}
