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

import pe.com.casatranslima.model.entity.Application;
import pe.com.casatranslima.model.entity.House;
import pe.com.casatranslima.service.crud.ApplicationService;
import pe.com.casatranslima.service.crud.HouseService;

@Controller
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private HouseService houseService;

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public String listHouses(Model model){
        try {
            List<House> houses = houseService.getAll();
            model.addAttribute("houses", houses);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "applications/listAllHouses";
    }

    // Create an applicationn 
    @GetMapping("new/{id}")
    public String newApplication(Model model, @PathVariable("id") Long id){
        try {
            Optional<House> optional = houseService.findById(id);
            if(optional.isPresent()){
                Application applicationn = new Application();
                model.addAttribute("applicationNew", applicationn);
                return "applications/newApplication";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
			System.err.println(e.getMessage());
        }
        return "redirect:/applications";
    }

    // Save Application
    @PostMapping("savenew")
	public String saveNew(Model model, @ModelAttribute("applicationNew") Application applicationn) {
		try {
			// reservation.setPrice(studioaux);
			Application applicationReturn = applicationService.create(applicationn);
			model.addAttribute("applicationn", applicationReturn);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/applications";
	}
}
