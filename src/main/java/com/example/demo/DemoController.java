package com.example.demo;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/string")
	public String string() {
		return "string";
	}

	@GetMapping("/list")
	public List<String> list() {
		return List.of("Messi", "Ronaldo", "Neymar");
	}

	@GetMapping("/map")
	public Map<String, Integer> map() {
		return Map.of("messi", 35, "ronaldo", 38, "neymar", 31);
	}

	@GetMapping("/footballer")
	public Footballer footballer() {
		Club psg = new Club("PSG", "League 1");
		Footballer messi = new Footballer("Messi", 35, psg);
		return messi;
	}

	@GetMapping("/footballers")
	public List<Footballer> footballers() {
		Club psg = new Club("PSG", "League 1");
		Club alNassr = new Club("Al Nassr", "Pro League");
		Footballer messi = new Footballer("Messi", 35, psg);
		Footballer ronaldo = new Footballer("Ronaldo", 38, alNassr);
		Footballer neymar = new Footballer("Neymar", 31, psg);
		return List.of(messi, ronaldo, neymar);
	}

	@GetMapping("/getFootballer")
	public Footballer getFootballer(@RequestParam String name) {
		List<Footballer> footballers = new ArrayList<>();
		Footballer footballer = null;
		Club psg = new Club("PSG", "League 1");
		Club alNassr = new Club("Al Nassr", "Pro League");
		Footballer messi = new Footballer("Messi", 35, psg);
		Footballer ronaldo = new Footballer("Ronaldo", 38, alNassr);
		Footballer neymar = new Footballer("Neymar", 31, psg);
		footballers.add(messi);
		footballers.add(ronaldo);
		footballers.add(neymar);
		for (Footballer f : footballers) {
			if (f.name().equals(name)) {
				footballer = f;
			}
		}
		return footballer;
	}

	@GetMapping("/getFootballers")
	public List<Footballer> getFootballers(@RequestParam String clubName) {
		List<Footballer> footballers = new ArrayList<>();
		List<Footballer> response = new ArrayList<>();
		Club psg = new Club("PSG", "League 1");
		Club alNassr = new Club("Al Nassr", "Pro League");
		Footballer messi = new Footballer("Messi", 35, psg);
		Footballer ronaldo = new Footballer("Ronaldo", 38, alNassr);
		Footballer neymar = new Footballer("Neymar", 31, psg);
		footballers.add(messi);
		footballers.add(ronaldo);
		footballers.add(neymar);
		for (Footballer f : footballers) {
			if (f.club().name().equals(clubName)) {
				response.add(f);
			}
		}
		return response;
	}

	@GetMapping("/doesFootballerExist")
	public boolean doesFootballerExist(
		@RequestParam String footballerName,
		@RequestParam int age,
		@RequestParam String clubName,
		@RequestParam String leagueName
	) {
		List<Footballer> footballers = new ArrayList<>();
		Club psg = new Club("PSG", "League 1");
		Club alNassr = new Club("Al Nassr", "Pro League");
		Footballer messi = new Footballer("Messi", 35, psg);
		Footballer ronaldo = new Footballer("Ronaldo", 38, alNassr);
		Footballer neymar = new Footballer("Neymar", 31, psg);
		footballers.add(messi);
		footballers.add(ronaldo);
		footballers.add(neymar);
		for (Footballer f : footballers) {
			if (
				f.name().equals(footballerName) &&
				f.age() == age &&
				f.club().name().equals(clubName) &&
				f.club().league().equals(leagueName)
			) {
				return true;
			}
		}
		return false;
	}

	@GetMapping("/doesFootballerExistImproved")
	public boolean doesFootballerExistImproved(@RequestBody Footballer footballer) {
		List<Footballer> footballers = new ArrayList<>();
		Club psg = new Club("PSG", "League 1");
		Club alNassr = new Club("Al Nassr", "Pro League");
		Footballer messi = new Footballer("Messi", 35, psg);
		Footballer ronaldo = new Footballer("Ronaldo", 38, alNassr);
		Footballer neymar = new Footballer("Neymar", 31, psg);
		footballers.add(messi);
		footballers.add(ronaldo);
		footballers.add(neymar);
		for (Footballer f : footballers) {
			if (
				footballer.name().equals(f.name()) &&
				footballer.age() == f.age() &&
				footballer.club().name().equals(f.club().name()) &&
				footballer.club().league().equals(f.club().league())
			) {
				return true;
			}
		}
		return false;
	}
}
