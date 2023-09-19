package com.intuit.tehilasinterview.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.tehilasinterview.models.Player;
import com.intuit.tehilasinterview.util.CsvDataLoader;

@RestController
@RequestMapping("/api")
public class PlayersController {

	@GetMapping("/players")
	public ResponseEntity<List<Player>> getAllPlayers() {
		CsvDataLoader dataLoader = CsvDataLoader.getInstance();
		List<Player> players;

		try {
			players = dataLoader.getAllPlayers();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		if (players.isEmpty()) {
			if (!dataLoader.isAllPlayersTransformedSuccessfully()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.ok(players);
	}

	@GetMapping("/players/{playerId}")
	public ResponseEntity<Player> getPlayerById(@PathVariable String playerId) {
		CsvDataLoader dataLoader = CsvDataLoader.getInstance();
		Player player = dataLoader.getPlayerById(playerId);

		if (player != null) {
			return ResponseEntity.ok(player);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			// TODO consider sending msg "Player with ID " + playerId + " not found"
		}
	}

}