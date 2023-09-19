package com.intuit.tehilasinterview.util;

import java.util.stream.IntStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.intuit.tehilasinterview.models.Player;

public class PlayerMapper {
	private ObjectMapper objectMapper;
	private String[] fieldNames;

	public PlayerMapper(String[] headers) {
		objectMapper = new ObjectMapper();
		this.fieldNames = headers;
	}

	public Player getPlayerFromMapper(String[] playerData) throws JsonMappingException, JsonProcessingException {

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		Player player = objectMapper.readValue(convertArrayToJson(playerData), Player.class);

		return player;
	}

	private String convertArrayToJson(String[] fieldValues) {
		ObjectNode playerJson = objectMapper.createObjectNode();

		IntStream.range(0, Math.min(fieldNames.length, fieldValues.length))
				.forEach(i -> playerJson.put(fieldNames[i], fieldValues[i]));

		String jsonAsString = playerJson.toString();

		return jsonAsString;
	}
}
