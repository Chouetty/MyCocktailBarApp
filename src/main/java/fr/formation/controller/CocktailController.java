package fr.formation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		@RequestMapping(value = "/add", method = RequestMethod.POST) 
		public String newCocktail(final HttpServletRequest request) {
			final String name = request.getParameter("name");
			final Integer price = Integer.parseInt(request.getParameter("price"));
			final Integer withAlcohol = Integer.parseInt(request.getParameter("withAlcohol"));
			this.service.create(new Cocktail(name, price, withAlcohol));
			return "redirect:/cocktails/add.html";
		}
		
		@RequestMapping
		public ModelAndView list() {
			final ModelAndView mav = new ModelAndView();
			mav.setViewName("cocktails");
			mav.addObject("cocktails", this.service.getAll());
			return mav;
		}
		
	}

