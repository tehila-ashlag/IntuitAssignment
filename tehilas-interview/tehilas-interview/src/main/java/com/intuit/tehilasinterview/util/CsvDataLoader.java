package com.intuit.tehilasinterview.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.intuit.tehilasinterview.models.Player;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CsvDataLoader {
	private static CsvDataLoader instance;
	private Map<String, Player> playersCache;
	private PlayerMapper playerMapper;
	private boolean isAllPlayersTransformedSuccessfully;

	public boolean isAllPlayersTransformedSuccessfully() {
		return isAllPlayersTransformedSuccessfully;
	}

	private CsvDataLoader() {
		loadPlayerDataFromCsv();
	}

	public static CsvDataLoader getInstance() {
		if (instance == null) {
			synchronized (CsvDataLoader.class) {
				if (instance == null) {
					instance = new CsvDataLoader();
				}
			}
		}
		return instance;
	}

	public void loadPlayerDataFromCsv() {

		String csvFilePath = "./src/main/resources/player.csv";

		try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {

			List<String[]> rows = reader.readAll();

			String[] headers = rows.get(0);

			playerMapper = new PlayerMapper(headers);

			List<String[]> rowsWithOutHeaders = rows.subList(1, rows.size());

			isAllPlayersTransformedSuccessfully = true;
			playersCache = new HashMap<>();
			rowsWithOutHeaders.forEach((row) -> {
				if (!addRowToPlayersCache(row)) {
					isAllPlayersTransformedSuccessfully = false;
				}
			});

		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}
	}

	private boolean addRowToPlayersCache(String[] row) {
		boolean isPlayerAddedSuccessfully = false;

		Player playerToCache = null;
		try {
			playerToCache = playerMapper.getPlayerFromMapper(row);
		} catch (JsonMappingException e) { // TODO consider behavior in case transformation fails
			e.printStackTrace();
			isPlayerAddedSuccessfully = false;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			isPlayerAddedSuccessfully = false;
		}

		if (playerToCache != null) {

			playersCache.put(row[0], playerToCache);
		}

		return isPlayerAddedSuccessfully;

	}

	public Player getPlayerById(String playerId) {
		return playersCache.get(playerId);
	}

	public List<Player> getAllPlayers() {
		return playersCache.values().stream().collect(Collectors.toList());
	}

}
