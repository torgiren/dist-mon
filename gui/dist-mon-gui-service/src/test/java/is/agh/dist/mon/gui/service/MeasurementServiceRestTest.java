package is.agh.dist.mon.gui.service;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import is.agh.dist.mon.api.dto.ServiceDto;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class, loader=AnnotationConfigContextLoader.class)
public class MeasurementServiceRestTest {
    private static WireMockServer wireMockServer;
    
    @BeforeClass
    public static void setup() {
        wireMockServer = new WireMockServer(wireMockConfig().port(8909));
        WireMock.configureFor("localhost", 8909);
        wireMockServer.start();
    }
    
    @AfterClass
    public static void clean() {
        wireMockServer.stop();
    }
    
    @Autowired
    private MeasurementServiceRest measurementService;
    
    @Test
    public void FindAllServicesTest() {
        List<ServiceDto> services = measurementService.findAll();
        assertEquals(services.size(), 2);
    }
    
    @Test
    public void FindServiceByIdTest() {
        ServiceDto svc = measurementService.findById(3);
        assertEquals("http", svc.getName());
    }
    
}
