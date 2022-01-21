package Challenge.Challenge.Controllers;

import Challenge.Challenge.DAO.RecipieRepository; 
import Challenge.Challenge.entity.Recipie;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import Challenge.Challenge.Services.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;

@RestController
public class HomeController {

	@Autowired
	FetchingData fd;
	@Autowired
	RecipieRepository recipieRepository;

	public ResponseEntity<Recipie[]> res;

	@GetMapping("/")
	public void getEverything() throws IOException {
		Recipie[] r = fd.getData().getBody();
		for (int i = 0; i < r.length; i++) {
			recipieRepository.save(new Recipie(r[i].getId(), r[i].getName(), r[i].getImage(), r[i].getCategory(),
					r[i].getLabel(), r[i].getPrice(), r[i].getDescription()));
		}
	}

	@GetMapping("/{recipieId}")
	public Recipie getRecipie(@PathVariable("recipieId") int recipieId) {
		return recipieRepository.getById(recipieId);
	}

	@PostMapping("/")
	public Recipie saveRecipie(@RequestBody Recipie res) {
		System.out.println(res);
		recipieRepository.save(res);
		return res;
	}

	@GetMapping("/{recipieId}/show")
	@ResponseBody
	public ResponseEntity<byte[]>  showRecipie(@PathVariable("recipieId") int recipieId)throws IOException {
		System.out.print("inside");
		Recipie r = recipieRepository.getById(recipieId);
		String url = r.getImage();
		System.out.println("Image URL: "+url);
		URL url2 = new URL(url);//Fetching image from web
	    InputStream is = url2.openStream();
		byte[] str = is.readAllBytes();
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(str);
	}
}
