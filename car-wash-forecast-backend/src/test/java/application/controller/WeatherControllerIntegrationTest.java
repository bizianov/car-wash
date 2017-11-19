package application.controller;

import application.service.WeatherProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherProvider weatherProvider;

    private String weatherResponse =
            "{\"coord\":{\"lon\":30.52,\"lat\":50.43},\"weather\":[{\"main\":\"Clouds\",\"description\":" +
                    "\"overcast clouds\"}],\"main\":{\"temp\":275.8,\"pressure\":1024.0,\"humidity\":100.0},\"" +
                    "clouds\":{\"all\":90}}";

    @Before
    public void init() {
        when(weatherProvider.getCurrentWeather("kiev", "UA"))
                .thenReturn(weatherResponse);
    }

    @Test
    public void currentWeather() throws Exception {
        mockMvc.perform(get("/weather/kiev/UA"))
                .andExpect(status().isOk())
                .andExpect(content().string(allOf(
                        containsString("weather"),
                        containsString("main"))));
    }
}