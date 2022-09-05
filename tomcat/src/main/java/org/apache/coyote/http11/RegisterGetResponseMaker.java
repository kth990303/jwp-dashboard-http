package org.apache.coyote.http11;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.coyote.http11.request.HttpRequest;
import org.apache.coyote.http11.response.ContentType;
import org.apache.coyote.http11.response.HttpResponse;
import org.apache.coyote.http11.response.HttpStatus;

public class RegisterGetResponseMaker implements ResponseMaker {

    @Override
    public String createResponse(final HttpRequest httpRequest)
            throws URISyntaxException, IOException {
        final String requestUrl = httpRequest.getRequestUrl();
        final URL resource =
                this.getClass().getClassLoader().getResource("static" + requestUrl + ".html");
        final Path path = Paths.get(resource.toURI());
        final var responseBody = new String(Files.readAllBytes(path));
        final HttpResponse httpResponse = new HttpResponse(HttpStatus.OK, responseBody, ContentType.HTML);
        return httpResponse.toString();
    }
}
