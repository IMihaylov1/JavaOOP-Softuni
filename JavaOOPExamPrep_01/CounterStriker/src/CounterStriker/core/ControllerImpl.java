package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.*;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;

public class ControllerImpl implements Controller {
    private final GunRepository guns;
    private final PlayerRepository players;
    private  final Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        switch (type) {
            case "Pistol":
                this.guns.add(new Pistol(name, bulletsCount));
                break;

            case "Rifle":
                this.guns.add(new Rifle(name, bulletsCount));
                break;

            default:
                return INVALID_GUN_TYPE;
        }
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {

        if (this.guns.findByName(gunName) == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }
        Gun gun = this.guns.findByName(gunName);
        switch (type) {
            case "Terrorist":
                this.players.add(new Terrorist(username, health, armor, gun));
                break;
            case "CounterTerrorist":
                this.players.add(new CounterTerrorist(username, health, armor, gun));
                break;
            default:
              throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return this.field.start(this.players.getModels());
    }

    @Override
    public String report() {
        List<Player> ct = this.players.getModels()
                .stream()
                .filter(p->p instanceof CounterTerrorist)
                .collect(Collectors.toCollection(ArrayList::new));

        List<Player> t = this.players.getModels()
                .stream().filter(p->p instanceof Terrorist)
                .collect(Collectors.toCollection(ArrayList::new));

        ct = ct.stream()
                .sorted(Comparator
                .comparingInt(Player::getHealth)
                .reversed()
                .thenComparing(Player::getUsername))
                .collect(Collectors.toCollection(ArrayList::new));

        t = t.stream()
                .sorted(Comparator
                        .comparingInt(Player::getHealth)
                        .reversed()
                .thenComparing(Player::getUsername))
                .collect(Collectors.toCollection(ArrayList::new));
        StringBuilder sb = new StringBuilder();

        for (Player counterTerrorist : ct) {
            sb.append(counterTerrorist).append(System.lineSeparator());
        }
        for (Player terrorist : t) {
            sb.append(terrorist).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
