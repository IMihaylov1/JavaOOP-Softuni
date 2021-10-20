package CounterStriker.models.field;

import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {


    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorist = players.stream().filter(p -> p instanceof Terrorist).collect(Collectors.toList());
        List<Player> counterTerrorist = players.stream().filter(p -> p instanceof CounterTerrorist).collect(Collectors.toList());


        while (terrorist.stream().allMatch(Player::isAlive)
                && counterTerrorist.stream().allMatch(Player::isAlive)) {

            for (Player t : terrorist) {
                for (Player ct : counterTerrorist) {
                    ct.takeDamage(t.getGun().fire());
                }
            }
            counterTerrorist = counterTerrorist.stream().filter(Player::isAlive).collect(Collectors.toList());
            if (counterTerrorist.isEmpty()) {
                return TERRORIST_WINS;
            }

            for (Player ct : counterTerrorist) {
                for (Player t : terrorist) {
                    t.takeDamage(ct.getGun().fire());
                }
            }
            terrorist = terrorist.stream().filter(Player::isAlive).collect(Collectors.toList());
            if (terrorist.isEmpty()) {
                return COUNTER_TERRORIST_WINS;
            }
        }
        return "";
    }

}
