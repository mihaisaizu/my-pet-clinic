package com.mihaisaizu.mypetclinic.controllers;

import com.mihaisaizu.mypetclinic.model.Owner;
import com.mihaisaizu.mypetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping({"/owners", "/owners.html"})
@Controller
public class OwnerController {

    private final OwnerService ownerService;
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){
        if (owner.getLastName() == null){
            owner.setLastName("");
        }
        List<Owner> results = ownerService.findAllByLastNameLike(owner.getLastName());
        if (results.isEmpty()){
            //no owners with given lastName found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size()== 1){
            //just 1 owner found
            owner=results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            //mode than one owner found
            model.addAttribute("owners", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerID) {
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(ownerService.findById(ownerID));
        return modelAndView;
    }
}
