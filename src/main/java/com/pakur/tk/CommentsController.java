package com.pakur.tk;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pakur.tk.daos.CommentsDao;
import com.pakur.tk.models.WebsiteComments;

@Controller
public class CommentsController {
	
	@Autowired
	private CommentsDao commentsDao;
	
	@RequestMapping(value = "/comments", method = RequestMethod.GET)
	public String redirectToError(){
		return "errors";
	}
	
	@RequestMapping(value = "/comments", method = RequestMethod.POST)
	public String addComments(@ModelAttribute WebsiteComments websiteComments, Model model){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date currentTime = new Date();
		websiteComments.setCreated(df.format(currentTime));
		websiteComments.setModified(df.format(currentTime));
		try {
			commentsDao.addComments(websiteComments);
			model.addAttribute("success", "Thank you for your comments .");
		} catch (Exception e) {
			return "errors";
		}
			
		return "index";
	}
	
	
}
