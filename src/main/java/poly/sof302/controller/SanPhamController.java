package poly.sof302.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import poly.sof302.entities.Sanpham;
import poly.sof302.service.ISanPhamService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class SanPhamController {
    @Autowired
    ISanPhamService spService;

    @GetMapping(value = {"", "/", "/index"})
    public String indexPage(ModelMap model){
        List<Sanpham> listSP = spService.findAll();
        model.addAttribute("listSP", listSP);
        model.addAttribute("sp", new Sanpham());
        double tongTien = 0;
        double tongTienMax = 0;
        Sanpham spMax = new Sanpham();

        for (Sanpham sp : listSP){
            Date date = new Date();
            if(sp.getNgaymua().getDate() == date.getDate()){
                tongTien = sp.getSoluong()*sp.getDongia();
                if(tongTien > tongTienMax){
                    spMax = sp;
                }
            }
        }
        model.addAttribute("spMax", spMax);
        return "index";
    }

    @PostMapping("/add")
    public String themSanPham(@ModelAttribute Sanpham sp) throws ParseException {
        sp.setNgaymua(new Date());
        spService.saveOrUpdate(sp);
        return "redirect:/index";
    }
}
