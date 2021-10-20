package halfLife;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PlayerTests {

    @Test(expected = NullPointerException.class)
    public void TestSetUsernameShouldTrowExceptionWithUsernameNull() {
        Player player = new Player(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void TestSetUsernameShouldTrowExceptionWithEmptyName() {
        Player player = new Player(" ", 10);
    }

    @Test
    public void TestSetUsernameShouldWorkProperly() {
        Player player = new Player("Ivo", 10);
    }

    @Test
    public void TestGetUsernameShouldWorkProperly() {
        Player player = new Player("Ivo", 10);
        String actual = player.getUsername();
        assertEquals("Ivo", actual);
    }


    @Test(expected = IllegalArgumentException.class)
    public void TestSetHealthShouldTrowExceptionWithNegativeHealth() {
        Player player = new Player("Ivan", -10);
    }

    @Test
    public void TestSetHealthShouldWorkProperly() {
        Player player = new Player("Ivan", 10);
    }

    @Test
    public void TestGetHealthShouldWorkProperly() {
        Player player = new Player("Ivan", 10);
        int actual = player.getHealth();

        assertEquals(10, actual);
    }

    @Test
    public void TestGetGunsShouldWorkProperly() {
        Player player = new Player("Ivan", 10);
        Gun gun = new Gun("Makarov", 10);
        player.addGun(gun);
        List<Gun> expected = List.of(gun);
        assertEquals(expected, player.getGuns());
    }

    @Test
    public void TestTakeDamageShouldWorkProperly() {
        Player player = new Player("Ivan", 10);
        player.takeDamage(5);
        int actual = player.getHealth();
        assertEquals(5, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void TestTakeDamageShouldTrowExceptionWhenHealthGetNegative() {
        Player player = new Player("Ivan", 0);
        player.takeDamage(10);
    }

    @Test(expected = NullPointerException.class)
    public void TestAddGunShouldTrowExceptionWhenGunIsNull() {
        Player player = new Player("Ivan", 10);
        player.addGun(null);
    }

    @Test
    public void TestAddGunShouldAddGun() {
        Player player = new Player("Ivan", 10);
        Gun gun = new Gun("Kalashnikov", 100);
        player.addGun(gun);
        assertEquals(gun, player.getGun("Kalashnikov"));
    }

    @Test
    public void TestRemoveGunShouldWorkProperlyReturnTrue() {
        Player player = new Player("Ivan", 10);
        Gun gun = new Gun("Kalashnikov", 100);
        Gun gun2 = new Gun("Makarov", 50);
        player.addGun(gun);
        player.addGun(gun2);

        boolean isRemoved = player.removeGun(gun2);
        assertTrue(isRemoved);
    }

    @Test
    public void TestRemoveGunShouldWorkProperlyReturnFalse() {
        Player player = new Player("Ivan", 10);
        Gun gun = new Gun("Kalashnikov", 100);
        Gun gun2 = new Gun("Makarov", 50);
        player.addGun(gun);


        boolean isRemoved = player.removeGun(gun2);
        assertFalse(isRemoved);
    }

    @Test
    public void TestGetGunShouldReturnGun() {
        Player player = new Player("Ivan", 10);
        Gun gun = new Gun("Kalashnikov", 100);
        player.addGun(gun);
        Gun expected = player.getGun("Kalashnikov");

        assertEquals(gun,expected);
    }
    @Test
    public void TestGetGunShouldReturnNullIfTheGunIsNull() {
        Player player = new Player("Ivan", 10);
        Gun gun = new Gun("Kalashnikov", 100);
        player.addGun(gun);
        Gun expected = player.getGun("ivo");

        assertNull(expected);
    }
}
