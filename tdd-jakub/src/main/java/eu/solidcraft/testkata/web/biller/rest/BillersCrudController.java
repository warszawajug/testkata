package eu.solidcraft.testkata.web.biller.rest;

import eu.solidcraft.testkata.domain.Biller;
import eu.solidcraft.testkata.domain.BillerRepository;
import eu.solidcraft.testkata.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Controller
public class BillersCrudController {

    private BillerRepository billerRepository;

    @Autowired
    public BillersCrudController(BillerRepository billerRepository) {
        this.billerRepository = billerRepository;
    }

    @RequestMapping(value = "/billers", method = RequestMethod.GET, produces="application/json")
    public List<Biller> list() {
        return newArrayList(billerRepository.findAll());
    }

    @RequestMapping(value = "/billers", method = RequestMethod.POST, produces="application/json")
    public Biller create(@RequestParam("name") String name) {
        Biller biller = new Biller("some code", name, new ArrayList<Product>());
        return billerRepository.save(biller);
    }
}
