package com.jphat.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jphat.models.Owner;
import com.jphat.services.OwnerService;

@Controller
public class OwnerController {

	private Logger log = LoggerFactory.getLogger(OwnerController.class);
	
	@Autowired
	private OwnerService ownerService;
	
	@RequestMapping( value="/owner/add", method = RequestMethod.GET )
	public String addOwner() {
		log.error( "OwnerController: Passing through" );
		return "/owner/add";
	}
	
	@RequestMapping( value="/owner/find", method = RequestMethod.GET  )
	public String findOwner() {
		return "/owner/find";
	}
	
	@RequestMapping( value="/owner/view" )
	public String viewOwner( @ModelAttribute("owner") Owner owner, BindingResult result, Model model ) {
		model.addAttribute( "owner", owner );
		model.addAttribute( owner );
		return "/owner/viewPage";
	}

	@RequestMapping( value="/owner/save", method = RequestMethod.POST )
	public String save( @ModelAttribute("owner") Owner owner, BindingResult result, Model model ) {
		ownerService.addOwner( owner );
		model.addAttribute(owner);
		return "/owner/viewPage";
	}
}
