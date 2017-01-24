package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.entity.Ingredient;
import fr.formation.service.IngredientService;

@Controller
@RequestMapping("/data")
public class DataController {

	@Autowired
	private IngredientService ingredientService;

	@GetMapping(value = "/ingredients", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Ingredient> listIngredients() {
		return this.ingredientService.getAll();

	}
}
