package com.wis1.loanapp.repository;

import com.wis1.loanapp.domain.CalcResult;
import com.wis1.loanapp.domain.Calculate;
import com.wis1.loanapp.domain.Client;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class CalculateRepositoryTest {


    @Autowired
    private CalculateRepository calculateRepository;

    @Autowired
    private ClientRepository clientRepository;
    @Test
    public void addNewCalculate() {

        //Given
        Calculate calculate= new Calculate(5L, 34000,235, new CalcResult());

        //When
        calculateRepository.save(calculate);

        //Then
        assertEquals(1,calculateRepository.findAll().size());

        //CleanUp
        calculateRepository.deleteAll();
    }

    @Test
    public void addNewCalculateWithClient() {

        //Given
        Client client= new Client("Tester", "testing");

        Calculate calculate1= new Calculate(9L,30000,12, new CalcResult());
        Calculate calculate2= new Calculate(10L, 80000, 36, new CalcResult());

        //When
        clientRepository.save(client);
        calculateRepository.save(calculate1);
        calculateRepository.save(calculate2);

        //Then
        List<Calculate> calculateListOfClient= calculateRepository.findAll();
        assertEquals(2, calculateListOfClient.size());

        //Clean up
        clientRepository.deleteAll();
        calculateRepository.deleteAll();
    }

    @Test
    public void getCalculateByClient() {

        //Given
        Client client= new Client("Tester", "testing");

        Calculate calculate1= new Calculate(9L,30000,12, new CalcResult());
        Calculate calculate2= new Calculate(10L, 80000, 36, new CalcResult());

        //When
        clientRepository.save(client);

        calculateRepository.save(calculate1);
        calculateRepository.save(calculate2);

        //Then
        List<Calculate> calculateListOfClient= calculateRepository.findByClient(client);
        assertEquals(2, calculateListOfClient.size());

        //Clean up
        clientRepository.deleteAll();
        calculateRepository.deleteAll();
    }

}
