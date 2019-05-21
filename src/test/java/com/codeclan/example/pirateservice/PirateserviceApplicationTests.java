package com.codeclan.example.pirateservice;

import com.codeclan.example.pirateservice.models.Pirate;
import com.codeclan.example.pirateservice.models.Raid;
import com.codeclan.example.pirateservice.models.Ship;
import com.codeclan.example.pirateservice.repositories.PirateRepository;
import com.codeclan.example.pirateservice.repositories.RaidRepository;
import com.codeclan.example.pirateservice.repositories.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createPirate(){
		Ship daveyJones = new Ship("The Davey Jones");
		shipRepository.save(daveyJones);

		Pirate jack = new Pirate("Jack", "Sparrow", 32, daveyJones);
		pirateRepository.save(jack);

		Raid bloodBath = new Raid("Vienna", 20000);

		jack.addRaid(bloodBath);
		raidRepository.save(bloodBath);
	}

	@Test
	public void createShip(){
		Ship daveyJones = new Ship("The Davey Jones");
		shipRepository.save(daveyJones);
	}

	@Test
	public void createRaid(){
		Raid bloodBath = new Raid("Vienna", 20000);
		raidRepository.save(bloodBath);
	}
}
