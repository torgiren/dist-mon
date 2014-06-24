package is.agh.dist.mon.gui.service;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import is.agh.dist.mon.api.dto.HostDto;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class, loader=AnnotationConfigContextLoader.class)
public class HostServiceRestTest {
    private static WireMockServer wireMockServer;
    
    @BeforeClass
    public static void setup() {
        wireMockServer = new WireMockServer(wireMockConfig().port(8809));
        WireMock.configureFor("localhost", 8809);
        wireMockServer.start();
    }
    
    @AfterClass
    public static void clean() {
        wireMockServer.stop();
    }
    
    @Autowired
    private HostServiceRest hostService;
    
    
    
    @Test
    public void AddHostTest() {
        HostDto hostDto = new HostDto();
        hostDto.setDowntime(1);
        hostDto.setAddress("192.168.1.2");
        
        hostService.add(hostDto);
    }
}
