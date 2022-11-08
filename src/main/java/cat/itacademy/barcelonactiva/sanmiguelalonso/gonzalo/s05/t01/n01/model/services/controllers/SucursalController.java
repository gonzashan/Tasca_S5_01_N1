package cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.services.controllers;


import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.domain.CountriesModel;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.domain.SucursalModel;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.repository.CountriesRepository;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.repository.SucursalRepository;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Controller
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private SucursalService sucursalService;


    /**  GET
     * @return http://localhost:9000/sucursal/add.html ***/
    @GetMapping("/add")
    public String index(Model model)
    {
        model.addAttribute("sucursal", sucursalService.newSucursalDTO());
        return "add";
    }


    /**  POST ACTION
     * @return "redirect:/sucursal/addSuccess"  ***/
    @PostMapping("/addSuccess")
    public String addSucursal(@ModelAttribute("sucursal") SucursalModel sucursal)
    {
        sucursalRepository.save(sucursal);
        return "redirect:/sucursal/addSuccess/" + sucursal.getNomSucursal();
    }


    /**  GET
     * @return http://localhost:9000/sucursal/addSuccess.html
     * *******************************/
    @GetMapping("/addSuccess/{string}")
    public String indexo( @PathVariable String string, Model model)
    {
        model.addAttribute("nomSucursal", string);
        return "addSuccess";
    }


    /** GET
     * @return http://localhost:9000/sucursal/delete.html  **/
    @GetMapping("/delete")
    public String deleteSucursal(Model model)
    {
        model.addAttribute("sucursales", sucursalService.getAllSucursalDTOS());
        return "delete";
    }


    /**  DELETE
     * @return "redirect:/sucursal/delete" **/
    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable Integer id)
    {
        Optional<SucursalModel> sucursal = sucursalRepository.findById(id);
        try {
            sucursalRepository.deleteById(id);
        } catch (NoSuchElementException e){
            System.out.println("Element not found!");
            return "redirect:/sucursal/error-500/" + e;
        }
        return "redirect:/sucursal/delete";
    }


    /**GET
     * @return http://localhost:9000/sucursal/getAll.html ***/
    @GetMapping("/getAll")
    public String getAllSucursales(Model model)
    {
        model.addAttribute("sucursales", sucursalService.getAllSucursalDTOS());
        return "getAll";
    }


    /*******  GET
     * @return http://localhost:9000/sucursal/getOne.html
     * @exception NoSuchElementException http://localhost:9000/sucursal/error-500.html
     *    ***/
    @GetMapping("/getOne/{id}")
    public String getOneSucursal(@PathVariable Integer id, Model model)
    {
        Optional<SucursalModel> sucursal = sucursalRepository.findById(id);

        try {
            model.addAttribute("sucursal",
                    sucursalService.convertToSucursalDTO(sucursal.get()));
            return "getOne";

        } catch (NoSuchElementException e){
            model.addAttribute("errorDescription", e);
            System.out.println("Element not found!");
            return "error-500";

        } catch (Exception exception){
            exception.printStackTrace();
        }

        return "error-500";
    }


    /**  ERRORS
     * @return http://localhost:9000/sucursal/error-500.html
     * ****/
    @GetMapping("/error-500")
    public String getNoSuchElementException(Model model)
    {
        //System.out.println(model.getAttribute("errorDescription"));
            model.addAttribute("error",
                    model.getAttribute("errorDescription"));
        return "error-500";
    }


    /*******  UPDATE
     * @return http://localhost:9000/sucursal/update.html *******/
    @GetMapping("/update")
    public String updateSucursal(Model model)
    {
        model.addAttribute("sucursales",
                sucursalService.getAllSucursalDTOS());
        return "update";
    }


    /** DELETE ACTION
     * @return http://localhost:9000/sucursal/updaterecord.html
     * @apiNote if null "redirect:/sucursal/getAll" ***/
    @GetMapping("/update/{id}")
    public String updateSucursal(@PathVariable Integer id, Model model)
    {
        Optional<SucursalModel> sucursal = sucursalRepository.findById(id);

        if (sucursal.isPresent()) {
            model.addAttribute("sucursal",
                    sucursalService.updateSucursalDtoById(sucursal.get()));
            System.out.println("Found it!");
            return "updaterecord";
        }
        return "redirect:/sucursal/getAll";
    }


    /*******  POST ACTION
     * @return "redirect:/sucursal/update" ***/
    @PostMapping("/updatedrecord")
    public String updateOkSucursal(@ModelAttribute("sucursal") SucursalModel sucursal)
    {
        sucursalRepository.save(sucursal);
        return "redirect:/sucursal/update";
    }


}



