package by.bsu.aircompany.entity;

import by.bsu.aircompany.enums.ClassificationLevel;
import by.bsu.aircompany.enums.ExperimentalType;
import by.bsu.aircompany.enums.MilitaryType;
import by.bsu.aircompany.entity.implementation.plane.ExperimentalPlane;
import by.bsu.aircompany.entity.implementation.plane.MilitaryPlane;
import by.bsu.aircompany.entity.implementation.plane.PassengerPlane;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class AirportTest {
    private Airport airport;

    @BeforeMethod
    public void setUp() {
        List<Plane> planes = Arrays.asList(
                new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
                new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
                new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
                new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
        );
        airport = new Airport(planes);
    }

    @Test
    public void testGetTransportMilitaryPlanes() {
        airport.getTransportMilitaryPlanes().forEach(military ->
                Assert.assertSame(military.getType(), MilitaryType.TRANSPORT));
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        PassengerPlane expectedPlaneWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
        Assert.assertEquals(airport.getPassengerPlaneWithMaxPassengersCapacity(), expectedPlaneWithMaxPassengerCapacity);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.sortByMaxLoadCapacity().getPlanes();
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Assert.assertTrue(planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity()
                    <= planesSortedByMaxLoadCapacity.get(i + 1).getMaxLoadCapacity());
        }
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        AtomicBoolean hasBomber = new AtomicBoolean(false);
        airport.getBomberMilitaryPlanes().forEach(military -> {
            if (military.getType() == MilitaryType.BOMBER) {
                hasBomber.set(true);
            }
        });
        Assert.assertTrue(hasBomber.get());
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified() {
        airport.getExperimentalPlanes().forEach(experimental ->
                Assert.assertNotSame(experimental.getClassificationLevel(), ClassificationLevel.UNCLASSIFIED));
    }
}
