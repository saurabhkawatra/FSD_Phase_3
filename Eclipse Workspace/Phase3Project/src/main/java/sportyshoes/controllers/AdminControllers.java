package sportyshoes.controllers;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sportyshoes.MODELS.Product;
import sportyshoes.MODELS.User;
import sportyshoes.SERVICE.ProductSERVICE;
import sportyshoes.SERVICE.UserSERVICE;

@Controller
@RequestMapping(path = {"/admin"})
public class AdminControllers {
	
	@Autowired
	private UserSERVICE userService;
	@Autowired
	private ProductSERVICE productService;

	
	@RequestMapping(path = {"/admin-home"},method = {RequestMethod.GET})
	public String admin_home(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		System.out.println("executing /admin-home via admin_home method");
		model.addAttribute("productlist", productService.getallProductlist());
		Enumeration<String> allusers = request.getSession(false).getAttributeNames();
		while(allusers.hasMoreElements())
			System.out.println("Session Attribute :: "+allusers.nextElement());
		return "admin_home";
	}
	
	
	
	@RequestMapping(path = {"/addproduct"},method = {RequestMethod.POST},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String addproduct(HttpServletRequest request,HttpServletResponse response,@RequestParam(required = false,name = "imagefile") MultipartFile imgfile,@ModelAttribute Product newprod)
	{
		System.out.println("executing add product method");
		System.out.println("Details received from Form : "+newprod);
		String msg=productService.addProduct(newprod);
		System.out.println("msg :: "+msg);
		if(imgfile.getOriginalFilename().isEmpty())
		{
			System.out.println("if condition isEmpty executed === No Image Uploaded === Setting Default image");
			
			String genfilename="default-product-image.jpg";
			System.out.println("Generated image name :: "+genfilename);
			newprod.setProduct_image_name(genfilename);
			newprod.setProduct_image_type("image/jpeg");
			String msg2=productService.updateProduct(newprod.getProduct_id(), newprod);
			System.out.println(msg2);
		}
		else {
			
			System.out.println("ContentType :: "+imgfile.getContentType());
			System.out.println("Uploading File --> "+imgfile.getOriginalFilename());
			
			File infile=new File(request.getRealPath("")+"Resources\\uploads\\"+String.valueOf(newprod.getProduct_id())+"_"+imgfile.getOriginalFilename());
			
			try {
				System.out.println(request.getRealPath("")+"Resources\\uploads\\"+String.valueOf(newprod.getProduct_id())+"_"+imgfile.getOriginalFilename());
				if(infile.exists())
				{
					System.out.println("A file already exists with same name, and that file is going to be replaced");
				}
				infile.createNewFile();
				imgfile.transferTo(infile);
				System.out.println("File was uploaded successfully");
				
				String genfilename=String.valueOf(newprod.getProduct_id())+"_"+imgfile.getOriginalFilename();
				System.out.println("Generated image name :: "+genfilename);
				newprod.setProduct_image_name(genfilename);
				newprod.setProduct_image_type(imgfile.getContentType());
				String msg2=productService.updateProduct(newprod.getProduct_id(), newprod);
				System.out.println(msg2);
			}catch(Exception e)
			{
				System.out.println("File Exception");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		
		return "";
	}
	
	
	
}
