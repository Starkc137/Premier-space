package com.ucl.premier_space.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.Normalizer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersFromTeam(String teamName) {
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam_name()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String searchText) {
        String normalizedSearch = normalize(searchText);

        return playerRepository.findAll().stream()
                .filter(player -> {
                    String normalizedName = normalize(player.getName());
                    return normalizedName.contains(normalizedSearch);
                })
                .collect(Collectors.toList());
    }

    private String normalize(String input) {
        if (input == null) return "";
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toLowerCase();
    }

    public List<Player> getPlayersbyPosition(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPosition().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByNation(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getNation().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeamAndPosition(String team, String position) {
        return playerRepository.findAll().stream()
                .filter(player -> team.equals(player.getTeam_name()) && position.equals(player.getPosition()))
                .collect(Collectors.toList());

    }

    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setTeam_name(updatedPlayer.getTeam_name());
            playerToUpdate.setPosition(updatedPlayer.getPosition());
            playerToUpdate.setNation(updatedPlayer.getNation());

            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    @Transactional
    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }
}
