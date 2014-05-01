package is.agh.dist.mon.mok;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.common.SingleRootFileSource;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MokMain {
    private static final Logger LOGGER = Logger.getLogger(MokMain.class);

    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 8909;
    private static final String DEFAULT_FILES_ROOT = "src/main/resources";

    public static void main(String[] args) throws IOException {
        if(args.length < 3) {
            LOGGER.info("Run with args: host(" + DEFAULT_HOST + ") port(" + DEFAULT_PORT + ") filesRoot(" + DEFAULT_FILES_ROOT + ")");
        }

        String host = (args.length > 0) ? args[0] : DEFAULT_HOST;
        int port = (args.length > 1) ? Integer.parseInt(args[1]) : DEFAULT_PORT;
        final String filesRoot = (args.length > 2) ? args[2] : DEFAULT_FILES_ROOT;

        WireMockServer wireMockServer = new WireMockServer(new WireMockConfiguration() {
            @Override
            public FileSource filesRoot() {
                return new SingleRootFileSource(filesRoot);
            }
        }.port(port));
        WireMock.configureFor(host, port);
        wireMockServer.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.readLine());

        wireMockServer.stop();
    }
}
