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

import pe.com.casatranslima.model.entity.House;
import pe.com.casatranslima.service.crud.HouseService;

@Controller
@RequestMapping("/houses")
@SessionAttributes("houseEdit")
public class HouseController {

    @Autowired
    private HouseService houseService;

    // LIST HOUSES
    @GetMapping
    public String list(Model model, String keyword) {
        try {
            List<House> houses = houseService.getAll();
            if (keyword != null) {
                model.addAttribute("houses", houseService.findByKeyword(keyword));
            }
            else{
                model.addAttribute("houses", houses);
            } 
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "houses/listHouse";
    }

    @GetMapping("new")
    public String newItem(Model model) {
        try {
            House house = new House();
            model.addAttribute("houseNew", house);
            return "houses/newHouse";
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return "redirect:/houses";
    }

    // SAVE NEW HOUSE
    @PostMapping("savenew")
    public String saveNew(Model model, @ModelAttribute("houseNew") House house) {
        try {
            House houseReturn = houseService.create(house);
            model.addAttribute("house", houseReturn);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "redirect:/houses";
    }

    // EDIT HOUSES
    @GetMapping("{id}/editHouse") // GET: /houses/{id}/edit
    public String findByID(Model model, @PathVariable("id") Long id) {
        try {
            Optional<House> optional = houseService.findById(id);
            if (optional.isPresent()) {
                model.addAttribute("houseEdit", optional.get());
                return "houses/editHouse";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "redirect:/houses";
    }

    // SAVE AFTER EDITED
    @PostMapping("save")
    public String saveEdit(Model model, @ModelAttribute("houseEdit") House house) {
        try {
            House houseReturn = houseService.update(house);
            model.addAttribute("house", houseReturn);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "redirect:/houses";
    }

    @GetMapping("{id}/deleteHouse")
    public String deleteStudio(@PathVariable("id") Long id) {
        try {
            Optional<House> optional = houseService.findById(id);
            if (optional.isPresent()) {
                houseService.deleteById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "redirect:/houses";
    }

}
