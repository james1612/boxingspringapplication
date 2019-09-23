package com.qa.controllers;

import com.qa.models.Boxer;
import com.qa.repository.BoxerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoxerControllerTest {

        @InjectMocks
        private BoxerController boxerController;

        @Mock
        private BoxerRepository repository;

        @Test
        public void testGetAllBoxers(){
            List<Boxer> boxerList = new ArrayList<>();

            Boxer boxer = new Boxer();
            boxer.setId(100L);
            boxer.setFirstName("Canelo");
            boxer.setLastName("Alvarez");
            boxer.setAge(29);
            boxer.setNationality("Mexico");
            boxerList.add(boxer);

            Boxer boxer2 = new Boxer();
            boxer2.setId(200L);
            boxer2.setFirstName("James");
            boxer2.setLastName("Irish");
            boxer2.setAge(99);
            boxer.setNationality("U.K");
            boxerList.add(boxer2);

            when(repository.findAll()).thenReturn(boxerList);
            assertEquals(
                    boxerController.listAllBoxers().get(0).getFirstName(),
                    "Canelo"
            );
            assertEquals(
                    boxerController.listAllBoxers().get(1).getLastName(),
                    "Irish"
            );
        }

        @Test
        public void addBoxerTest(){
            Boxer boxer = new Boxer();
            boxer.setId(100L);
            boxer.setFirstName("Canelo");
            boxer.setLastName("Alvarez");
            boxer.setAge(29);
            boxer.setNationality("Mexico");

            when(repository.saveAndFlush(boxer)).thenReturn(boxer);

            assertEquals(boxerController.addBoxer(boxer).getAge(), 29);
        }

        @Test
        public void deleteBoxerTest(){
            Boxer boxer = new Boxer(1L, "Canelo", "Alvarez", 29, "Mexico");


            when(repository.findOne(100L)).thenReturn(boxer);

            assertEquals(boxerController.deleteBoxer(100L).getNationality(), "Mexico");
        }






}
