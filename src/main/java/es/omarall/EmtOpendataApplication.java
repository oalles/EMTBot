package es.omarall;

import org.apache.camel.component.slack.SlackComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class EmtOpendataApplication implements EnvironmentAware {

	private String slackWebhookUrl;

	public static void main(String[] args) {

		SpringApplication.run(EmtOpendataApplication.class, args);
	}

	@Bean
	public SlackComponent slack() {
		SlackComponent slack = new SlackComponent();
		slack.setWebhookUrl(this.slackWebhookUrl);
		return slack;
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.slackWebhookUrl = environment.getRequiredProperty("slack.webhook-url");
	}
}
