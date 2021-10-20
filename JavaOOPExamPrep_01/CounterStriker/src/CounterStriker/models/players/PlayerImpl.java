package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;


import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
        this.isAlive = true;
    }


    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    private void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    @Override
    public void takeDamage(int points) {
        if (this.getArmor() - points < 0) {
            setArmor(0);
            this.setHealth(this.getHealth() - points);

            if (this.getHealth() < 0) {
                this.setAlive(false);
            }
        } else {
            this.setArmor(this.getArmor() - points);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s", this.getClass().getSimpleName()
                , this.getUsername()))
                .append(System.lineSeparator());
        sb.append(String.format("--Health: %d", this.getHealth())).append(System.lineSeparator());
        sb.append(String.format("--Armor: %d", this.getArmor())).append(System.lineSeparator());
        sb.append(String.format("--Gun: %s", this.getGun().getName()));

        return sb.toString().trim();
    }

}
