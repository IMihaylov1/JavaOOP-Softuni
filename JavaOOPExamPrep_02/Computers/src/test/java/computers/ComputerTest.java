package computers;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerTest {

    @Test(expected = IllegalArgumentException.class)
    public void TestSetNameShouldTrowExceptionIfEmpty() {
        Computer computer = new Computer("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSetNameShouldTrowExceptionIfNull() {
        Computer computer = new Computer(null);
    }

    @Test
    public void TestSetNameShouldWork() {
        Computer computer = new Computer("Ivo");
        String actual = computer.getName();
        assertEquals("Ivo", actual);
    }

    @Test
    public void TestGetPartsShouldWork() {
        Computer computer = new Computer("Ivo");
        Part part = new Part("Hard", 20);
        computer.addPart(part);
        List<Part> actual = computer.getParts();
        List<Part> expected = List.of(part);
        assertEquals(actual, expected);
    }

    @Test
    public void TestGetTotalPriceShouldWorkProperly() {
        Computer computer = new Computer("Ivo");
        Part part = new Part("Hard", 20);
        Part part2 = new Part("Hard", 30);
        computer.addPart(part);
        computer.addPart(part2);
        assertEquals(50, computer.getTotalPrice(), 0.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddPartShouldTrowException() {
        Computer computer = new Computer("Ivo");
        computer.addPart(null);
    }

    @Test
    public void TestAddPartShouldAddPart() {
        Computer computer = new Computer("Ivo");
        Part part = new Part("Hard", 20);
        computer.addPart(part);
        assertEquals(part, computer.getPart("Hard"));
    }
    @Test
    public void TestRemovePartShouldWorkProperly(){
        Computer computer = new Computer("Ivo");
        Part part = new Part("Hard", 20);
        computer.addPart(part);
       assertTrue(computer.removePart(part));
    }
    @Test
    public void TestRemovePartReturnFalseIfNonPart(){
        Computer computer = new Computer("Ivo");
        Part part = new Part("Hard", 20);
        assertFalse(computer.removePart(part));
    }
    @Test
    public void TestGetPartByNameShouldReturnPart(){
        Computer computer = new Computer("Ivo");
        Part part = new Part("Hard", 20);
        computer.addPart(part);
        Part actual = computer.getPart("Hard");
        assertEquals(part,actual);
    }
    @Test
    public void TestGetPartByNameShouldReturnNull(){
        Computer computer = new Computer("Ivo");
        Part part = new Part("Hard", 20);
        computer.addPart(part);
        Part actual = computer.getPart("Ivo");
        assertNull(actual);
    }

}