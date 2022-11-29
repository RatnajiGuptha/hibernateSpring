package com.guptha.springdata.filedata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.guptha.springdata.filedata.entities.Image;
import com.guptha.springdata.filedata.repos.ImagesRepository;

@SpringBootTest
class FiledataApplicationTests {

	@Autowired
	ImagesRepository repo;

	@Test
	void contextLoads() {
	}

	@Test
	void testImageSave() throws IOException {
		Image img = new Image();
		img.setId(1L);
		img.setName("Ganesh.jpg");

		File file = new File("C://Users//talluri_guptha//Downloads/images.jfif");
		byte fileContent[] = new byte[(int) (file.length())];
		FileInputStream inputstream = new FileInputStream(file);
		inputstream.read(fileContent);

		img.setData(fileContent);
		repo.save(img);
		inputstream.close();
	}

	@Test
	void testReadImage() {
		Image img = repo.findById(1L).get();
		File file = new File("C://Users//talluri_guptha//Downloads/" + img.getName());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			try {
				fos.write(img.getData());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
