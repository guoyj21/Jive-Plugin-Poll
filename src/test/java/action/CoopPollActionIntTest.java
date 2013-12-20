package action;

import com.jivesoftware.util.JiveCommunityTest;
import com.jivesoftware.util.junit.runners.Refreshable;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable(autowire = Autowire.BY_NAME)
@Refreshable.SpringContext("classpath:spring-customTestContext.xml")
public class CoopPollActionIntTest extends JiveCommunityTest {

    @Test  @Ignore
    public void perform() throws Exception {
        String url = "localhost:8080/CoopPoll";

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        HttpResponse response = client.execute(request);
    }

}
