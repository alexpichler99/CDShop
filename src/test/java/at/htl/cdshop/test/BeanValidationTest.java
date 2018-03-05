package at.htl.cdshop.test;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BeanValidationTest {
    @Test
    public void t001_Success() throws IOException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://localhost:8080/cd/rs/band");

        StringEntity requestEntity = new StringEntity(
                "{\"name\": \"Burzum\",\"yearFounded\": 1991}",
                "application/json",
                "UTF-8");

        try {
            post.setEntity(requestEntity);
            HttpResponse response = client.execute(post);

            assertThat(response.getStatusLine().getStatusCode(), is(HttpStatus.SC_NO_CONTENT));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t002_YearFoundedTooLong() throws IOException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://localhost:8080/cd/rs/band");

        StringEntity requestEntity = new StringEntity(
                "{\"name\": \"Burzum\",\"yearFounded\": 19911}",
                "application/json",
                "UTF-8");

        try {
            post.setEntity(requestEntity);
            HttpResponse response = client.execute(post);

            assertThat(response.getStatusLine().getStatusCode(), is(HttpStatus.SC_BAD_REQUEST));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
