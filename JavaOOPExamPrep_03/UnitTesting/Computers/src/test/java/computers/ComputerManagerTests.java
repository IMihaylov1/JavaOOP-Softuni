package computers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {
    @Test

    public void TestGetComputersListShouldWork() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Chines","PC",10);
        computerManager.addComputer(computer);
        List<Computer> computers = computerManager.getComputers();
        List<Computer> comp = new ArrayList<>();
        comp.add(computer);
        Assert.assertEquals(comp,computers);
    }
    @Test
    public void TestCountShouldWorkProperly(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Chines","PC",10);
        computerManager.addComputer(computer);
        Assert.assertEquals(1,computerManager.getCount());
    }

    @Test
    public void TestAddShouldWorkProperly(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Chines","PC",10);
        computerManager.addComputer(computer);
        Assert.assertEquals(1,computerManager.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void TestAddShouldTrowExceptionProperly(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void TestAddShouldTrowExceptionIfObjectAlready(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Chines","PC",10);
        computerManager.addComputer(computer);
        computerManager.addComputer(computer);
    }
    @Test
    public void TestRemoveShouldWork(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Chines","PC",10);
        computerManager.addComputer(computer);
        computerManager.removeComputer("Chines","PC");
        Assert.assertEquals(0,computerManager.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void TestGetShouldNotWorkAndTrowException() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Chines", "PC", 10);
        computerManager.addComputer(computer);
        computerManager.getComputer(null, "PC");
    }
        @Test(expected = IllegalArgumentException.class)
        public void TestGetShouldNotWorkAndTrowExceptionTwo(){
            ComputerManager computerManager = new ComputerManager();
            Computer computer = new Computer("Chines","PC",10);
            computerManager.addComputer(computer);
            computerManager.getComputer("ivo",null);

    }
    @Test
    public void TestGetShouldNotWork(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Chines","PC",10);
        computerManager.addComputer(computer);
        Assert.assertEquals(computer,  computerManager.getComputer("Chines","PC"));

    }
    @Test(expected = IllegalArgumentException.class)
    public void TestGetByManufactureShouldNotWorkAndTrowException(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Chines","PC",10);
        computerManager.addComputer(computer);
        computerManager.getComputersByManufacturer(null);
    }
    @Test
    public void TestGetByManufactureShouldNotWork(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Chines","PC",10);
        computerManager.addComputer(computer);
        List<Computer> expected = new ArrayList<>();
        expected.add(computer);
        Assert.assertEquals(expected,computerManager.getComputersByManufacturer("Chines"));
    }


}