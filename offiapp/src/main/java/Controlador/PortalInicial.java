/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pulaf
 */
@Controller
@RequestMapping("/")
public class PortalInicial {
    @GetMapping("/")
    public String inicio(){
        return;
    }
            
}
