package nextstep.jwp.mvc.argument;

import nextstep.jwp.mvc.handler.MethodParameter;
import nextstep.jwp.webserver.request.HttpRequest;
import nextstep.jwp.webserver.request.HttpSession;
import nextstep.jwp.webserver.response.HttpResponse;

public class HttpSessionArgumentResolver implements HandlerMethodArgumentResolver{

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.isTypeOf(HttpSession.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, HttpRequest httpRequest,
            HttpResponse httpResponse) {
        return httpRequest.getSession();
    }
}
