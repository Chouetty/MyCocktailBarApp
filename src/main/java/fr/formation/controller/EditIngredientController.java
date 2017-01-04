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
import org.springframework.web.servlet.ModelAndView;

import fr.formation.entity.Ingredient;
import fr.formation.service.IngredientService;

@Controller
@RequestMapping("/ingredient")
public class EditIngredientController {

	private boolean error;

	private Integer ingredientId;

	private List<Ingredient> ingredients;

	@Autowired
	private IngredientService ingredientService;

	@PostConstruct
	public void _init() {
		this.ingredients = new ArrayList<>();
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable final Integer id) {
		if (this.ingredientId != null && !this.ingredientId.equals(id)) {
			this.ingredients = new ArrayList<>();
		}
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("editIngredient");
		if (this.error) {
			this.error = false;
		} else {
			final Ingredient ingredient = this.ingredientService.get(id);
			mav.addObject("ingredient", ingredient);
			this.ingredientId = ingredient.getId();
		}
		return mav;
	}

	private String getForward() {
		return "forward:/ingredient/edit/" + this.ingredientId + ".html";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute @Valid final Ingredient ingredient, final BindingResult result) {
		if (result.hasErrors()) {
			this.error = true;
		} else {
			this.ingredientService.update(ingredient);
		}
		return this.getForward();
	}
}
