package CounterStriker.models.guns;

public class Pistol extends GunImpl {

    private static final int PISTOL_BULLETS = 1;

    public Pistol(String name, int bulletCount) {

        super(name, bulletCount);
    }


    @Override
    public int fire() {
        if (super.getBulletsCount() >= PISTOL_BULLETS) {
            int result = super.getBulletsCount() - PISTOL_BULLETS;
            super.setBulletsCount(Math.max(result, 0));
            return PISTOL_BULLETS;
        }

        return 0;
    }
}
