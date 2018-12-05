package com.kurishev.miniUniversity;

import com.kurishev.miniUniversity.service.GroupServiceFacade;
import com.kurishev.miniUniversity.service.TeacherServiceFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = MiniUniversityApplication.class)
@AutoConfigureMockMvc
public class MiniUniversityApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void addGroupAndCheckAreStudentsTheSame() throws Exception {
		mvc.perform(post("http://localhost:8080/group/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"group\": \"2303\", \"students\": [{\"name\" : \"Alex\", \"age\": \"18\"}, {\"name\": \"Oleg\", \"age\": \"19\"}]}"))
				.andExpect(status().is2xxSuccessful());

		MvcResult result = mvc.perform(post("http://localhost:8080/group/allStudents")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"group\": \"2303\"}"))
				.andExpect(status().is2xxSuccessful()).andReturn();

		String content = result.getResponse().getContentAsString();
		assertTrue(content.equals("[{\"id\":1,\"name\":\"Alex\",\"age\":\"18\"},{\"id\":2,\"name\":\"Oleg\",\"age\":\"19\"}]"));
	}


}
