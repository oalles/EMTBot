package es.omarall.componentes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EMTOpenDataRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("rss:{{emtopendata.rss.incidencias.url}}?splitEntries=true&consumer.delay=10000")

				.filter().method("filterBean", "filtraPorLinea")

				.bean("feedProcessor")

				.to("slack:#general?username={{slack.bot.name}}");
	}

}
