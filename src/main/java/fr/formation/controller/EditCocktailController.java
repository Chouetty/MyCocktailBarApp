package fr.formation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.entity.Cocktail;
import fr.formation.entity.IngredientCocktail;
import fr.formation.service.CocktailService;
import fr.formation.service.IngredientService;

@Controller
@RequestMapping("/cocktail")
public class EditCocktailController {

	private Integer cocktailId;

	@Autowired
	private CocktailService cocktailService;

	private boolean error;

	private List<IngredientCocktail> ingredientCocktails;

	@Autowired
	private IngredientService ingredientService;

	@PostConstruct
	public void _init() {
		this.ingredientCocktails = new ArrayList<>();

	}

	@RequestMapping("/addIngredient")
	public String addIngredient(@RequestParam final Integer ingredientId) {
		final IngredientCocktail ingredientCocktail = new IngredientCocktail();
		ingredientCocktail.setCocktail(this.cocktailService.get(this.cocktailId));
		ingredientCocktail.setIngredient(this.ingredientService.get(ingredientId));
		this.ingredientCocktails.add(ingredientCocktail);
		return this.getForward();
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable final Integer id) {
		if (this.cocktailId != null && !this.cocktailId.equals(id)) {
			this.ingredientCocktails = new ArrayList<>();
		}
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("editCocktail");
		if (this.error) {
			this.error = false;
		} else {
			final Cocktail cocktail = this.cocktailService.get(id);
			mav.addObject("cocktail", cocktail);
			this.cocktailId = cocktail.getId();
		}

		if (this.ingredientCocktails.isEmpty()) {
			this.ingredientCocktails.addAll(this.cocktailService.getIngredientCocktail(this.cocktailId));
		}
		mav.addObject("ingredientCocktails", this.ingredientCocktails);
		mav.addObject("ingredients", this.ingredientService.getAllByCocktail(this.ingredientCocktails));
		return mav;
	}

	private String getForward() {
		return "forward:/cocktail/edit/" + this.cocktailId + ".html";
	}

	@RequestMapping("/removeIngredient")
	public String removeIngredient(@RequestParam final Integer ingredientId) {
		final IngredientCocktail ingredientCocktail = new IngredientCocktail();
		ingredientCocktail.setCocktail(this.cocktailService.get(this.cocktailId));
		ingredientCocktail.setIngredient(this.ingredientService.get(ingredientId));
		this.ingredientCocktails.remove(ingredientCocktail);
		return this.getForward();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute @Valid final Cocktail cocktail, final BindingResult result) {
		if (result.hasErrors()) {
			this.error = true;
		} else {
			this.cocktailService.update(cocktail);
		}
		return this.getForward();
	}
}