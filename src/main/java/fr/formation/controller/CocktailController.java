package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.entity.Cocktail;
import fr.formation.service.CocktailService;

@Controller
@RequestMapping("/cocktails")
public class CocktailController {

	@Autowired
	private CocktailService service;

	@RequestMapping("/add")
	public ModelAndView add() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("addCocktails");
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable final Integer id) {
		this.service.delete(id);
		return "redirect:/cocktails.html";
	}

	@RequestMapping
	public ModelAndView List() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("cocktails");
		mav.addObject("cocktails", this.service.getAll());
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String newIngredient2(@RequestParam final String name, @RequestParam final Integer price,
			@RequestParam final Integer withAlcohol) {
		final Cocktail cocktail = new Cocktail();
		cocktail.setName(name);
		System.out.println("Cocktail name : " + name);
		cocktail.setPrice(price);
		cocktail.setWithAlcohol(withAlcohol);
		this.service.create(cocktail);
		return "redirect:/cocktails/add.html";
	}

}
