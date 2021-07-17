package pe.com.casatranslima.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.com.casatranslima.model.entity.Application;
import pe.com.casatranslima.model.entity.House;
import pe.com.casatranslima.service.crud.ApplicationService;
import pe.com.casatranslima.service.crud.HouseService;

@Controller
@RequestMapping("/seeApplications")
@SessionAttributes("editApplication")
public class ApplicationListController {
    @Autowired
    private ApplicationService applicationService;

    House houseSpace;

    @Autowired
    private HouseService houseService;

    // LIST APPLICATIONS FOR ADMIN
    @GetMapping
    public String listApplicationsAdmin(Model model, String keyword){
        try {
            List<Application> applications = applicationService.getAll();
            if (keyword != null) {
                model.addAttribute("applications", applicationService.findByKeyword(keyword));
            }
           else{
            model.addAttribute("applications", applications);
           }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "/seeApplications/listApplications";
    }

    // EDIT STATUS OF APPLICATION
    @GetMapping("{id}/editApplication") // GET: /applicationn/{id}/edit
    public String findByID(Model model, @PathVariable("id") Long id) {
        try {
            Optional<Application> optional = applicationService.findById(id);
            if (optional.isPresent()) {
                model.addAttribute("editApplication", optional.get());
                return "seeApplications/editApplication";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "redirect:/seeAplications";
    }

    // SAVE AFTER EDITED
    @PostMapping("save")
    public String saveEdit(Model model, @ModelAttribute("editApplication") Application applicationn) {
        try {
            houseSpace = applicationn.getHouse();
            Application applicationReturn = applicationService.update(applicationn);
            model.addAttribute("applicationn", applicationReturn);
            if(applicationn.getStatus().equals("APPROVED")){
                houseSpace.setSpaces_available(houseSpace.getSpaces_available()-1);
            }
            if(applicationn.getStatus().equals("CANCELLED")){
                // houseSpace = applicationn.getHouse();
                houseSpace.setSpaces_available(houseSpace.getSpaces_available()+1);
            }
            House houseReturn = houseService.update(houseSpace);
            model.addAttribute("house", houseReturn);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "redirect:/seeApplications";
    }

    // Delete Application
    @GetMapping("{id}/deleteApplication")
    public String deleteStudio(@PathVariable("id") Long id) {
        try {
            Optional<Application> optional = applicationService.findById(id);
            if (optional.isPresent()) {
                applicationService.deleteById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "redirect:/seeApplications";
    }

}
