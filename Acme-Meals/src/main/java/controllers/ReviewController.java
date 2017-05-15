
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.RelationLikeService;
import services.ReviewService;
import services.UserService;
import domain.RelationLike;
import domain.Review;
import domain.User;

@Controller
@RequestMapping("/review")
public class ReviewController extends AbstractController {

	// Services ------------------------------------------------

	@Autowired
	private ReviewService	reviewService;

	@Autowired
	private UserService		userService;

	@Autowired
	private RelationLikeService		relationLikeService;

	
	// Constructors -----------------------------------------------------------

	public ReviewController() {
		super();
	}

	// Browse ---------------------------------------------------------------		

	@RequestMapping(value = "/browse", method = RequestMethod.GET)
	public ModelAndView browse() {
		ModelAndView result;

		Collection<Review> reviews = reviewService.findAll();

		result = new ModelAndView("review/browse");
		result.addObject("reviews", reviews);
		result.addObject("requestURI", "review/browse.do");

		return result;
	}

	// Display ----------------------------------

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView display(@RequestParam int reviewId) {
		ModelAndView result;
		Review review;

		review = reviewService.findOne(reviewId);

		result = new ModelAndView("review/display");
		result.addObject("review", review);
		result.addObject("requestURI", "review/display.do");
		
		return result;
	}

}
